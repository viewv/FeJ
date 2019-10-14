package top.viewv.controller;

import com.jfoenix.controls.*;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import top.viewv.database.Login;


public class MainController implements Initializable {

    @FXML
    Button enterButton;
    @FXML
    TextField userInput;
    @FXML
    TextField passwordInput;
    @FXML
    AnchorPane loginPane;
    @FXML
    HBox BottomPane;
    @FXML
    StackPane InputPane;
    @FXML
    Group GroupSignup;
    @FXML
    Group GroupLogin;
    @FXML
    Button regButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("FeJ Open");

        GroupLogin.setVisible(true);
        GroupSignup.setVisible(false);
    }

    @FXML
    public void GetInput(MouseEvent mouseEvent) {

        String user_id = userInput.getText().trim();
        String password = passwordInput.getText().trim();
        Login login = new Login();

        String result = login.LoginFun(user_id, password);
        String icon;


        if (result != null) {
            if (result == "account_error") {
                System.out.println(result);

            } else if (result == "password_error") {
                System.out.println(result);
            } else {
                icon = result;
                System.out.println(icon);
            }
        } else {
            result = "Wrong!";
        }

        JFXSnackbar snackbar = new JFXSnackbar(BottomPane);

        snackbar.show(result, 1000);
    }


    public void RegInput(MouseEvent mouseEvent) {
    }

    public void LoginTab(MouseEvent mouseEvent) {
        GroupSignup.setVisible(false);
        GroupLogin.setVisible(true);
    }

    public void SignupTab(MouseEvent mouseEvent) {
        GroupLogin.setVisible(false);
        GroupSignup.setVisible(true);
    }
}