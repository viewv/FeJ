package top.viewv.controller;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import top.viewv.api.Gravatar;
import top.viewv.api.Serialize;
import top.viewv.database.Connect;
import top.viewv.model.*;
import top.viewv.model.Tables.ProductTable;
import top.viewv.model.Tables.RecipeTable;
import top.viewv.view.StageManager;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author oXCToo
 */
// !Thank you very much! oXCToo!

public class SaleHomeController implements Initializable {

    public ImageView userIcon;
    public JFXButton btnExit;
    public JFXButton btnShopList;
    public JFXButton btnShowAllproduct;
    public AnchorPane BasePane;
    public Label labUserName;
    public JFXButton btnOrderInfo;
    public JFXProgressBar pbarBusy;
    public Label userId;
    public Label labAllM;
    public JFXButton btnAddUser;
    public JFXTextField areCre;
    public JFXTextField areMoney;
    public JFXTextField areId;
    public Label labIDA;
    public Label labC;
    @FXML
    private VBox pnl_scroll;
    Connection conn = new Connect().getConnection();

    private HashMap<Integer, Integer> order_lists = new HashMap<Integer, Integer>();
    private HashMap<Integer, Order_Info> all_Orders = new HashMap<Integer, Order_Info>();
    private Product product = new Product(0, "0", 0, (float) 0.1, "0");

    public SaleHomeController() throws IOException, ClassNotFoundException {
    }

