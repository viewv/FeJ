package top.viewv.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import top.viewv.api.Gravatar;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class IStorageItemController implements Initializable {
    public Label labUserId;
    public JFXButton btnDelUser;
    public JFXTextField AreaAmount;
    public JFXTextField AreaOut;

    public int id;
    public Date date;
    public int ingredient_id;
    public int amount;
    public String staff_id;

    private IStorageHomeController homeController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }



    public void setLabUserId(int id){
        labUserId.setText(String.valueOf(id));
    }

    public void setAreaAmount(int amount){
        AreaAmount.setText(String.valueOf(amount));
    }

    public void setExtra(int id,Date date,int ingredient_id,int amount,String staff_id){
        this.id = id;
        this.date = date;
        this.ingredient_id = ingredient_id;
        this.amount = amount;
        this.staff_id = staff_id;
    }

    public void setHomeController(IStorageHomeController homeController) {
        this.homeController = homeController;
    }


    public void onClinckOut(MouseEvent mouseEvent) {
        int amount = Integer.parseInt(AreaAmount.getText());
        homeController.out(ingredient_id,amount);
    }
}
