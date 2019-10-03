package top.viewv.controller;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle rb){
        try {
            System.out.println("Hello World");
        }catch (Exception ex){
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

}
