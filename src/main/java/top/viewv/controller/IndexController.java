package top.viewv.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import top.viewv.view.StageManager;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IndexController implements Initializable {

    public void initialize(URL url, ResourceBundle rb) {
        try {
            System.out.println("Hello World");
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 打开第二个窗口
     *
     * @param event
     * @throws Exception
     */

    public void open(ActionEvent event) throws Exception {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("data/ui/Main.fxml")));
        //Parent root = FXMLLoader.load(Thread.currentThread().getContextClassLoader().getResource("data/Index.fxml"));
        stage.setTitle("第二个窗口");
        stage.setScene(new Scene(root));
        stage.show();
        //将第二个窗口保存到map中
        StageManager.STAGE.put("second", stage);
        //将本窗口保存到map中
        StageManager.CONTROLLER.put("indexControl", this);
    }
}
