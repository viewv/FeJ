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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import top.viewv.database.Login;
import top.viewv.database.Signup;
import top.viewv.view.StageManager;


public class MainController implements Initializable {

    public TextField signupUserInput;
    public PasswordField signupPassword0;
    public PasswordField signupPassword1;
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
    public void GetInput(MouseEvent mouseEvent) throws IOException {
        String user_id = userInput.getText().trim();
        String password = passwordInput.getText().trim();
        Login login = new Login();

        //TODO Rember to remove it when finish!
        String superuser = "!@#";

        if (user_id.equals(superuser)){
            System.out.println("Hello Super Man!");
            Switch();
        }
        else {
            String result = login.LoginFun(user_id, password);
            String icon;
            if (result != null) {
                if (result.equals("account_error")) {
                    System.out.println(result);

                } else if (result.equals("password_error")) {
                    System.out.println(result);
                } else {
                    icon = result;
                    System.out.println(icon);
                    //TODO make icon as a web url that can be download as a file
                    // fun()
                    Switch();
                }
            } else {
                result = "Wrong!";
            }

            JFXSnackbar snackbar = new JFXSnackbar(BottomPane);
            snackbar.show(result, 1000);
        }
    }


    public void RegInput(MouseEvent mouseEvent) {
        String acc_id = signupUserInput.getText().trim();
        String password0 = signupPassword0.getText().trim();
        String password1 = signupPassword1.getText().trim();
        Signup signup = new Signup();
        String result = signup.SignupFun(acc_id,"2313",password0,password1,"zxnnet@gmail.com");
        System.out.println(result);
        if (result != null) {
            if (result.equals("Account Exists")) {
                System.out.println(result);
            } else if (result.equals("Wrong Account Length")) {
                System.out.println(result);
            } else if(result.equals("Wrong Password Length")){
                System.out.println(result);
            } else if(result.equals("Password Don't Match")){
                System.out.println(result);
            }
            else {
               if (result.equals("Staff Account Created Successfully")
                   || result.equals("Client Account Created Successfully")){
                    result += "\nPlease Login!";
                    LoginTab();
               }
            }
        } else {
            result = "Wrong!";
        }

        JFXSnackbar snackbar = new JFXSnackbar(BottomPane);

        snackbar.show(result, 1000);
    }

    public void LoginTab() {
        GroupSignup.setVisible(false);
        GroupLogin.setVisible(true);
    }

    public void SignupTab() {
        GroupLogin.setVisible(false);
        GroupSignup.setVisible(true);
    }

    public void Switch() throws IOException {
        Stage stage=new Stage();

        Parent root = FXMLLoader.load(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("data/Home.fxml")));

        stage.setTitle("第二个窗口");
        stage.setScene(new Scene(root));
        stage.show();
        //将第二个窗口保存到map中
        StageManager.STAGE.put("second", stage);
        //将本窗口保存到map中
        StageManager.CONTROLLER.put("index", this);
        //关闭本窗口
        Stage index = (Stage) loginPane.getScene().getWindow();
        index.close();
    }

//    public void testSwitch() throws IOException {
//        Stage stage=new Stage();
//
//        Parent root = FXMLLoader.load(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("data/Home.fxml")));
//
//        stage.setTitle("第二个窗口");
//        stage.setScene(new Scene(root));
//        stage.show();
//        //将第二个窗口保存到map中
//        StageManager.STAGE.put("second", stage);
//        //将本窗口保存到map中
//        StageManager.CONTROLLER.put("index", this);
//        //关闭本窗口
//        Stage index = (Stage) testBtn.getScene().getWindow();
//        index.close();
//    }

    public String getTranDataToIndex() {
        return tranDataToIndex;
    }

    public void setTranDataToIndex(String tranDataToIndex) {
        this.tranDataToIndex = tranDataToIndex;
    }
}