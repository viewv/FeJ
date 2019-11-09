package top.viewv.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ProductItemController implements Initializable  {

    public Label labProductName;
    public Label labPrice;
    public Label labProductId;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("FeJ Open");
    }

    public void setLabPrice(String message) {
        //Display the message
        labPrice.setText(message);
    }
}
