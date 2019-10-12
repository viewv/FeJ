package top.viewv.controller;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import top.viewv.view.StageManager;

public class MainController implements Initializable {

    @FXML Button btnsignup;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        try {
            System.out.println("Hello World");
        }catch (Exception ex){
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

}
