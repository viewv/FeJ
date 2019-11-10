package top.viewv.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ProductItemController implements Initializable  {

    public Label labProductName;
    public Label labPrice;
    public Label labProductId;
    public JFXButton btnShowRecipe;
    public Label labProductRtime;

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

    public void setLabProductId(int message){
        labProductId.setText("ID:"+ message);
    }

    public void onClickedshoqRecipe(MouseEvent mouseEvent) {
        System.out.println("Show Recipe");
    }

    public void setLabProductRtime(int message){
        labProductRtime.setText(String.valueOf(message));
    }
}
