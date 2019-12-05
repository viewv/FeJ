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
import top.viewv.database.Connect;
import top.viewv.model.Ingredient_storage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.Objects;
import java.util.ResourceBundle;
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
    public JFXButton btnCheckAll;
    public JFXTextField arep;
    public JFXTextField area;
    public JFXTextField areo;
    public JFXTextField arel;
    public JFXTextField areorder;

    Connection conn = new Connect().getConnection();

    @FXML
    private VBox pnl_scroll;
    Ingredient_storage[] product_storages;

    public IStorageHomeController() throws IOException, ClassNotFoundException {
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
                nodes[i] = node;
                pnl_scroll.getChildren().add(nodes[i]);
                //删除所有节点，有点残忍，还是隐藏比较好
                //pnl_scroll.getChildren().removeAll();
                i++;
            } catch (IOException ex) {
                Logger.getLogger(NewHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void out(int ingredient_id,int amount){
        Ingredient_storage product_storage = new Ingredient_storage();
        product_storage.OutStorage(conn,ingredient_id,amount,userId.getText());
    }

    public void onClickedbtnShowAllProduct(MouseEvent mouseEvent) {
        refrash();
    }


    public void onClickedPin(MouseEvent mouseEvent) {
        Ingredient_storage product_storage = new Ingredient_storage();
        product_storage.EnStorage(conn,Integer.parseInt(arel.getText()),Integer.parseInt(area.getText()),userId.getText());
        refrash();
    }
}
