package top.viewv.controller;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.text.DecimalFormat;

public class ShopListItemController {
    public Label labSinglePrice;
    public Label labAmount;
    public Label labProductId;
    public Label labAllPrice;
    public Label labProductName;

    public void setLabSinglePrice(float price){
        labSinglePrice.setText(String.valueOf(price));
    }

    public void setLabAmount(int amount){
        labAmount.setText(String.valueOf(amount));
    }

    public void setLabProductId(int id){
        labProductId.setText(String.valueOf(id));
    }

    public void setLabProductName(String name){
        labProductName.setText(name);
    }

    public void setLabAllPrice(){
        float price = Float.parseFloat(labSinglePrice.getText());
        int amount = Integer.parseInt(labAmount.getText());
        DecimalFormat df = new DecimalFormat("0.00");
        labAllPrice.setText(df.format(price * amount));
    }
}
