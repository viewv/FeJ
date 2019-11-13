package top.viewv.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import top.viewv.model.Order_List;
import top.viewv.api.Serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProductItemController implements Initializable {

    public Label labProductName;
    public Label labPrice;
    public Label labProductId;
    public Label labProductRtime;
    public Label labDescrption;
    public JFXTreeTableView recipeTable;
    public JFXButton btnAddToShop;
    public JFXTextField tfxNumberInput;
    public JFXTextField txfDateinput;

    public static void ser(Object object, String filename) throws Exception {
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(object);
        oos.flush();
        oos.close();
    }

    public static ArrayList dSer(String filename) throws Exception {
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList array = (ArrayList) ois.readObject();
        return array;
    }

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
        int date = Integer.parseInt(txfDateinput.getText().trim());
        int product_id = Integer.parseInt(labProductId.getText().trim());

        ArrayList order_lists = Serialize.dSer("order.ser");

        Order_List order_list = new Order_List(product_id, numbers, date);
        order_lists.add(order_list);
        Serialize.ser(order_lists, "order.ser");
        System.out.println("Ser Ok!");
    }
}
