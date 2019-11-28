package top.viewv.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Date;
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

    public void setAreName(String name){
        areName.setText(name);
    }

    public void setAreIntime(Date date){
        areIntime.setText(date.toString());
    }

    public void setAreAge(int age){
        areAge.setText(String.valueOf(age));
    }

    public void setAreAccountId(String id){
        areAge.setText(id);
    }

    public void setBtnUpdateUser(String status) {
        btnUpdateUser.setText(status);
    }

    public void setHomeController(PersonHomeController homeController) {
        this.homeController = homeController;
    }

    public void onClickedDelUser(MouseEvent mouseEvent) throws Exception {
        String id = labUserId.getText();
        homeController.delUser(id);
    }


    public void onClickedUpdateUser(MouseEvent mouseEvent) throws Exception {
        if (btnUpdateUser.getText().equals("设为管理")){
            homeController.PromoteUser(labUserId.getText());
        }else {
            homeController.DismissUser(labUserId.getText());
        }
    }
}
