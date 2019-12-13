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
import top.viewv.model.Staff;
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

public class PersonHomeController implements Initializable {

    public ImageView userIcon;
    public JFXButton btnExit;
    public JFXButton btnAddUser;
    public JFXButton btnShowAllUser;
    public AnchorPane BasePane;
    public Label labUserName;
    public Label userId;
    public JFXTextField areAmount;
    public Label labAllM;
    public Label labAllMoney;
    public Label labD;
    public JFXTextField areAge;
    public JFXTextField areId;
    public JFXTextField areName;
    Connection conn = new Connect().getConnection();

    private HashMap<Integer, Integer> order_lists = new HashMap<Integer, Integer>();
    @FXML
    private VBox pnl_scroll;

    public PersonHomeController() throws IOException, ClassNotFoundException {
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
        Staff staff = new Staff();
        Staff[] staffs = staff.GetDepartmentStaff(conn, Staff.GetStaffID(userId.getText(), conn));

        int length = staffs.length;
        pnl_scroll.getChildren().clear();
        Node[] nodes = new Node[length];
        Node node;

        for (int i = 0; i < length; i++) {
            staff = staffs[i];
            try {
                FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(
                        Thread.currentThread().
                                getContextClassLoader().
                                getResource("data/ui/StaffItem.fxml")));
                node = loader.load();
                StaffItemController itemController = loader.getController();
                String[] type = UserAuth.getUserAuth(staff.staff_id);
                if (type[2].equals("0")) {
                    itemController.setBtnUpdateUser("设为管理");
                }else {
                    itemController.setBtnUpdateUser("取消管理");
                }
                itemController.setHomeController(this);
                itemController.setAreAccountId(staff.staff_id);
                itemController.setLabUserId(staff.staff_id);
                itemController.setAreAge(staff.age);
                itemController.setAreIntime(staff.entry_date);
                itemController.setAreName(staff.name);
                nodes[i] = node;
                pnl_scroll.getChildren().add(nodes[i]);
            } catch (IOException ex) {
                Logger.getLogger(SaleHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setlabUserId(String userid) {
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
        //1.staff doesn't exist 2.success 0.null
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
        refeshUser();
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
        int res = staff.DismissManager(conn,id);
        //1.staff不存在 2.该用户已不是管理员 3.成功
        String message = "";
        if (res == 1){
            message = "员工不存在";
        }else if(res == 2){
            message = "该用户已不是管理员";
        }else if(res == 3){
            message = "成功！";
        }
        JFXSnackbar snackbar = new JFXSnackbar(BasePane);
        snackbar.show(message, 1000);
        refeshUser();
    }


    public void onClickedAddUser(MouseEvent mouseEvent) throws Exception {
        Staff staff = new Staff();
        int res = staff.AddStaff(conn,areId.getText(),areName.getText(), Integer.parseInt(areAge.getText()));
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
    //1.staff already exists 2.success 0.null


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
