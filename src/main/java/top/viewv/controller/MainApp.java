package top.viewv.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class MainApp extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("data/Main.fxml")));

            Scene scene = new Scene(root);

            String css = MainApp.class.getClassLoader().getResource("data/main.css").toExternalForm();
            scene.getStylesheets().add(css);

            primaryStage.setTitle("FeJ");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
