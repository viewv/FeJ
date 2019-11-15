package top.viewv.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderItemController implements Initializable {
    public JFXProgressBar pbarOrder;
    public Label labOrdertId;
    public Label labOrderRtime;
    public Label labPrice;
    public Label labOrderStatus;
    public TableView tableOrderShopList;
    public JFXButton btnReturnOrder;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pbarOrder.setProgress(0.7);
        System.out.println("Order Open");
    }

    public void setLabOrdertId(int id){
        labOrdertId.setText(String.valueOf(id));
    }

    public void setLabPrice(float price){
        labPrice.setText(String.valueOf(price));
    }

    public void setLabOrderStatus(int status){
        if (status == 0){
            labOrderStatus.setText("已下单，等待处理");
        }else if(status == 1){
            labOrderStatus.setText("无法确认订单");
        }else if (status == 2){
            labOrderStatus.setText("订单开始处理");
        }else if (status == 3){
            labOrderStatus.setText("订单配送");
        }else if (status == 4){
            labOrderStatus.setText("开始处理退货");
        }else if (status == 5){
            labOrderStatus.setText("确认退货");
        }
    }

    public void onClickedbtnReturn(MouseEvent mouseEvent) {

    }
}
