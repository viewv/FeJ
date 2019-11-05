package top.viewv.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import top.viewv.view.StageManager;

import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomeController  implements Initializable {

    public AnchorPane Conetnt;
    public AnchorPane overviewPane;
    public AnchorPane salePane;
    public JFXButton btnSale;
    public JFXButton btnOverview;
    @FXML
    Button btnSignout;
    @FXML
    Circle AvatorCircle;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AvatorCircle.setStroke(Color.SEAGREEN);
        salePane.setVisible(false);
        overviewPane.setVisible(true);

        try {
            String filename = Objects.requireNonNull(this.getClass().getClassLoader().getResource("data/icons/avatar.png")).getPath();
            System.out.println(filename);
            Image im = new Image("file:"+ filename,false);
            AvatorCircle.setFill(new ImagePattern(im));
        } catch (Exception e) {
            String filename = Objects.requireNonNull(this.getClass().getClassLoader().getResource("data/icons/person.png")).getPath();
            Image im = new Image("file:"+ filename,false);
            AvatorCircle.setFill(new ImagePattern(im));
            AvatorCircle.setEffect(new DropShadow(+25d,0d,2d,Color.DARKSEAGREEN));
            e.printStackTrace();
        }
    }

    public void Signout(MouseEvent mouseEvent) throws IOException {

        MainController secondControl=(MainController) StageManager.CONTROLLER.get("index");
        secondControl.setTranDataToIndex("第三个窗口的数据");
        //如果本窗口还使用该控制器先不remove这个控制器;
        //StageManager.CONTROLLER.remove("secondControl");

        Stage stage=new Stage();
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

    public void onClickedbtnSale(MouseEvent mouseEvent) {
        overviewPane.setVisible(false);
        salePane.setVisible(true);
    }

    public void onClinckedbtnOverview(MouseEvent mouseEvent) {
        salePane.setVisible(false);
        overviewPane.setVisible(true);
    }
}
