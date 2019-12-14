package top.viewv.controller;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import top.viewv.api.Gravatar;
import top.viewv.api.Serialize;
import top.viewv.api.UserAuth;
import top.viewv.database.Connect;
import top.viewv.model.Record;
import top.viewv.model.Staff;
import top.viewv.model.Worker;
import top.viewv.view.StageManager;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author oXCToo
 */
// !Thank you very much! oXCToo!

public class WorkHomeController implements Initializable {

    public ImageView userIcon;
    public JFXButton btnExit;
    public JFXButton btnAddUser;
    public JFXButton btnShowAllUser;
    public AnchorPane BasePane;
    public Label labUserName;
    public Label userId;
    public Label labAllM;
    public Label labD;
    public JFXTextField areAge;
    public JFXTextField areId;
    public JFXTextField areName;
    Connection conn = new Connect().getConnection();

    private HashMap<Integer, Integer> order_lists = new HashMap<Integer, Integer>();
    @FXML
    private VBox pnl_scroll;

    public WorkHomeController() throws IOException, ClassNotFoundException {
    }

    public void onClickedbtnShowAllUsers(MouseEvent mouseEvent) throws Exception {
        refeshUser();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Serialize.ser(order_lists, "order.ser");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refeshUser() throws Exception {

        Worker worker = new Worker();
        System.out.println(userId.getText());
        String currentId = Staff.GetStaffID(userId.getText(),conn);
        Worker[] workers = Worker.GetWorker(conn,currentId);

        int length = workers.length;
        pnl_scroll.getChildren().clear();
        Node[] nodes = new Node[length];
        Node node;

        for (int i = 0; i < length; i++) {
            worker = workers[i];
            try {
                FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(
                        Thread.currentThread().
                                getContextClassLoader().
                                getResource("data/ui/WorkItem.fxml")));
                node = loader.load();
                WorkerItemController itemController = loader.getController();
                String[] type = UserAuth.getUserAuth(worker.me.staff_id);
                if (type[2].equals("0")) {
                    itemController.setBtnUpdateUser("设为管理");
                }else {
                    itemController.setBtnUpdateUser("取消管理");
                }
                itemController.setHomeController(this);
                itemController.setAreAccountId(worker.me.staff_id);
                itemController.setLabUserId(worker.me.staff_id);
                itemController.setAreAge(worker.me.age);
                itemController.setAreIntime(worker.me.entry_date);
                itemController.setAreName(worker.me.name);
                itemController.setAreWorkdshop(worker.workshop);
                nodes[i] = node;
                pnl_scroll.getChildren().add(nodes[i]);
            } catch (IOException ex) {
                Logger.getLogger(SaleHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setlabUserId(String userid) {
        System.out.println(userid);
        userId.setText(userid);
    }

    public void setLabUserName(String userName) {
        labUserName.setText(userName);
    }

    public void setUserIcon(String email) {
        userIcon.setImage(Gravatar.imageFromMail(email));
    }


    public void onClickedbtnExit() throws IOException {
        MainController secondControl = (MainController) StageManager.CONTROLLER.get("index");
        secondControl.setTranDataToIndex("第三个窗口的数据");
        //如果本窗口还使用该控制器先不remove这个控制器;
        //StageManager.CONTROLLER.remove("secondControl");

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("data/ui/Main.fxml")));
        stage.setTitle("Index");
        stage.setScene(new Scene(root));
        stage.show();
        //将第二个窗口保存到map中
        StageManager.STAGE.put("second", stage);
        //将本窗口保存到map中
        StageManager.CONTROLLER.put("index", this);
        //关闭本窗口
        Stage index = (Stage) btnExit.getScene().getWindow();
        index.close();
    }

    public void delUser(String id) throws Exception {
        Staff staff = new Staff();
        int res =  staff.DeleteStaff(conn,id);
        String message = "";
        if (res == 1){
            message = "员工不存在";
        }else if(res == 2){
            message = "成功删除用户！";
        }else if(res == 0){
            message = "不存在这个ID";
        }
        JFXSnackbar snackbar = new JFXSnackbar(BasePane);
        snackbar.show(message, 1000);
        refeshUser();
    }

    public void PromoteUser(String id) throws Exception {
        Staff staff = new Staff();
        int res = staff.PromoteStaff(conn,id);
        //0.null,1.staff doesn't exist,2.already a manager,3.success
        String message = "";
        if (res == 1){
            message = "员工不存在";
        }else if(res == 2){
            message = "该员工已经是管理员了！";
        }else if(res == 0){
            message = "不存在这个ID";
        }else if(res == 3){
            message = "成功！";
        }

        JFXSnackbar snackbar = new JFXSnackbar(BasePane);
        snackbar.show(message, 1000);
        refeshUser();
    }

    public void DismissUser(String id) throws Exception {
        Staff staff = new Staff();
        staff.DismissManager(conn,id);
        refeshUser();
    }


    public void onClickedAddUser(MouseEvent mouseEvent) throws Exception {
        Staff staff = new Staff();
        int res =  staff.AddStaff(conn,areId.getText(),areName.getText(), Integer.parseInt(areAge.getText()));
        String message = "";
        if (res == 1){
            message = "已经有此员工";
        }else if(res == 2){
            message = "成功！";
        }else if(res == 0){
            message = "不存在这个ID";
        }
        JFXSnackbar snackbar = new JFXSnackbar(BasePane);
        snackbar.show(message, 1000);
        refeshUser();
    }

    public void allocWork(String id, int workshop) throws Exception {
        int res = Worker.AllocateWorkshop(conn,id,workshop);
        String message = "";
        //1.无此人 2.错误车间 3.成功
        if (res == 1){
            message = "不存在此员工";
        }else if(res == 2){
            message = "车间输入错误";
        }else if(res == 3){
            message = "成功分配工作！";
        }
        JFXSnackbar snackbar = new JFXSnackbar(BasePane);
        snackbar.show(message, 1000);

        //System.out.println("Alloc"+res);
        refeshUser();
    }

    public void onClickedbtnAllrec(MouseEvent mouseEvent) {
        refeshRecord();
    }

    private void refeshRecord() {
        Record record = new Record();
        pnl_scroll.getChildren().clear();

        int length;
        Record[] records = new Record[0];

        String id = Staff.GetStaffID(userId.getText(),conn);
        char [] user = id.toCharArray();

        int workshop = user[3]-48;

        try {
            records = Worker.CheckPlanContent(conn,workshop);
        } catch (Exception e) {
            e.printStackTrace();
            length = 0;
            JFXSnackbar snackbar = new JFXSnackbar(BasePane);
            snackbar.show("没有记录！", 5000);
        }

        length = records.length;

        Node[] nodes = new Node[length];
        Node node;

        for (int i = 0; i < length; i++) {
            record = records[i];
            try {
                FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(
                        Thread.currentThread().
                                getContextClassLoader().
                                getResource("data/ui/RecordItem.fxml")));
                node = loader.load();
                RecordItemController itemController = loader.getController();
                itemController.setLabAmount(record.amount);
                itemController.setLabName(record.name);
                itemController.setLabUserId(record.id);
                nodes[i] = node;
                pnl_scroll.getChildren().add(nodes[i]);
            } catch (IOException ex) {
                Logger.getLogger(SaleHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void onClickedbtnProduce(MouseEvent mouseEvent) {
        refeshNote();
    }

    private void refeshNote() {
        Record record = new Record();

        String id = Staff.GetStaffID(userId.getText(),conn);
        char [] user = id.toCharArray();
        int workshop = user[3]-48;
        int length;
        Record[] records = Worker.CheckProductContent(conn,workshop);

        if (record == null){
            length = 0;
            JFXSnackbar snackbar = new JFXSnackbar(BasePane);
            snackbar.show("没有记录！", 5000);
        }

        length = records.length;
        pnl_scroll.getChildren().clear();
        Node[] nodes = new Node[length];
        Node node;

        for (int i = 0; i < length; i++) {
            record = records[i];
            try {
                FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(
                        Thread.currentThread().
                                getContextClassLoader().
                                getResource("data/ui/RecordItem.fxml")));
                node = loader.load();
                RecordItemController itemController = loader.getController();
                itemController.setLabAmount(record.amount);
                itemController.setLabName(record.name);
                itemController.setLabUserId(record.id);
                nodes[i] = node;
                pnl_scroll.getChildren().add(nodes[i]);
            } catch (IOException ex) {
                Logger.getLogger(SaleHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void onClickedBtnInfo(MouseEvent mouseEvent) throws Exception {
        Switch();
    }

    public void Switch() throws Exception {

        Stage stage = new Stage();
        System.out.println("Start Login");

        FXMLLoader loader = new
                FXMLLoader(Objects.requireNonNull(getClass()).getClassLoader()
                .getResource("data/ui/AccountInfo.fxml"));

        Parent root = loader.load();
        stage.setTitle("Account Home");
        stage.setScene(new Scene(root));
        stage.show();
        AccountInfoController homeControl = loader.getController();
        homeControl.setAccId(userId.getText());
        homeControl.refresh();
        //将第二个窗口保存到map中
        StageManager.STAGE.put("info", stage);
        //将本窗口保存到map中
        StageManager.CONTROLLER.put("second", this);
        //关闭本窗口
        //Stage index = (Stage) loginPane.getScene().getWindow();
        //index.close();
    }
}
