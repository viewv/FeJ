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
import top.viewv.database.Connect;
import top.viewv.model.Ingredient_storage;
import top.viewv.model.Product_storage;
import top.viewv.model.Staff;
import top.viewv.view.StageManager;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author oXCToo
 */
// !Thank you very much! oXCToo!

public class StorageHomeController implements Initializable {

    public ImageView userIcon;
    public JFXButton btnExit;
    public AnchorPane BasePane;
    public Label labUserName;
    public Label userId;
    public JFXButton btnCheckAll;
    public JFXButton btnClean;
    public JFXTextField arep;
    public JFXTextField area;
    public JFXTextField areo;
    public JFXTextField arel;
    public JFXTextField areorder;
    public JFXTextField areConfirm;

    Connection conn = new Connect().getConnection();

    @FXML
    private VBox pnl_scroll;
    Product_storage[] product_storages;

    public StorageHomeController() throws IOException, ClassNotFoundException {
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
        Product_storage product_storage = new Product_storage();
        product_storages = product_storage.GetStorage(conn);

        HashMap<Integer,Integer> hMap = new HashMap<Integer,Integer>();

        int flag = 1;
        int[] shounldDistory = Product_storage.CheckDestroy(conn);

        int[] indexs = Product_storage.CheckIndex(conn,shounldDistory);
        int l = indexs.length;
        if (indexs== null || shounldDistory == null ){
            flag = 0;
        }else {
            for(int i=0;i<l;i++){
                hMap.put(indexs[i],shounldDistory[i]);
            }
        }

        int length = product_storages.length;
        Node[] nodes = new Node[length];
        Node node;

        for (int i = 0;i<length;i++) {
            try {
                FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(
                        Thread.currentThread().
                                getContextClassLoader().
                                getResource("data/ui/StorageItem.fxml")));
                node = loader.load();
                product_storage = product_storages[i];
                StorageItemController shopListItemController = loader.getController();
                shopListItemController.setLabUserId(product_storage.product_id);
                shopListItemController.setHomeController(this);
                shopListItemController.setExtra(product_storage.order_id,
                                                product_storage.product_id,
                                                product_storage.amount,
                                                product_storage.staff_id,
                                                product_storage.workshop_id,
                                                product_storage.plan_id,
                                                product_storage.product_time);
                shopListItemController.setAreaAmount(product_storage.amount);
                shopListItemController.setvis(true);
                if (flag != 0){
                    if (hMap.containsKey(i-1)){
                        shopListItemController.setBtnCleanVis(true);
                        shopListItemController.setReal_id(hMap.get(i-1));
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

    public void out(int orderId,int productId,int amount){
        Product_storage product_storage = new Product_storage();
        //product_storage.OutStorage(conn,orderId,productId,amount);
        int res = product_storage.OutStorage(conn,productId,orderId,amount);
        String message = "";
        if (res == 1){
            message = "订单号错误";
        }else if(res == 2){
            message = "成功";
        }
        JFXSnackbar snackbar = new JFXSnackbar(BasePane);
        snackbar.show(message, 1000);
        refrash();
    }

    public void onClickedbtnShowAllProduct(MouseEvent mouseEvent) {
        refrash();
    }

    public void onclickedOin(MouseEvent mouseEvent) {
        Product_storage product_storage = new Product_storage();
        int res = product_storage.EnStorage2(conn, Integer.parseInt(areorder.getText()));
        //1.订单号错误 2.成功
        String message = "";
        if (res == 1){
            message = "订单号错误";
        }else if(res == 2){
            message = "成功";
        }
        JFXSnackbar snackbar = new JFXSnackbar(BasePane);
        snackbar.show(message, 1000);
        refrash();
    }

    public void onClickedPin(MouseEvent mouseEvent) {
        Product_storage product_storage = new Product_storage();
        String id = Staff.GetStaffID(userId.getText(),conn);
        int res = product_storage.EnStorage1(conn,Integer.parseInt(arep.getText()),
                Integer.parseInt(area.getText()),
                id,
                Integer.parseInt(arel.getText()),
                Integer.parseInt(areo.getText())
        );
        //EnStorage1:1.产品不存在 2.数量非法 3.员工不存在 4.车间不存在 5.计划不存在 6。成功
        String message = "";
        if (res == 1){
            message = "产品不存在";
        }else if(res == 2){
            message = "数量非法";
        }else if(res == 3){
            message = "员工不存在";
        }else if(res == 4){
            message = "车间不存在";
        }else if(res == 5){
            message = "计划不存在";
        }else if(res == 6){
            message = "成功";
        }
        JFXSnackbar snackbar = new JFXSnackbar(BasePane);
        snackbar.show(message, 1000);
        System.out.println(res);
        refrash();
    }

    public void onClickedbtnAlout(MouseEvent mouseEvent) {
        refrashOrder();
    }

    void refrashOrder(){
        pnl_scroll.getChildren().clear();
        Product_storage product_storage = new Product_storage();
        product_storages = product_storage.TraceOrderProduct(conn);
        int length = product_storages.length;
        Node[] nodes = new Node[length];
        Node node;
        for (int i = 0;i<length;i++) {
            try {
                FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(
                        Thread.currentThread().
                                getContextClassLoader().
                                getResource("data/ui/StorageItem.fxml")));
                node = loader.load();
                product_storage = product_storages[i];
                StorageItemController shopListItemController = loader.getController();
                shopListItemController.setLabUserId(product_storage.product_id);
                shopListItemController.setHomeController(this);

                shopListItemController.setExtra(
                        product_storage.order_id,
                        product_storage.product_id,
                        product_storage.amount,
                        product_storage.staff_id,
                        product_storage.workshop_id,
                        product_storage.plan_id,
                        product_storage.product_time);
                shopListItemController.setAreaAmount(product_storage.amount);
                shopListItemController.setvis(false);
                shopListItemController.setvisout(false);
                nodes[i] = node;
                pnl_scroll.getChildren().add(nodes[i]);
                //删除所有节点，有点残忍，还是隐藏比较好
                //pnl_scroll.getChildren().removeAll();
            } catch (IOException ex) {
                Logger.getLogger(NewHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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

    public void clean(int product_id) {
        Product_storage.DestroyItem(conn,product_id);
        refrash();
    }

    public void onclickedConfirm(MouseEvent mouseEvent) {
        int orderId = Integer.parseInt(areConfirm.getText());
        int res =  Product_storage.cornfirm(conn, orderId);
        //确认当前订单全部出库操作已经完成的接口 1.订单非法 2.完成
        String message = "";
        if (res == 1){
            message = "订单非法！";
        }else if(res == 2){
            message = "确认交付完毕！";
        }
        JFXSnackbar snackbar = new JFXSnackbar(BasePane);
        snackbar.show(message, 1000);

        System.out.println("Confirm"+res);
        refrash();
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
