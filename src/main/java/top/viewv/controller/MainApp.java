package top.viewv.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import top.viewv.database.Connect;

import java.sql.Connection;
import java.util.Objects;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new
                    FXMLLoader(Objects.requireNonNull(getClass()).getClassLoader()
                                .getResource("data/Main.fxml"));

            //Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("data/Main.fxml")));
            MainController mainController = loader.getController();
            Connect connect = new Connect();
            Connection conn = connect.getConnection();
            mainController.setConnect(conn);
            Parent root = loader.load();

            Scene scene = new Scene(root);

            String css = Objects.requireNonNull(MainApp.class.getClassLoader().getResource("data/main.css")).toExternalForm();
            scene.getStylesheets().add(css);

            primaryStage.setTitle("FeJ");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
