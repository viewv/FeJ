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
            System.out.println("Loader Success");
            //MainController mainController =  loader.getController();

            Parent root = loader.load();
            Scene scene = new Scene(root);

            String css = Objects.requireNonNull(MainApp.class.getClassLoader().getResource("data/main.css")).toExternalForm();
            scene.getStylesheets().add(css);

            primaryStage.setTitle("FeJ");
            primaryStage.setScene(scene);
            primaryStage.show();
//            Connection conn = new Connect().getConnection();
//            mainController.setConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
