package top.viewv.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class PlanItemController {

    public Label labPlanId;
    public JFXTreeTableView PlanTable;
    public JFXButton btnDelPlan;

    public void setLabPlanId(int id){
        labPlanId.setText(String.valueOf(id));
    }

    public void onClickedDelPlan(MouseEvent mouseEvent) {
        int planId = Integer.parseInt(labPlanId.getText());
        //TODO Del Plan
    }
}
