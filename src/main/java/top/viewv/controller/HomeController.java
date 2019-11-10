package top.viewv.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import top.viewv.view.StageManager;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    public JFXButton btnSale;
    @FXML
    public JFXButton btnOverview;
    @FXML
    public AnchorPane Content;
    @FXML
    public AnchorPane overviewPane; //0
    @FXML
    public AnchorPane salePane;//1
    @FXML
    public AnchorPane finPane;//2
    @FXML
    public AnchorPane planPane;//3
    @FXML
    public AnchorPane linePane;//4
    @FXML
    public AnchorPane warehousePane;//5
    @FXML
    public AnchorPane managePane;//6
    public JFXButton btnFin;
    public JFXButton btnPaln;
    public JFXButton btnProduce;
    public JFXButton btnWarehouse;
    public JFXButton btnManage;
    @FXML
    Button btnSignout;
    @FXML
    Circle AvatorCircle;

    public void switchPane(int state) {
        switch (state) {
            case 1:
                overviewPane.setVisible(false);
                finPane.setVisible(false);
                planPane.setVisible(false);
                linePane.setVisible(false);
                warehousePane.setVisible(false);
                managePane.setVisible(false);
                salePane.setVisible(true);
                break;

            case 2:
                overviewPane.setVisible(false);
                planPane.setVisible(false);
                linePane.setVisible(false);
                warehousePane.setVisible(false);
                managePane.setVisible(false);
                salePane.setVisible(false);
                finPane.setVisible(true);
                break;
            case 3:
                overviewPane.setVisible(false);
                linePane.setVisible(false);
                warehousePane.setVisible(false);
                managePane.setVisible(false);
                salePane.setVisible(false);
                finPane.setVisible(false);
                planPane.setVisible(true);
                break;
            case 4:
                overviewPane.setVisible(false);
                warehousePane.setVisible(false);
                managePane.setVisible(false);
                salePane.setVisible(false);
                finPane.setVisible(false);
                planPane.setVisible(false);
                linePane.setVisible(true);
                break;
            case 5:
                overviewPane.setVisible(false);
                managePane.setVisible(false);
                salePane.setVisible(false);
                finPane.setVisible(false);
                planPane.setVisible(false);
                linePane.setVisible(false);
                warehousePane.setVisible(true);
                break;
            case 6:
                overviewPane.setVisible(false);
                salePane.setVisible(false);
                finPane.setVisible(false);
                planPane.setVisible(false);
                linePane.setVisible(false);
                warehousePane.setVisible(false);
                managePane.setVisible(true);
                break;

            default:
                salePane.setVisible(false);
                finPane.setVisible(false);
                planPane.setVisible(false);
                linePane.setVisible(false);
                warehousePane.setVisible(false);
                managePane.setVisible(false);
                overviewPane.setVisible(true);
                break;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AvatorCircle.setStroke(Color.SEAGREEN);
        switchPane(0);

        try {
            String filename = Objects.requireNonNull(this.getClass().getClassLoader().getResource("data/icons/avatar.png")).getPath();
            System.out.println(filename);
            Image im = new Image("file:" + filename, false);
            AvatorCircle.setFill(new ImagePattern(im));
        } catch (Exception e) {
            String filename = Objects.requireNonNull(this.getClass().getClassLoader().getResource("data/icons/person.png")).getPath();
            Image im = new Image("file:" + filename, false);
            AvatorCircle.setFill(new ImagePattern(im));
            AvatorCircle.setEffect(new DropShadow(+25d, 0d, 2d, Color.DARKSEAGREEN));
            e.printStackTrace();
        }
    }

    public void Signout(MouseEvent mouseEvent) throws IOException {

        MainController secondControl = (MainController) StageManager.CONTROLLER.get("index");
        secondControl.setTranDataToIndex("第三个窗口的数据");
        //如果本窗口还使用该控制器先不remove这个控制器;
        //StageManager.CONTROLLER.remove("secondControl");

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("data/Main.fxml")));
        stage.setTitle("Index");
        stage.setScene(new Scene(root));
        stage.show();
        //将第二个窗口保存到map中
        StageManager.STAGE.put("second", stage);
        //将本窗口保存到map中
        StageManager.CONTROLLER.put("index", this);
        //关闭本窗口
        Stage index = (Stage) btnSignout.getScene().getWindow();
        index.close();
    }

    public void onClinckedbtnOverview(MouseEvent mouseEvent) {
        switchPane(0);
    }

    public void onClickedbtnSale(MouseEvent mouseEvent) {
        switchPane(1);
    }

    public void onClickedbtnFin(MouseEvent mouseEvent) {
        switchPane(2);
    }

    public void onClickedbtnPaln(MouseEvent mouseEvent) {
        switchPane(3);
    }

    public void onClickedbtnProduce(MouseEvent mouseEvent) {
        switchPane(4);
    }

    public void onClickedbtnWarehouse(MouseEvent mouseEvent) {
        switchPane(5);
    }

    public void onClickedbtnManage(MouseEvent mouseEvent) {
        switchPane(6);
    }
}
