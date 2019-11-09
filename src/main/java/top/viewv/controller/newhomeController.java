package top.viewv.controller;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 *
 * @author oXCToo
 */
public class newhomeController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private VBox pnl_scroll;

    @FXML
    private void handleButtonAction(MouseEvent event) {
        refreshNodes();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refreshNodes();
    }

    private void refreshNodes()
    {
        pnl_scroll.getChildren().clear();

        Node [] nodes = new  Node[15];
        Node node;

        for(int i = 0; i<5; i++)
        {
            try {
                FXMLLoader loader = new
                        FXMLLoader(Objects.requireNonNull(
                                Thread.currentThread().
                                        getContextClassLoader().
                                        getResource("data/ProductItem.fxml")));
                node = loader.load();
                //调用下面的函数可以得到控制器
                ProductItemController productItemController = loader.getController();
                productItemController.setLabPrice("170");
                //node = FXMLLoader.load(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("data/ProductItem.fxml")));
                nodes[i] = node;
                pnl_scroll.getChildren().add(nodes[i]);
            } catch (IOException ex) {
                Logger.getLogger(newhomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
