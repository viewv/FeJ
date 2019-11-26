package top.viewv.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class StaffItemController implements Initializable {
    public Label labUserId;
    public JFXButton btnDelUser;
    public JFXButton btnUpdateUser;
    public JFXTextField areAccountId;
    public JFXTextField areIntime;
    public JFXTextField areAge;
    public JFXTextField areName;

    private PersonHomeController homeController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setLabUserId(String id){
        labUserId.setText(id);
    }

    public void setLabBalance(float balance){
        labBalance.setText(String.valueOf(balance));
    }

    public void setLabCredit(int credit){
        AreaCredit.setText(String.valueOf(credit));
    }

    public void setHomeController(PersonHomeController homeController) {
        this.homeController = homeController;
    }

    public void onClickedDelUser(MouseEvent mouseEvent) throws Exception {
        String id = labUserId.getText();
        homeController.delUser(id);
    }

    public void onClickedUpdateUser(MouseEvent mouseEvent) throws Exception {
    }
}
