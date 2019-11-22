package top.viewv.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import top.viewv.database.Connect;
import top.viewv.model.Plan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;

public class PlanItemController {

    public Label labPlanId;
    public JFXTreeTableView PlanTable;
    public JFXButton btnDelPlan;
    public Label labPlanPtime;
    public Label labPlanStime;

    private PlanHomeController homeController;

    public void setHomeController(PlanHomeController obj){
        homeController = obj;
    }

    public void setLabPlanId(int id){
        labPlanId.setText(String.valueOf(id));
    }

    public void onClickedDelPlan(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        int planId = Integer.parseInt(labPlanId.getText());
        homeController.clearOneItem(planId);
    }

    public void setLabPlanStime(Date date){
        labPlanStime.setText(date.toString());
    }

    public void setLabPlanPtime(Date date){
        labPlanPtime.setText(date.toString());
    }



}
