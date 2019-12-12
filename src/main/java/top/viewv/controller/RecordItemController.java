package top.viewv.controller;


import javafx.scene.control.Label;

public class RecordItemController {
    public Label labAmount;
    public Label labUserId;
    public Label labName;

    public void setLabAmount(int amount) {
        this.labAmount.setText(String.valueOf(amount));
    }

    public void setLabName(String name) {
        this.labName.setText(name);
    }

    public void setLabUserId(int id) {
        this.labUserId.setText(String.valueOf(id));
    }
}
