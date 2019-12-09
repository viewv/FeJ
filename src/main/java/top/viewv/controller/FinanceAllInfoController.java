package top.viewv.controller;

import javafx.scene.control.Label;

import java.text.DecimalFormat;

public class FinanceAllInfoController {

    public Label labType;
    public Label lableMoney;
    public Label labOrder;
    public Label labStaffl;

    public void setLabType(int type){
        if(type ==1){
            labType.setText("订单收入");
        }else {
            labType.setText("退款支出");
        }
    }

    public void setLableMoney(float money){
        DecimalFormat df = new DecimalFormat("0.00");
        lableMoney.setText(df.format(money));
    }

    public void setLabOrder(int id){
        labOrder.setText(String.valueOf(id));
    }

    public void setLabStaffl(String id){
        labStaffl.setText(id);
    }
}
