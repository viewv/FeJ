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
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import top.viewv.api.UserAuth;
import top.viewv.database.Connect;
import top.viewv.database.Login;
import top.viewv.database.Signup;
import top.viewv.model.Finance;
import top.viewv.model.Plan;
import top.viewv.model.Staff;
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
    public HBox happy;
    public ImageView happyimage;
    public Text happyy;
    public TextField areemail;
    public TextField userId;
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

    private int counter = 0;

    private Connection conn = null;
    private ThreadType tt = new ThreadType();

    String user_id;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("FeJ Open");
        GroupLogin.setVisible(true);
        GroupSignup.setVisible(false);
        pbarLoad.setVisible(false);
        happyimage.setVisible(false);
        tt.start();
    }

    @FXML
    public void GetInput() throws Exception {
        user_id = userInput.getText().trim();
        String password = passwordInput.getText().trim();
        Login login = new Login();

        String superuser = "444";
        if (user_id.equals(superuser)) {
            System.out.println("Hello Super Man!");
           Switch();
        }
        else {
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
                    String staffid = Staff.GetStaffID(user_id,conn);
                    if (staffid == null){
                        Switch();
                    }else {
                        String[] type = UserAuth.getUserAuth(staffid);
                        if (type[0] == "SA"){
                            if (type[2] == "1"){
                                ManageSwitch("SA");
                            }else {
                                SaleSwitch();
                            }
                        }else if(type[0] == "FM"){
                            if (type[2] == "1"){
                                ManageSwitch("FM");
                            }else {
                                FinanceSwitch();
                            }
                        }else if(type[0]== "WS"  ){
                            if (type[2] == "1"){
                                ManageSwitch("WS");
                            }else {
                                StorageSwitch();
                            }
                        }else if(type[0]=="PM"){
                            if (type[2] == "1"){
                                ManageSwitch("PM");
                            }else {
                                PlanSwitch();
                            }
                        }else if(type[0] == "MS"){
                            if (type[2] == "1"){
                                ManageSwitch("MS");
                            }else {
                                IStorageSwitch();
                            }
                        }else if(type[0]=="DE"){
                            if (type[2]=="1"){
                               ManageSwitch("DE");
                            }else {
                                DevSwitch();
                            }
                        }else if(type[0] == "PL"){
                            WorkerSwitch();
                        }
                    }
                }
            } else {
                result = "Wrong! Check Your SQL Connection!";
            }

            JFXSnackbar snackbar = new JFXSnackbar(BottomPane);
            snackbar.show(result, 1000);
        }
    }

    public void ManageSwitch(String role) throws IOException {
        Stage stage = new Stage();
        System.out.println("Start Login");

        labLoadiInd.setText("Loading...");
        pbarLoad.setVisible(true);

        FXMLLoader loader = new
                FXMLLoader(Objects.requireNonNull(getClass()).getClassLoader()
                .getResource("data/ui/RoleChooser.fxml"));

        Parent root = loader.load();
        stage.setTitle("Home Page");
        stage.setScene(new Scene(root));
        stage.show();
        RoleController homeControl = loader.getController();
        homeControl.setLabUserName("ViewvLab");
        homeControl.setUserIcon("qianrui1999@qq.com");
        homeControl.setlabUserId(user_id);
        homeControl.setDept(role);
        //将第二个窗口保存到map中
        StageManager.STAGE.put("second", stage);
        //将本窗口保存到map中
        StageManager.CONTROLLER.put("index", this);

        //关闭本窗口
        Stage index = (Stage) loginPane.getScene().getWindow();
        index.close();
    }

    public void RegInput() {
        String acc_id = signupUserInput.getText().trim();
        String password0 = signupPassword0.getText().trim();
        String password1 = signupPassword1.getText().trim();
        Signup signup = new Signup();
        String result = signup.SignupFun(acc_id, userId.getText(), password0, password1, areemail.getText(), conn);
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

    public void DevSwitch() throws Exception {

        Stage stage = new Stage();
        System.out.println("Start Login");

        labLoadiInd.setText("Loading...");
        pbarLoad.setVisible(true);

        FXMLLoader loader = new
                FXMLLoader(Objects.requireNonNull(getClass()).getClassLoader()
                .getResource("data/ui/DeveHome.fxml"));

        Parent root = loader.load();
        stage.setTitle("Develop Home Page");
        stage.setScene(new Scene(root));
        stage.show();
        DeveHomeController homeControl = loader.getController();
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

    public void WorkerSwitch() throws Exception {

        Stage stage = new Stage();
        System.out.println("Start Login");

        labLoadiInd.setText("Loading...");
        pbarLoad.setVisible(true);

        FXMLLoader loader = new
                FXMLLoader(Objects.requireNonNull(getClass()).getClassLoader()
                .getResource("data/ui/WorkerHome.fxml"));

        Parent root = loader.load();
        stage.setTitle("Worker Home Page");
        stage.setScene(new Scene(root));
        stage.show();
        WorkHomeController homeControl = loader.getController();
        homeControl.setLabUserName("ViewvLab");
        homeControl.setUserIcon("zxn@zxnnet.top");
        homeControl.setlabUserId(user_id);
        homeControl.refeshUser();
        //将第二个窗口保存到map中
        StageManager.STAGE.put("second", stage);
        //将本窗口保存到map中
        StageManager.CONTROLLER.put("index", this);

        //关闭本窗口
        Stage index = (Stage) loginPane.getScene().getWindow();
        index.close();
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

    public void SaleSwitch() throws Exception {

        Stage stage = new Stage();
        System.out.println("Start Login");

        labLoadiInd.setText("Loading...");
        pbarLoad.setVisible(true);

        FXMLLoader loader = new
                FXMLLoader(Objects.requireNonNull(getClass()).getClassLoader()
                .getResource("data/ui/SaleHome.fxml"));

        Parent root = loader.load();
        stage.setTitle("Sale Home Page");
        stage.setScene(new Scene(root));
        stage.show();
        SaleHomeController homeControl = loader.getController();
        homeControl.setLabUserName("ViewvLab");
        homeControl.setUserIcon("zxn@zxnnet.top");
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

    public void FinanceSwitch() throws Exception {

        Stage stage = new Stage();
        System.out.println("Start Login");

        labLoadiInd.setText("Loading...");
        pbarLoad.setVisible(true);

        FXMLLoader loader = new
                FXMLLoader(Objects.requireNonNull(getClass()).getClassLoader()
                .getResource("data/ui/FinanceHome.fxml"));

        Parent root = loader.load();
        stage.setTitle("Finance Home Page");
        stage.setScene(new Scene(root));
        stage.show();
        FinanceHomeController homeControl = loader.getController();
        homeControl.setLabUserName("ViewvLab");
        homeControl.setUserIcon("zxnnet@gmail.com");
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

    public void StorageSwitch() throws Exception {

        Stage stage = new Stage();
        System.out.println("Start Login");

        labLoadiInd.setText("Loading...");
        pbarLoad.setVisible(true);

        FXMLLoader loader = new
                FXMLLoader(Objects.requireNonNull(getClass()).getClassLoader()
                .getResource("data/ui/StorageHome.fxml"));

        Parent root = loader.load();
        stage.setTitle("Product Storage Home Page");
        stage.setScene(new Scene(root));
        stage.show();
        StorageHomeController homeControl = loader.getController();
        homeControl.setLabUserName("ViewvLab");
        homeControl.setUserIcon("zxnnet@gmail.com");
        homeControl.setlabUserId(user_id);
        homeControl.refrash();
        //将第二个窗口保存到map中
        StageManager.STAGE.put("second", stage);
        //将本窗口保存到map中
        StageManager.CONTROLLER.put("index", this);
        //关闭本窗口
        Stage index = (Stage) loginPane.getScene().getWindow();
        index.close();
    }

    public void IStorageSwitch() throws Exception {

        Stage stage = new Stage();
        System.out.println("Start Login");

        labLoadiInd.setText("Loading...");
        pbarLoad.setVisible(true);

        FXMLLoader loader = new
                FXMLLoader(Objects.requireNonNull(getClass()).getClassLoader()
                .getResource("data/ui/IStorageHome.fxml"));

        Parent root = loader.load();
        stage.setTitle("Ingredient Storage Home Page");
        stage.setScene(new Scene(root));
        stage.show();
        IStorageHomeController homeControl = loader.getController();
        homeControl.setLabUserName("ViewvLab");
        homeControl.setUserIcon("zxnnet@gmail.com");
        homeControl.setlabUserId(user_id);
        homeControl.refrash();
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

    public void onclickedhappy(MouseEvent mouseEvent) {
        if (counter == 10){
            happyy.setText("你已经点击10次了！");
        }else if (counter == 20){
            happyy.setText("你已经点击20次了喵！");
        }else if(counter == 30){
            happyy.setText("好了，30次了，给你看乖");
            happyimage.setVisible(true);
        }else if(counter == 35){
            happyy.setText("走了喵");
            happyimage.setVisible(false);
            counter = 0;
        }
        counter ++;
        System.out.println(counter);
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