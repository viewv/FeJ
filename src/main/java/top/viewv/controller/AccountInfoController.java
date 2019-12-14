package top.viewv.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import top.viewv.api.Gravatar;
import top.viewv.database.Connect;
import top.viewv.model.CMessage;

import java.io.IOException;
import java.sql.Connection;

public class AccountInfoController {

    public JFXTextField logid;
    public JFXTextField aremail;
    public HBox credHbar;
    public JFXButton btnconfirm;
    public JFXButton btnreturn;
    public Label labCerd;
    public Label labIn;
    public Label labRealId;
    public JFXTextField crePass;
    public ImageView Icons;

    private CMessage cMessage;
    private String accId;

    Connection conn = new Connect().getConnection();

    public AccountInfoController() throws IOException, ClassNotFoundException {
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public void refresh(){
        cMessage = new CMessage(conn,accId);
        aremail.setText(cMessage.email);
        if (cMessage.type == 1){
            labCerd.setText(String.valueOf(cMessage.credit));
        }else {
            credHbar.setVisible(false);
        }
        //crePass.setText("如需修改，请输入新密码");
        labIn.setText(cMessage.date.toString());
        labRealId.setText(cMessage.myid);
        logid.setText(cMessage.account_id);
        setUserIcon();
    }

    public void onclickedConfirm(MouseEvent mouseEvent) {
        CMessage.UpdateAccountID(conn,cMessage,logid.getText());
        CMessage.UpdateEmail(conn,cMessage,aremail.getText());
        String password = crePass.getText();

        System.out.println("Password"+password.length());
        if (password.length()!=0){
            CMessage.UpdatePassword(conn,cMessage,password,crePass.getText());
        }
        refresh();
    }

    public void onClickedhome(MouseEvent mouseEvent) {
        Stage index = (Stage) btnconfirm.getScene().getWindow();
        index.close();
    }

    public void setUserIcon() {
        Icons.setImage(Gravatar.imageFromMail(aremail.getText()));
    }
}
