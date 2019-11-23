package top.viewv.controller;

import com.jfoenix.controls.JFXButton;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class PlanItemController implements Initializable {

    public Label labPlanId;
    public JFXButton btnDelPlan;
    public Label labPlanPtime;
    public Label labPlanStime;
    public TableView tablePro;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAmount;

    private ObservableList<Product> data = FXCollections.observableArrayList();

    private PlanHomeController homeController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        System.out.println("Items Open");
        colId.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );
        colName.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );
        colAmount.setCellValueFactory(
                new PropertyValueFactory<>("amount")
        );

        tablePro.setItems(data);
    }

    public void setTablePro(int[][] products) {
        int length = products.length;
        for (int i = 0; i < length; i++) {
            int[] product = products[i];
            Integer id = product[0];
            Integer name = product[1];
            Integer amount = product[2];
            data.add(new Product(id, name, amount));
        }
        tablePro.setItems(data);
    }

    public void setHomeController(PlanHomeController obj) {
        homeController = obj;
    }

    public void setLabPlanId(int id) {
        labPlanId.setText(String.valueOf(id));
    }

    public void onClickedDelPlan(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        int planId = Integer.parseInt(labPlanId.getText());
        homeController.clearOneItem(planId);
    }

    public void setLabPlanStime(Date date) {
        labPlanStime.setText(date.toString());
    }

    public void setLabPlanPtime(Date date) {
        labPlanPtime.setText(date.toString());
    }


    public static class Product {

        private final SimpleIntegerProperty id;
        private final SimpleIntegerProperty name;
        private final SimpleIntegerProperty amount;

        private Product(Integer id, Integer name, Integer amount) {
            this.id = new SimpleIntegerProperty(id);
            this.name = new SimpleIntegerProperty(name);
            this.amount = new SimpleIntegerProperty(amount);
        }

        public int getId() {
            return id.get();
        }

        public void setId(int id) {
            this.id.set(id);
        }

        public Integer getName() {
            return name.get();
        }

        public void setName(Integer name) {
            this.name.set(name);
        }

        public int getAmount() {
            return amount.get();
        }

        public void setAmount(int amount) {
            this.amount.set(amount);
        }
    }
}
