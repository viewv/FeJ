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
import top.viewv.api.Name;
import top.viewv.database.Connect;
import top.viewv.model.Ingredient_storage;
import top.viewv.model.Product_storage;
import top.viewv.model.Staff;
import top.viewv.view.StageManager;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.HashSet;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author oXCToo
 */
// !Thank you very much! oXCToo!

public class IStorageHomeController implements Initializable {

    public ImageView userIcon;
    public JFXButton btnExit;
    public AnchorPane BasePane;
    public Label labUserName;
    public Label userId;
    public JFXTextField area;
    public JFXTextField arel;
    public JFXTextField areaID;


    Connection conn = new Connect().getConnection();

    @FXML
    private VBox pnl_scroll;
    Ingredient_storage[] product_storages;

    public IStorageHomeController() throws IOException, ClassNotFoundException {
    }

    public void setlabUserId(String userid) {
        userId.setText(userid);
    }
    public void setUserIcon(String email) {
        userIcon.setImage(Gravatar.imageFromMail(email));
    }
    public void setLabUserName(String userName) {
        labUserName.setText(userName);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            refrash();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void refrash(){
        pnl_scroll.getChildren().clear();
        Ingredient_storage product_storage= new Ingredient_storage();
        product_storages = product_storage.GetAll(conn);
        int length = product_storages.length;
        Node[] nodes = new Node[length];
        Node node;
        Set<Integer> hSet = new HashSet<Integer>();

        int flag = 1;
        int[] shounldDistory = Ingredient_storage.CheckDestroy(conn);
        if (shounldDistory == null){
            flag = 0;
        }else {
            for (int x : shounldDistory)
                hSet.add(x);
        }

        System.out.println(hSet);

        for (int i = 0;i<length;i++) {
            try {
                FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(
                        Thread.currentThread().
                                getContextClassLoader().
                                getResource("data/ui/IStorageItem.fxml")));
                node = loader.load();
                product_storage = product_storages[i];
                IStorageItemController shopListItemController = loader.getController();
                shopListItemController.setLabUserId(product_storage.id);
                shopListItemController.setHomeController(this);
                shopListItemController.setExtra(product_storage.id,product_storage.date,product_storage.ingredient_id,product_storage.amount,product_storage.staff_id);
                shopListItemController.setAreaAmount(product_storage.amount);
                shopListItemController.setLabStaffid();
                String name = Name.GetIname(conn,product_storage.ingredient_id);
                shopListItemController.setLabProductName(name);
                if (flag != 0){
                    if (hSet.contains(product_storage.ingredient_id)){
                        shopListItemController.setBtnCleanVis(true);
                    }
                }
                nodes[i] = node;
                pnl_scroll.getChildren().add(nodes[i]);
                //删除所有节点，有点残忍，还是隐藏比较好
                //pnl_scroll.getChildren().removeAll();
            } catch (IOException ex) {
                Logger.getLogger(NewHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void out(int ingredient_id, int amount, String text){
        Ingredient_storage product_storage = new Ingredient_storage();

        int res= product_storage.OutStorage(conn,ingredient_id,amount,text);

        String message = "";
        if (res == 0){
            message = "没有这个ID！";
        }else if(res == 1){
            message = "原料不存在！";
        }else if(res == 2){
            message = "原料数量不合法";
        }else if(res == 3){
            message = "不存在此员工ID";
        }else if(res == 4){
            message = "成功！";
        }

        JFXSnackbar snackbar = new JFXSnackbar(BasePane);
        snackbar.show(message, 1000);
        refrash();
    }

    public void onClickedbtnShowAllProduct(MouseEvent mouseEvent) {
        refrash();
    }


    public void onClickedPin(MouseEvent mouseEvent) {
        Ingredient_storage product_storage = new Ingredient_storage();
        String id = Staff.GetStaffID(userId.getText(),conn);
        int res =  product_storage.EnStorage(conn,Integer.parseInt(arel.getText()),Integer.parseInt(area.getText()),id);
        //0.null 1.ingredient doesn't exist 2.amount error 3.staff doesn't exist 4.success

        String message = "";
        if (res == 0){
            message = "没有这个ID！";
        }else if(res == 1){
            message = "原料不存在！";
        }else if(res == 2){
            message = "原料数量不合法";
        }else if(res == 3){
            message = "不存在此员工ID";
        }else if(res == 4){
            message = "成功！";
        }

        JFXSnackbar snackbar = new JFXSnackbar(BasePane);
        snackbar.show(message, 1000);
        refrash();
    }

    public void onClickExit(MouseEvent mouseEvent) throws IOException {
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

    public void distory(int id) {
        Ingredient_storage.DestroyItem(conn,id);
        JFXSnackbar snackbar = new JFXSnackbar(BasePane);
        snackbar.show("销毁成功！", 1000);
        refrash();
    }

    public void onClickedbtnOutIn(MouseEvent mouseEvent) {
        pnl_scroll.getChildren().clear();
        Ingredient_storage product_storage= new Ingredient_storage();
        product_storages = product_storage.GetOut(conn);
        int length = product_storages.length;
        Node[] nodes = new Node[length];
        Node node;

        for (int i = 0;i<length;i++) {
            try {
                FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(
                        Thread.currentThread().
                                getContextClassLoader().
                                getResource("data/ui/IStorageItem.fxml")));
                node = loader.load();
                product_storage = product_storages[i];
                IStorageItemController shopListItemController = loader.getController();
                shopListItemController.setLabUserId(product_storage.id);
                shopListItemController.setHomeController(this);
                shopListItemController.setExtra(product_storage.id,product_storage.date,product_storage.ingredient_id,product_storage.amount,product_storage.staff_id);
                shopListItemController.setAreaAmount(product_storage.amount);
                shopListItemController.setLabStaffid();
                String name = Name.GetIname(conn,product_storage.ingredient_id);
                shopListItemController.setLabProductName(name);
                shopListItemController.btnDelUser.setVisible(false);
                shopListItemController.labnotinfo.setVisible(false);
                shopListItemController.AreaOut.setVisible(false);
                nodes[i] = node;
                pnl_scroll.getChildren().add(nodes[i]);
                //删除所有节点，有点残忍，还是隐藏比较好
                //pnl_scroll.getChildren().removeAll();
            } catch (IOException ex) {
                Logger.getLogger(NewHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void onClickedXBtnInfo(MouseEvent mouseEvent) throws Exception {
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
