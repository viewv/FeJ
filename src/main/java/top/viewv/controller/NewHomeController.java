package top.viewv.controller;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.*;
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
import top.viewv.model.Order;
import top.viewv.model.Order_Info;
import top.viewv.model.Order_Product;
import top.viewv.model.Product;
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

public class NewHomeController implements Initializable {

    public ImageView userIcon;
    public JFXButton btnExit;
    public JFXButton btnShopList;
    public JFXButton btnCheckAll;
    public Label testLab;
    public JFXButton btnShowAllproduct;
    public AnchorPane BasePane;
    public Label labUserName;
    public JFXButton btnOrderInfo;
    public JFXProgressBar pbarBusy;
    public Label userId;
    public JFXButton btnCleanShopList;
    public JFXTextField areAmount;
    public Label labAllM;
    public Label labAllMoney;
    public Label labD;
    public JFXTextArea labSearch;

    Connection conn = new Connect().getConnection();

    private HashMap<Integer, Integer> order_lists = new HashMap<Integer, Integer>();
    private HashMap<Integer, Order_Info> all_Orders = new HashMap<Integer, Order_Info>();
    private Product product = new Product(0, "0", 0, (float) 0.1, "0");
    @FXML
    private VBox pnl_scroll;

    public NewHomeController() throws IOException, ClassNotFoundException {
    }

    public void setShopListCorl(boolean cond){
        areAmount.setVisible(cond);
        btnCheckAll.setVisible(cond);
        btnCleanShopList.setVisible(cond);
        labAllM.setVisible(cond);
        labAllMoney.setVisible(cond);
        areAmount.setVisible(cond);
        labD.setVisible(cond);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pbarBusy.setVisible(false);
        testLab.setVisible(false);
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
                        .getResource("data/ui/ProductItem.fxml"));
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
                Logger.getLogger(NewHomeController.class.getName()).log(Level.SEVERE, null, ex);
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

    public void onClickedbtnShopList(MouseEvent mouseEvent) throws Exception {
        setShopListCorl(true);
        refeshShopList();
    }

