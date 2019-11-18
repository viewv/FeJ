package top.viewv.controller;

import com.jfoenix.controls.JFXProgressBar;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import top.viewv.database.Connect;
import top.viewv.database.Login;
import top.viewv.database.Signup;
import top.viewv.view.StageManager;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.Objects;
import java.util.ResourceBundle;


public class MainController implements Initializable  {

    public TextField signupUserInput;
    public PasswordField signupPassword0;
    public PasswordField signupPassword1;
    public JFXProgressBar pbarLoad;
    public Text labLoadiInd;
    public Group groupBuildInfo;
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

    private Connection conn = null;
    private ThreadType tt = new ThreadType();

    String user_id;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("FeJ Open");

        GroupLogin.setVisible(true);
        GroupSignup.setVisible(false);
        pbarLoad.setVisible(false);
        tt.start();
    }

    @FXML
    public void GetInput() throws Exception {
        user_id = userInput.getText().trim();
        String password = passwordInput.getText().trim();
        Login login = new Login();

        //TODO Rember to remove it when finish!
        String superuser = "!@#";
        //TODO Rember to remove it when finish!
        if (user_id.equals(superuser)) {
            System.out.println("Hello Super Man!");
            PlanSwitch();
        } else {
            String result = login.LoginFun(user_id, password, conn);
            String icon;
            if (result != null) {
                if (result.equals("account_error")) {
                    System.out.println(result);

                } else if (result.equals("password_error")) {
                    System.out.println(result);
                } else {
                    icon = result;
                    System.out.println(icon);
                    Switch();
                }
            } else {
                result = "Wrong! Check Your SQL Connection!";
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
        String result = signup.SignupFun(acc_id, "2313", password0, password1, "zxnnet@gmail.com", conn);
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

    public void Switch() throws Exception {

        Stage stage = new Stage();
        System.out.println("Start Login");

        labLoadiInd.setText("Loading...");
        pbarLoad.setVisible(true);

        FXMLLoader loader = new
                FXMLLoader(Objects.requireNonNull(getClass()).getClassLoader()
                .getResource("data/ui/NewHome.fxml"));


        Parent root = loader.load();
        stage.setTitle("Home Page");
        stage.setScene(new Scene(root));
        stage.show();
        NewHomeController homeControl = loader.getController();
        homeControl.setLabUserName("ViewvLab");
        homeControl.refreshNodes();
        homeControl.setUserIcon("qianrui1999@qq.com");
        homeControl.setlabUserId(user_id);
        //将第二个窗口保存到map中
        StageManager.STAGE.put("second", stage);
        //将本窗口保存到map中
        StageManager.CONTROLLER.put("index", this);

        //关闭本窗口
        Stage index = (Stage) loginPane.getScene().getWindow();
        index.close();
    }

    public void PlanSwitch() throws Exception {

        Stage stage = new Stage();
        System.out.println("Start Login");

        labLoadiInd.setText("Loading...");
        pbarLoad.setVisible(true);

        FXMLLoader loader = new
                FXMLLoader(Objects.requireNonNull(getClass()).getClassLoader()
                .getResource("data/ui/PlanHome.fxml"));


        Parent root = loader.load();
        stage.setTitle("Plan Home Page");
        stage.setScene(new Scene(root));
        stage.show();
        PlanHomeController homeControl = loader.getController();
        homeControl.setLabUserName("ViewvLab");
        homeControl.setUserIcon("qianrui1999@qq.com");
        homeControl.setlabUserId(user_id);
        homeControl.refreshNodes();
        //将第二个窗口保存到map中
        StageManager.STAGE.put("second", stage);
        //将本窗口保存到map中
        StageManager.CONTROLLER.put("index", this);
        //关闭本窗口
        Stage index = (Stage) loginPane.getScene().getWindow();
        index.close();
    }

    public void setTranDataToIndex(String tranDataToIndex) {
    }

    public void enterPress(KeyEvent keyEvent) throws Exception {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            if (GroupLogin.isVisible()) {
                GetInput();
            } else {
                RegInput();
            }
        }
    }

    class ThreadType extends Thread {
        public void run() {
            try {
                conn = new Connect().getConnection();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}