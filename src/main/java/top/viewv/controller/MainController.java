package top.viewv.controller;

import com.jfoenix.controls.*;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import top.viewv.database.Login;
import top.viewv.view.StageManager;


public class MainController implements Initializable {

    @FXML Button btnsignup;
    @FXML Button enterButton;
    @FXML TextField userInput;
    @FXML TextField passwordInput;
    @FXML AnchorPane loginPane;
    @FXML HBox BottomPane;
    @FXML StackPane InputPane;





    @Override
    public void initialize(URL url, ResourceBundle rb){
        try {
//            JFXSnackbar snackbar = new JFXSnackbar(loginPane);

//            snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(
//                    new JFXSnackbarLayout("Snackbar Message Persistent Jsdjsidjdnsdisjdiadid " ,
//                            "CLOSE",
//                            action -> snackbar.close()),
//                    Duration.seconds(10), null));

            System.out.println("FeJ Open");
            String unselectedColor = "#FFFFFF";
            String selectedColor = "#aeaeae";
            int LogOrReg = 0; //0 for log 1 for reg

        }catch (Exception ex){
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

//    private void loadDialog(String message){
//        JFXDialogLayout context = new JFXDialogLayout();
//        context.setHeading(new Text("Heading"));
//        context.setBody(new Text(message));
//        JFXDialog dialog = new JFXDialog(InputPane,context,JFXDialog.DialogTransition.CENTER);
//        JFXButton button = new JFXButton("Okey");
//        button.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                dialog.close();
//            }
//        });
//        context.setActions(button);
//        dialog.show();
//    }

    @FXML
    public void GetInput(MouseEvent mouseEvent) {
        String user_id = userInput.getText().trim();
        String password = passwordInput.getText().trim();
        Login login = new Login();

        String result = login.LoginFun(user_id,password);
        String icon ;

        if (result != null){
            if (result == "account_error"){
                System.out.println(result);

            }else if (result == "password_error") {
                System.out.println(result);
            }
            else {
                icon = result;
                System.out.println(icon);
            }
        }
        else {
            result = "Wrong!";
        }

        JFXSnackbar snackbar = new JFXSnackbar(BottomPane);

        snackbar.fireEvent(new JFXSnackbar.SnackbarEvent(
                new JFXSnackbarLayout(result,
                        "CLOSE",
                        action -> snackbar.close()),
                Duration.seconds(2), null));
    }
}
