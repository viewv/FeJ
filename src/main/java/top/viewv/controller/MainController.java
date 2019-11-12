package top.viewv.controller;

import com.jfoenix.controls.JFXSnackbar;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import top.viewv.database.Connect;
import top.viewv.database.Login;
import top.viewv.database.Signup;
import top.viewv.view.StageManager;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;


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
//    @FXML
//    Button testBtn;

    Connection conn = new Connect().getConnection();

    private String tranDataToIndex;

//    public void setConnection(Connection connection){
//        System.out.println("Start set Connection");
//        conn = connection;
//    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("FeJ Open");

        GroupLogin.setVisible(true);
        GroupSignup.setVisible(false);

    }

    @FXML
    public void GetInput() throws IOException, SQLException {
        String user_id = userInput.getText().trim();
        String password = passwordInput.getText().trim();
        Login login = new Login();

        //TODO Rember to remove it when finish!
        String superuser = "zxnnet@gmail.com";

        if (user_id.equals(superuser)) {
            System.out.println("Hello Super Man!");
            Switch();
        } else {
            String result = login.LoginFun(user_id, password,conn);
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


    public void RegInput() {
        String acc_id = signupUserInput.getText().trim();
        String password0 = signupPassword0.getText().trim();
        String password1 = signupPassword1.getText().trim();
        Signup signup = new Signup();
        String result = signup.SignupFun(acc_id, "2313", password0, password1, "zxnnet@gmail.com",conn);
        System.out.println(result);
        if (result != null) {
            if (result.equals("Account Exists")) {
                System.out.println(result);
            } else if (result.equals("Wrong Account Length")) {
                System.out.println(result);
            } else if (result.equals("Wrong Password Length")) {
                System.out.println(result);
            } else if (result.equals("Password Don't Match")) {
                System.out.println(result);
            } else {
                if (result.equals("Staff Account Created Successfully")
                        || result.equals("Client Account Created Successfully")) {
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

    public void Switch() throws IOException, SQLException {
        Stage stage = new Stage();
        System.out.println("Start Login");
        conn.close();
        FXMLLoader loader = new
                FXMLLoader(Objects.requireNonNull(getClass()).getClassLoader()
                        .getResource("data/newhome.fxml"));
        //newhomeController homeController = loader.getController();
        Parent root = loader.load();
        //Parent root = FXMLLoader.load(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("data/newhome.fxml")));

        stage.setTitle("Home Page");
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

    public String getTranDataToIndex() {
        return tranDataToIndex;
    }

    public void setTranDataToIndex(String tranDataToIndex) {
        this.tranDataToIndex = tranDataToIndex;
    }

    public void enterPress(KeyEvent keyEvent) throws IOException, SQLException {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            if (GroupLogin.isVisible()) {
            } else {
                RegInput();
            }
        }
    }
}