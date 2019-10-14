package top.viewv.controller;

import com.jfoenix.controls.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import top.viewv.database.Login;
import top.viewv.view.StageManager;


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
    @FXML
    Button testBtn;

    private String tranDataToIndex;

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

    public void testSwitch(MouseEvent mouseEvent) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("data/NewLogin.fxml")));
        stage.setTitle("第二个窗口");
        stage.setScene(new Scene(root));
        stage.show();
        //将第二个窗口保存到map中
        StageManager.STAGE.put("second", stage);
        //将本窗口保存到map中
        StageManager.CONTROLLER.put("index", this);
        //关闭本窗口
        Stage index = (Stage) testBtn.getScene().getWindow();
        index.close();
    }


    public String getTranDataToIndex() {
        return tranDataToIndex;
    }

    public void setTranDataToIndex(String tranDataToIndex) {
        this.tranDataToIndex = tranDataToIndex;
    }
}