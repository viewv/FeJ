package top.viewv.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class IsItemController {

    public Label labProductName;
    public JFXTextField tfxNumberInput;
    public JFXButton btnAddToShop;
    public Label labTime;
    public Label labAmount;
    public Label labProductId;
    public Label labDescrption;
    public Label labStaff;

    private DeveHomeController homeController;

    public void onClickedbtnAddToProduct(MouseEvent mouseEvent) {
        homeController.addtoReceipe(this);
    }

    public void setLabProductName(String Name) {
        this.labProductName.setText(Name);
    }

    public void setLabTime(int date) {
        labTime.setText(String.valueOf(date));
    }

    public void setLabAmount(int amount){
        labAmount.setText(String.valueOf(amount));
    }

    public void setLabProductId(int id) {
        labProductId.setText(String.valueOf(id));
    }

    public void setLabStaff(String Staff) {
        labStaff.setText(Staff);
    }

    public void setHomeController(DeveHomeController homeController) {
        this.homeController = homeController;
    }

}
