package top.viewv.controller;

import javafx.scene.control.Label;

import java.text.DecimalFormat;

public class PlanListItemController {
    public Label labProductId;
    public Label labProductName;
    public Label labAmount;
    public Label labLine;


    public void setLabAmount(int amount){
        labAmount.setText(String.valueOf(amount));
    }

    public void setLabProductId(int id){
        labProductId.setText(String.valueOf(id));
    }

    public void setLabProductName(String name){
        labProductName.setText(name);
    }

    public void setLabLine(int line){
        labLine.setText(String.valueOf(line));
    }
}
