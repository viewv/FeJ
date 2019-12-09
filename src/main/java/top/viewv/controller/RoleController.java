package top.viewv.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import top.viewv.view.StageManager;

import java.io.IOException;
import java.util.Objects;

public class RoleController {

    public AnchorPane pane;
    private String userIcon;
    public JFXButton btnexit;
    private String userId;
    private String labUserName;
    private String dept;

    public void onClickedbtnPerson(MouseEvent mouseEvent) throws Exception {
        PersonSwitch();
    }

    public void onClickedbtnManage(MouseEvent mouseEvent) throws Exception {
        if (dept=="SA"){
            SaleSwitch();
        }else if (dept == "FM"){
            FinanceSwitch();
        }else if (dept == "WS"){
            StorageSwitch();
        } else if (dept == "MS"){
            IStorageSwitch();
        }else if (dept == "PL"){
            PlanSwitch();
        }
    }

    public void onClickedExit(MouseEvent mouseEvent) throws IOException {
        MainController secondControl = (MainController) StageManager.CONTROLLER.get("index");
        secondControl.setTranDataToIndex("第三个窗口的数据");
        //如果本窗口还使用该控制器先不remove这个控制器;
        //StageManager.CONTROLLER.remove("secondControl");

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("data/ui/Main.fxml")));
        stage.setTitle("Index");
        stage.setScene(new Scene(root));
        stage.show();
        //将第二个窗口保存到map中
        StageManager.STAGE.put("second", stage);
        //将本窗口保存到map中
        StageManager.CONTROLLER.put("chooser", this);
        //关闭本窗口
        Stage index = (Stage) btnexit.getScene().getWindow();
        index.close();
    }

    public void PersonSwitch() throws Exception {

        Stage stage = new Stage();
        System.out.println("Start Login");

        FXMLLoader loader = new
                FXMLLoader(Objects.requireNonNull(getClass()).getClassLoader()
                .getResource("data/ui/PersonHome.fxml"));

        Parent root = loader.load();
        stage.setTitle("Person Home Page");
        stage.setScene(new Scene(root));
        stage.show();
        PersonHomeController homeControl = loader.getController();
        homeControl.setLabUserName("ViewvLab");
        homeControl.setUserIcon(userIcon);
        homeControl.setlabUserId(userId);
        homeControl.setLabUserName(labUserName);
        homeControl.refeshUser();
        //将第二个窗口保存到map中
        StageManager.STAGE.put("second", stage);
        //将本窗口保存到map中
        StageManager.CONTROLLER.put("chooser", this);
        //关闭本窗口
        Stage index = (Stage)pane.getScene().getWindow();
        index.close();
    }

    public void setUserIcon(String email){
        this.userIcon = email;
    }

    public void setLabUserName(String name){
        this.labUserName = name;
    }

    public void setlabUserId(String id){
        this.userId = id;
    }

    public void setDept(String dept){
        this.dept = dept;
    }

    public void PlanSwitch() throws Exception {

        Stage stage = new Stage();
        System.out.println("Start Login");

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
        homeControl.setlabUserId(userId);
        homeControl.refreshNodes();
        //将第二个窗口保存到map中
        StageManager.STAGE.put("second", stage);
        //将本窗口保存到map中
        StageManager.CONTROLLER.put("chooser", this);
        //关闭本窗口
        Stage index = (Stage) pane.getScene().getWindow();
        index.close();
    }

    public void SaleSwitch() throws Exception {

        Stage stage = new Stage();
        System.out.println("Start Login");

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
        homeControl.setlabUserId(userId);
        homeControl.refreshNodes();
        //将第二个窗口保存到map中
        StageManager.STAGE.put("second", stage);
        //将本窗口保存到map中
        StageManager.CONTROLLER.put("chooser", this);
        //关闭本窗口
        Stage index = (Stage) pane.getScene().getWindow();
        index.close();
    }

    public void FinanceSwitch() throws Exception {

        Stage stage = new Stage();
        System.out.println("Start Login");

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
        homeControl.setlabUserId(userId);
        homeControl.refreshNodes();
        //将第二个窗口保存到map中
        StageManager.STAGE.put("second", stage);
        //将本窗口保存到map中
        StageManager.CONTROLLER.put("chooser", this);
        //关闭本窗口
        Stage index = (Stage) pane.getScene().getWindow();
        index.close();
    }

    public void StorageSwitch() throws Exception {

        Stage stage = new Stage();
        System.out.println("Start Login");

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
        homeControl.setlabUserId(userId);
        homeControl.refrash();
        //将第二个窗口保存到map中
        StageManager.STAGE.put("second", stage);
        //将本窗口保存到map中
        StageManager.CONTROLLER.put("chooser", this);
        //关闭本窗口
        Stage index = (Stage) pane.getScene().getWindow();
        index.close();
    }

    public void IStorageSwitch() throws Exception {

        Stage stage = new Stage();
        System.out.println("Start Login");

        FXMLLoader loader = new
                FXMLLoader(Objects.requireNonNull(getClass()).getClassLoader()
                .getResource("data/ui/IStorageHome.fxml"));

        Parent root = loader.load();
        stage.setTitle("Product Storage Home Page");
        stage.setScene(new Scene(root));
        stage.show();
        IStorageHomeController homeControl = loader.getController();
        homeControl.setLabUserName("ViewvLab");
        homeControl.setUserIcon("zxnnet@gmail.com");
        homeControl.setlabUserId(userId);
        homeControl.refrash();
        //将第二个窗口保存到map中
        StageManager.STAGE.put("second", stage);
        //将本窗口保存到map中
        StageManager.CONTROLLER.put("chooser", this);
        //关闭本窗口
        Stage index = (Stage) pane.getScene().getWindow();
        index.close();
    }
}
