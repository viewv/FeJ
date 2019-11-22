package top.viewv.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import top.viewv.model.Order_Product;

import java.net.URL;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class OrderItemController implements Initializable {
    public JFXProgressBar pbarOrder;
    public Label labOrdertId;
    public Label labPrice;
    public Label labOrderStatus;
    public TableView tableOrderShopList;
    public JFXButton btnReturnOrder;
    public TableColumn colProductId;
    public TableColumn colProductName;
    public TableColumn colProductAmount;
    public TableColumn colProductPrice;
    public Label labOrderPtime;
    public Label labOrderStime;

    private ObservableList<Product> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pbarOrder.setVisible(false);
        System.out.println("Order Open");
        colProductId.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );
        colProductName.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );
        colProductAmount.setCellValueFactory(
                new PropertyValueFactory<>("amount")
        );

        colProductPrice.setCellValueFactory(
                new PropertyValueFactory<>("price")
        );
        tableOrderShopList.setItems(data);
    }

    public void setOrderStime(Date date){
        labOrderStime.setText(date.toString());
    }

    public void setOrderPtime(Date date){
        labOrderPtime.setText(date.toString());
    }

    public void setTableOrderShopList(Order_Product[] order_products){
        int length = order_products.length;
        for (int i=0;i<length;i++){
            Order_Product product = order_products[i];
            Integer id = product.id;
            String name = product.name;
            Integer amount = product.amount;
            Float price = product.price;
            System.out.println("Id"+id+"Amound"+amount+"Name"+name+"Price"+price);
            data.add(new Product(id,name,amount,price));
        }
        tableOrderShopList.setItems(data);
    }

    public void setLabOrdertId(int id){
        labOrdertId.setText(String.valueOf(id));
    }

    public void setLabPrice(float price){
        DecimalFormat df = new DecimalFormat("0.00");
        labPrice.setText(String.valueOf(df.format(price)));
    }

    public void setLabOrderStatus(int status){
        pbarOrder.setVisible(true);
        if (status == 0){
            labOrderStatus.setText("已下单，等待处理");
            pbarOrder.setProgress(0.6);
        }else if(status == 1){
            labOrderStatus.setText("无法确认订单");
            pbarOrder.setProgress(0);
            pbarOrder.setVisible(false);
        }else if (status == 2){
            pbarOrder.setProgress(0.8);
            labOrderStatus.setText("订单开始处理");
        }else if (status == 3){
            pbarOrder.setProgress(1);
            labOrderStatus.setText("已完成");
        }else if (status == 4){
            pbarOrder.setProgress(0.5);
            labOrderStatus.setText("开始处理退货");
        }else if (status == 5){
            pbarOrder.setProgress(1);
            labOrderStatus.setText("确认退货");
        }
    }

    public void onClickedbtnReturn(MouseEvent mouseEvent) {
    }

    public static class Product {

        private final SimpleIntegerProperty id;
        private final SimpleStringProperty name;
        private final SimpleIntegerProperty amount;
        private final SimpleFloatProperty price;

        private Product(Integer id, String name,Integer amount,Float price) {
            this.id = new SimpleIntegerProperty(id);
            this.name = new SimpleStringProperty(name);
            this.amount = new SimpleIntegerProperty(amount);
            this.price = new SimpleFloatProperty(price);
        }

        public void setId(int id) {
            this.id.set(id);
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public void setAmount(int amount) {
            this.amount.set(amount);
        }

        public void setPrice(float price) {
            this.price.set(price);
        }

        public int getId() {
            return id.get();
        }

        public String getName() {
            return name.get();
        }

        public int getAmount() {
            return amount.get();
        }


        public float getPrice() {
            return price.get();
        }

    }
}
