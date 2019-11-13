package top.viewv.controller;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import top.viewv.api.Gravatar;
import top.viewv.api.Serialize;
import top.viewv.database.Connect;
import top.viewv.model.Order_List;
import top.viewv.model.Tables.ProductTable;
import top.viewv.model.Tables.RecipeTable;
import top.viewv.view.StageManager;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author oXCToo
 */
// !Thank you very much! oXCToo!

public class newhomeController implements Initializable {

    public ImageView userIcon;
    public JFXButton btnExit;
    public JFXButton btnShopList;
    public JFXButton btnCheckAll;
    public Label testLab;
    ArrayList<Order_List> order_lists = new ArrayList<>();
    Connection conn = new Connect().getConnection();
    @FXML
    private VBox pnl_scroll;

    public void addOrderList(Order_List order_list) {
        order_lists.add(order_list);
    }

    public int getOrderListLength(ArrayList order_lists) {
        return order_lists.size();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //tt.start();
        //btnCheckAll.setVisible(false);
        refreshNodes();
        setUserIcon();
        try {
            Serialize.ser(order_lists, "order.ser");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refreshNodes() {
        pnl_scroll.getChildren().clear();

        ProductTable pt = new ProductTable();
        pt.GetLength(conn);
        pt.GetContent(conn);

        RecipeTable rt = new RecipeTable();

        int length = pt.Plength;

        Node[] nodes = new Node[length];
        Node node;

        for (int i = 0; i < length; i++) {
            try {
                FXMLLoader loader = new
                        FXMLLoader(Objects.requireNonNull(
                        Thread.currentThread().
                                getContextClassLoader().
                                getResource("data/ProductItem.fxml")));
                node = loader.load();
                //调用下面的函数可以得到控制器
                //商品部分
                ProductItemController productItemController = loader.getController();
                productItemController.setLabPrice(pt.Ptable[i].product_price);
                productItemController.setLabProductName(pt.Ptable[i].product_name);
                productItemController.setLabProductId(pt.Ptable[i].product_id);
                productItemController.setLabProductRtime(pt.Ptable[i].product_period);
                //配方介绍部分
                rt.GetAll(pt.Ptable[i].product_id, conn);
                productItemController.setLabDescrption(pt.Ptable[i].description);
                nodes[i] = node;
                pnl_scroll.getChildren().add(nodes[i]);
                //删除所有节点，有点残忍，还是隐藏比较好
                //pnl_scroll.getChildren().removeAll();
            } catch (IOException ex) {
                Logger.getLogger(newhomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void setUserIcon() {
        userIcon.setImage(Gravatar.imageFromMail("zxnnet@gmail.com"));
    }

    public void onClickedbtnExit() throws IOException {
        MainController secondControl = (MainController) StageManager.CONTROLLER.get("index");
        secondControl.setTranDataToIndex("第三个窗口的数据");
        //如果本窗口还使用该控制器先不remove这个控制器;
        //StageManager.CONTROLLER.remove("secondControl");

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("data/Main.fxml")));
        stage.setTitle("Index");
        stage.setScene(new Scene(root));
        stage.show();
        //将第二个窗口保存到map中
        StageManager.STAGE.put("second", stage);
        //将本窗口保存到map中
        StageManager.CONTROLLER.put("index", this);
        //关闭本窗口
        Stage index = (Stage) btnExit.getScene().getWindow();
        index.close();
    }

    public void onClickedbtnShopList(MouseEvent mouseEvent) {
    }

    public void onClickedbtnCheckAll(MouseEvent mouseEvent) {

    }

    public void onclickedTestArray(MouseEvent mouseEvent) throws Exception {
        System.out.println("Test ArrList Lenfth");
        order_lists = Serialize.dSer("order.ser");
        testLab.setText(String.valueOf(order_lists.size()));
    }

//    public static void ser(Object object,String filename) throws Exception {
//        FileOutputStream fos = new FileOutputStream(filename);
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(object);
//        oos.flush();
//        oos.close();
//    }
//
//
//    public static ArrayList dSer(String filename) throws Exception {
//        FileInputStream fis = new FileInputStream(filename);
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        ArrayList array = (ArrayList) ois.readObject();
//        return array;
//    }
}
