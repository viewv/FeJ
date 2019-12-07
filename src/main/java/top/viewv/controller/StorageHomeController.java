package top.viewv.controller;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import top.viewv.api.Gravatar;
import top.viewv.database.Connect;
import top.viewv.model.Product_storage;
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
        product_storages = product_storage.GetAll(conn);
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
        product_storage.OutStorage(conn,1,productId,amount);
        refrash();
    }

    public void onClickedbtnShowAllProduct(MouseEvent mouseEvent) {
        refrash();
    }

    public void onclickedOin(MouseEvent mouseEvent) {
        Product_storage product_storage = new Product_storage();
        product_storage.EnStorage2(conn, Integer.parseInt(areorder.getText()));
        refrash();
    }


    public void onClickedPin(MouseEvent mouseEvent) {
        Product_storage product_storage = new Product_storage();
        product_storage.EnStorage1(conn,Integer.parseInt(arep.getText()),
                Integer.parseInt(area.getText()),
                userId.getText(),
                Integer.parseInt(arel.getText()),
                Integer.parseInt(areo.getText())
        );
        refrash();
    }
}