    public void refeshShopList() throws Exception {
        pnl_scroll.getChildren().clear();
        order_lists = Serialize.dSer("order.ser");
        int length = order_lists.size();
        double allP = 0;
        Node[] nodes = new Node[length];
        Node node;
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : order_lists.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key);
            System.out.println(value);
            System.out.println("-----");
            try {
                FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(
                        Thread.currentThread().
                                getContextClassLoader().
                                getResource("data/ui/ShopListItem.fxml")));
                node = loader.load();
                ShopListItemController shopListItemController = loader.getController();
                shopListItemController.setLabProductId(key);
                shopListItemController.setLabAmount(value);
                product.GetProduct(conn, key);
                //shopListItemController.setLabProductName(productdict.get(key));
                shopListItemController.setLabProductName(product.product_name);
                shopListItemController.setLabSinglePrice(product.product_price);
                double listAllPrice =  shopListItemController.setLabAllPrice();
                allP += listAllPrice;
                nodes[i] = node;
                pnl_scroll.getChildren().add(nodes[i]);
                //删除所有节点，有点残忍，还是隐藏比较好
                //pnl_scroll.getChildren().removeAll();
                i++;
            } catch (IOException ex) {
                Logger.getLogger(NewHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        DecimalFormat df = new DecimalFormat("0.00");
        labAllMoney.setText(df.format(allP));
    }

    public void onClickedbtnCheckAll(MouseEvent mouseEvent) throws Exception {
        System.out.println("Sending Order");
        Order order = new Order();
        order_lists = Serialize.dSer("order.ser");

        order.PlaceOrder(conn, order_lists, Integer.parseInt(areAmount.getText()), userId.getText());
        Order_Info order_info = new Order_Info();
        order_info.setClient_id(order.client_id);
        order_info.setOrder_id(order.order_id);
        order_info.setSituation(order.situation);
        order_info.setOrder_time(order.order_time);
        order_info.setDue_time(order.due_time);
        order_info.setDeposit(order.deposit);
        order_info.setRetainage(order.retainage);

        all_Orders.put(order.order_id, order_info);
        Serialize.ser(all_Orders, "all_order.ser");

        JFXSnackbar snackbar = new JFXSnackbar(BasePane);
        snackbar.show("Send Order Successfully", 1000);
        order_lists.clear();
        Serialize.ser(order_lists, "order.ser");

    }

    public void onClickedbtnShowAllProduct(MouseEvent mouseEvent) throws Exception {
        refreshNodes();
    }

    public void returnOrder(int id) throws Exception {
        Order order = new Order();
        order.AskReturn(conn,id);
        JFXSnackbar snackbar = new JFXSnackbar(BasePane);
        snackbar.show("开始处理您的退货请求", 1000);
        onClinckbtnOrderInfo();
    }

    public void onClinckbtnOrderInfo() throws Exception {
        setShopListCorl(false);
        areAmount.clear();

        Order order = new Order();
        int[] allOrderId = order.Orders(conn, userId.getText());
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
                                getResource("data/ui/OrderItem.fxml")));
                node = loader.load();
                OrderItemController orderItemController = loader.getController();
                //调用生成table
                orderItemController.setLabOrderStatus(order.situation);
                orderItemController.setLabPrice(order.deposit + order.retainage);
                orderItemController.setLabOrdertId(orderid);
                orderItemController.setOrderStime(order.order_time);
                orderItemController.setOrderPtime(order.due_time);
                Order_Product[] order_products = order.InitProductById(conn,orderid);
                orderItemController.setTableOrderShopList(order_products);
                orderItemController.setController(this);
                nodes[i] = node;
                pnl_scroll.getChildren().add(nodes[i]);
            } catch (IOException ex) {
                Logger.getLogger(NewHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void onclickedTestArray(MouseEvent mouseEvent) throws Exception {
        System.out.println("Test ArrList Lenfth");
        order_lists = Serialize.dSer("order.ser");
        testLab.setText(String.valueOf(order_lists.size()));

        for (Map.Entry<Integer, Integer> entry : order_lists.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key);
            System.out.println(value);
            System.out.println("-----");
        }
    }

    public void onClickedbtnCleanShopList(MouseEvent mouseEvent) throws Exception {
        order_lists = Serialize.dSer("order.ser");
        order_lists.clear();
        Serialize.ser(order_lists, "order.ser");
        refeshShopList();
    }

    public void onClinckbtnSearch(MouseEvent mouseEvent) throws Exception {
        String info = labSearch.getText();
        setShopListCorl(false);
        System.out.println("Start Refresh Node");
        pbarBusy.setVisible(true);
        pnl_scroll.getChildren().clear();

        ProductTable pt = new ProductTable();
        pt.GetLength(conn);
        pt.GetContent(conn);

        Product[] products = Product.SearchByName(info,conn);

        HashMap<Integer, String> productdict = Serialize.dSer("product.ser");

        RecipeTable rt = new RecipeTable();

        int length = products.length;

        Node[] nodes = new Node[length];
        Node node;

        for (int i = 0; i < length; i++) {
            try {
                FXMLLoader loader = new
                        FXMLLoader(Objects.requireNonNull(getClass()).getClassLoader()
                        .getResource("data/ui/ProductItem.fxml"));
                node = loader.load();
                //调用下面的函数可以得到控制器
                //商品部分
                ProductItemController productItemController = loader.getController();
                productItemController.setLabPrice(products[i].product_price);
                productItemController.setLabProductName(products[i].product_name);
                productItemController.setLabProductId(products[i].product_id);
                productItemController.setLabProductRtime(products[i].product_period);
                //配方介绍部分
                rt.GetAll(products[i].product_id, conn);
                productItemController.setLabDescrption(products[i].description);
                productItemController.setTableRec(rt.Itable);
                nodes[i] = node;
                pnl_scroll.getChildren().add(nodes[i]);
                //删除所有节点，有点残忍，还是隐藏比较好
                //pnl_scroll.getChildren().removeAll();
                if (!productdict.containsKey(products[i].product_id)) {
                    productdict.put(products[i].product_id, products[i].product_name);
                }
            } catch (IOException ex) {
                Logger.getLogger(NewHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        pbarBusy.setVisible(false);
        Serialize.ser(productdict, "product.ser");
        JFXSnackbar snackbar = new JFXSnackbar(BasePane);
        snackbar.show("为您找到上述结果", 1000);
    }
}