    public void setShopListCorl(boolean cond){
        labAllM.setVisible(cond);
        btnAddUser.setVisible(cond);
        areMoney.setVisible(cond);
        areId.setVisible(cond);
        labIDA.setVisible(cond);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pbarBusy.setVisible(false);
        setShopListCorl(false);
        try {
            Serialize.ser(order_lists, "order.ser");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setlabUserId(String userid) {
        userId.setText(userid);
    }

    public void setLabUserName(String userName) {
        labUserName.setText(userName);
    }

    public void refreshNodes() throws Exception {
        setShopListCorl(false);
        System.out.println("Start Refresh Node");
        pbarBusy.setVisible(true);
        pnl_scroll.getChildren().clear();

        ProductTable pt = new ProductTable();
        pt.GetLength(conn);
        pt.GetContent(conn);

        HashMap<Integer, String> productdict = Serialize.dSer("product.ser");

        RecipeTable rt = new RecipeTable();

        int length = pt.Plength;

        Node[] nodes = new Node[length];
        Node node;

        for (int i = 0; i < length; i++) {
            try {
                FXMLLoader loader = new
                        FXMLLoader(Objects.requireNonNull(getClass()).getClassLoader()
                        .getResource("data/ui/SaleProductItem.fxml"));
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
                productItemController.setTableRec(rt.Itable);
                nodes[i] = node;
                pnl_scroll.getChildren().add(nodes[i]);
                //删除所有节点，有点残忍，还是隐藏比较好
                //pnl_scroll.getChildren().removeAll();
                if (!productdict.containsKey(pt.Ptable[i].product_id)) {
                    productdict.put(pt.Ptable[i].product_id, pt.Ptable[i].product_name);
                }
            } catch (IOException ex) {
                Logger.getLogger(SaleHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        pbarBusy.setVisible(false);
        Serialize.ser(productdict, "product.ser");
    }

    public void setUserIcon(String email) {
        userIcon.setImage(Gravatar.imageFromMail(email));
    }

    public void onClickedbtnExit() throws IOException {
        MainController secondControl = (MainController) StageManager.CONTROLLER.get("index");
        secondControl.setTranDataToIndex("第三个窗口的数据");
        //如果本窗口还使用该控制器先不remove这个控制器;
        //StageManager.CONTROLLER.remove("secondControl");

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("data/ui/Main.fxml")));
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

    public void onClickedUserManage(MouseEvent mouseEvent) throws Exception {
        setShopListCorl(true);
        refeshUser();
    }

    public void delOneClient(String clientId) throws Exception {
        Client client = new Client("",0,"",0);
        client.DeleteClient(conn,clientId);
        refeshUser();
    }

    public void updateOneClient(String oldid,String newid,float balance,int credit) throws Exception {
        Client client = new Client("",0,"",0);
        System.out.println("OldID"+oldid);
        System.out.println("Bal"+balance);
        System.out.println(client.UpdateClient(conn,oldid,newid,balance,credit));
        refeshUser();
    }

    public void refeshUser() throws Exception {
        String[] clients = Client.GetAllClient(conn);
        int length = clients.length;
        pnl_scroll.getChildren().clear();
        Node[] nodes = new Node[length];
        Node node;
        for (int i=0;i<length;i++) {
            String clientId = clients[i];
            System.out.println("Id"+clientId);
            try {
                FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(
                        Thread.currentThread().
                                getContextClassLoader().
                                getResource("data/ui/UserItem.fxml")));
                node = loader.load();
                UserItemController itemController = loader.getController();
                Client client = Client.GetClient(conn,clientId);
                itemController.setHomeController(this);
                itemController.setLabBalance(client.balance);
                itemController.setLabCredit(client.credit);
                itemController.setLabUserId(clientId);
                nodes[i] = node;
                pnl_scroll.getChildren().add(nodes[i]);
            } catch (IOException ex) {
                Logger.getLogger(SaleHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void onClickedbtnShowAllProduct(MouseEvent mouseEvent) throws Exception {
        refreshNodes();
    }

    public void onClinckbtnOrderInfo() throws Exception {
        setShopListCorl(false);
        System.out.println("All Order");

        Order order = new Order();
        int[] allOrderId = order.SalesOrder(conn);
        int length = allOrderId.length;
        Node[] nodes = new Node[length];
        Node node;

        pnl_scroll.getChildren().clear();

        for (int i = 0; i < length; i++) {
            int orderid = allOrderId[i];
            System.out.println("Order ID" + orderid);
            order.InitOrderById(conn, orderid);
            try {
                FXMLLoader loader = new
                        FXMLLoader(Objects.requireNonNull(
                        Thread.currentThread().
                                getContextClassLoader().
                                getResource("data/ui/SaleOrderItem.fxml")));
                node = loader.load();
                SaleOrderItemController orderItemController = loader.getController();
                //调用生成table
                orderItemController.setLabOrderStatus(order.situation);
                orderItemController.setLabPrice(order.deposit + order.retainage);
                orderItemController.setLabOrdertId(orderid);
                orderItemController.setOrderStime(order.order_time);
                orderItemController.setOrderPtime(order.due_time);
                orderItemController.setController(this);
                Order_Product[] order_products = order.InitProductById(conn,orderid);
                orderItemController.setTableOrderShopList(order_products);
                nodes[i] = node;
                pnl_scroll.getChildren().add(nodes[i]);
            } catch (IOException ex) {
                Logger.getLogger(SaleHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void onClinckedAddUser(MouseEvent mouseEvent) throws Exception {
        float balance = Float.parseFloat(areMoney.getText());
        String id = areId.getText();
        Client client = new Client("",0,"",0);
        System.out.println(client.CreateClient(conn,id,balance));
        refeshUser();
    }

    public void returnOrder(int id) throws Exception {
        Order order = new Order();
        order.DenyOrder(conn,id);
        onClinckbtnOrderInfo();
    }

    public void acceptOrder(int id) throws Exception {
        Order order = new Order();
        order.AcceptOrder(conn,Staff.GetStaffID(userId.getText(),conn),id);
        onClinckbtnOrderInfo();
    }

    public void acceptReturn(int id) throws Exception {
        Order order = new Order();
        order.AcceptReturn(conn,id);
        onClinckbtnOrderInfo();
    }

    public void denyRetrun(int id) throws Exception {
        Order order = new Order();
        order.DenyReturn(conn,id);
        onClinckbtnOrderInfo();
    }
}
