package top.viewv.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class MainApp extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("data/Main.fxml")));
        Scene scene = new Scene(root, 1366, 768);
//        Scene scene = new Scene(root,1920,1080);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getClassLoader().getResource("style/light.css")).toExternalForm());

//        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("FeJ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
