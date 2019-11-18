package top.viewv.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import top.viewv.api.Serialize;
import top.viewv.model.PlanInfo;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PlanProItemController implements Initializable {

    public Label labProductName;
    public Label labPrice;
    public Label labProductId;
    public Label labProductRtime;
    public Label labDescrption;
    public JFXTreeTableView recipeTable;
    public JFXButton btnAddToShop;
    public JFXTextField tfxNumberInput;
    public JFXTextField tfxLineNum;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Items Open");
    }

    public void setLabPrice(float message) {
        //Display the message
        labPrice.setText(String.valueOf(message));
    }

    public void setLabProductName(String message) {
        //Display the message
        labProductName.setText(message);
    }

    public void setLabProductId(int message) {
        labProductId.setText(String.valueOf(message));
    }

    public void setLabProductRtime(int message) {
        labProductRtime.setText(String.valueOf(message));
    }

    public void setLabDescrption(String message) {
        labDescrption.setText(message);
    }

    public void onClickedbtnAddToShop() throws Exception {
        int numbers = Integer.parseInt(tfxNumberInput.getText().trim());
        int product_id = Integer.parseInt(labProductId.getText().trim());
        int line_num = Integer.parseInt(tfxLineNum.getText());
        ArrayList<PlanInfo> planInfos = Serialize.planInfodser("plan.ser");
        PlanInfo planInfo = new PlanInfo(product_id,numbers,line_num, labProductName.getText());
        planInfos.add(planInfo);
        Serialize.ser(planInfos, "plan.ser");
        System.out.println("Ser Plan Ok!");
    }
}
