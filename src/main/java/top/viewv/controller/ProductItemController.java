package top.viewv.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import top.viewv.api.Serialize;
import top.viewv.model.SpecificRecipe;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class ProductItemController implements Initializable {

    public Label labProductName;
    public Label labPrice;
    public Label labProductId;
    public Label labProductRtime;
    public Label labDescrption;
    public JFXButton btnAddToShop;
    public JFXTextField tfxNumberInput;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAmount;
    public TableView tableRec;

    private ObservableList<Receipe> data = FXCollections.observableArrayList();

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

        tableRec.setItems(data);
    }

    public void setTableRec(SpecificRecipe[] recipes) {
        int length = recipes.length;
        for (int i = 0; i < length; i++) {
            SpecificRecipe recipe = recipes[i];
            Integer id = recipe.IngredientId;
            String name = recipe.IngredientName;
            Integer amount = recipe.Amount;
            data.add(new Receipe(id, name, amount));
        }
        tableRec.setItems(data);
    }

    public void setLabPrice(float message) {
        //Display the CMessage
        labPrice.setText(String.valueOf(message));
    }

    public void setLabProductName(String message) {
        //Display the CMessage
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
        HashMap<Integer, Integer> order_lists = Serialize.dSer("order.ser");
        if (order_lists.containsKey(product_id)) {
            int amount = order_lists.get(product_id);
            amount += numbers;
            order_lists.put(product_id, amount);
        } else {
            order_lists.put(product_id, numbers);
        }
        Serialize.ser(order_lists, "order.ser");
        System.out.println("Ser Ok!");
    }

    public static class Receipe {

        private final SimpleIntegerProperty id;
        private final SimpleStringProperty name;
        private final SimpleIntegerProperty amount;

        private Receipe(Integer id, String name, Integer amount) {
            this.id = new SimpleIntegerProperty(id);
            this.name = new SimpleStringProperty(name);
            this.amount = new SimpleIntegerProperty(amount);
        }

        public int getId() {
            return id.get();
        }

        public void setId(int id) {
            this.id.set(id);
        }

        public String getName() {
            return name.get();
        }

        public void setName(String name) {
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
