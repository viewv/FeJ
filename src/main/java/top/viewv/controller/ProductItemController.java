package top.viewv.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductItemController implements Initializable {

    public Label labProductName;
    public Label labPrice;
    public Label labProductId;
    public Label labProductRtime;
    public Label labDescrption;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Items Open");
    }

    public void setLabPrice(float message) {
        //Display the message
        labPrice.setText(String.valueOf(message));
    }

    public void setLabProductName(String message) {
        //Display the message
        labProductName.setText(message);
    }

    public void setLabProductId(int message) {
        labProductId.setText("ID:" + message);
    }

    public void setLabProductRtime(int message) {
        labProductRtime.setText(String.valueOf(message));
    }

    public void setLabDescrption(String message){
        labDescrption.setText(message);
    }

}
