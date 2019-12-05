package top.viewv.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import java.sql.Date;

import java.net.URL;
import java.util.ResourceBundle;

public class StorageItemController implements Initializable {
    public Label labUserId;
    public JFXButton btnDelUser;
    public JFXTextField AreaAmount;
    public JFXTextField AreaOut;

    public int order_id;
    public int product_id;
    public int amount;
    public String staff_id;
    public int workshop_id;
    public int plan_id;
    public Date product_time;

    private StorageHomeController homeController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setLabUserId(int id){
        labUserId.setText(String.valueOf(id));
    }

    public void setAreaAmount(int amount){
        AreaAmount.setText(String.valueOf(amount));
    }

    public void setExtra(int order_id,int product_id,int amount,String staff_id,int workshop_id,int plan_id,Date date){
        this.order_id = order_id;
        this.product_id = product_id;
        this.amount = amount;
        this.staff_id = staff_id;
        this.workshop_id = workshop_id;
        this.plan_id = plan_id;
        this.product_time = date;
    }

    public void setHomeController(StorageHomeController homeController) {
        this.homeController = homeController;
    }


    public void onClinckOut(MouseEvent mouseEvent) {
        int amount = Integer.parseInt(AreaAmount.getText());
        homeController.out(order_id,product_id,amount);
    }
}
