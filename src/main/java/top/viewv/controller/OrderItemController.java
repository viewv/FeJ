package top.viewv.controller;

import com.jfoenix.controls.JFXProgressBar;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderItemController implements Initializable {
    public JFXProgressBar pbarOrder;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pbarOrder.setProgress(0.7);
        System.out.println("Order Open");
    }
}
