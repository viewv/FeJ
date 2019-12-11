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
import javafx.scene.Group;
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

public class DeveHomeController implements Initializable {

    public ImageView userIcon;
    public JFXButton btnExit;
    public JFXButton btnShopList;
    public JFXButton btnCheckAll;
    public JFXButton btnShowAllproduct;
    public AnchorPane BasePane;
    public Label labUserName;
    public JFXProgressBar pbarBusy;
    public Label userId;
    public JFXButton btnCleanShopList;
    @FXML
    private VBox pnl_scroll;
    public JFXTextField arename;
    public JFXTextField areprice;
    public JFXTextField arepre;
    public JFXTextField aredes;
    public Group groupInfo;

    Connection conn = new Connect().getConnection();

    private HashMap<Integer, Integer> order_lists = new HashMap<Integer, Integer>();
    private HashMap<Integer, Receipe_Info> all_Receipe = new HashMap<Integer, Receipe_Info>();


    public DeveHomeController() throws IOException, ClassNotFoundException {
    }

    public void setShopListCorl(boolean cond){
        btnCheckAll.setVisible(cond);
        btnCleanShopList.setVisible(cond);
        arename.setVisible(cond);
        arepre.setVisible(cond);
        aredes.setVisible(cond);
        areprice.setVisible(cond);
        groupInfo.setVisible(cond);
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
                        .getResource("data/ui/DevProductItem.fxml"));
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
                Logger.getLogger(DeveHomeController.class.getName()).log(Level.SEVERE, null, ex);
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

    public void onClickedbtnShopList() throws Exception {
        setShopListCorl(true);
        refeshShopList();
    }

    public void refeshShopList() {

        pnl_scroll.getChildren().clear();

        int length = all_Receipe.size();
        Node[] nodes = new Node[length];
        Node node;
        int i = 0;
        for (Map.Entry<Integer, Receipe_Info> entry : all_Receipe.entrySet()) {
            Integer key = entry.getKey();
            Receipe_Info value = entry.getValue();
            try {
                FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(
                        Thread.currentThread().
                                getContextClassLoader().
                                getResource("data/ui/DevIsItem.fxml")));

                node = loader.load();

                IsItemController shopListItemController = loader.getController();
                shopListItemController.setLabProductId(key);
                shopListItemController.setLabAmount(value.Amount);
                shopListItemController.setLabProductName(value.IngredientName);

                nodes[i] = node;
                pnl_scroll.getChildren().add(nodes[i]);
                i++;
            } catch (IOException ex) {
                Logger.getLogger(DeveHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void onClickedbtnCheckAll() throws Exception {

        int length = all_Receipe.size();

        SpecificRecipe[] specificRecipes = new  SpecificRecipe[length];

        SpecificRecipe specificRecipe = new SpecificRecipe();

        int i = 0;
        for (Map.Entry<Integer, Receipe_Info> entry : all_Receipe.entrySet()) {
            Integer key = entry.getKey();
            Receipe_Info value = entry.getValue();
            specificRecipe.setAll(value.IngredientId,value.IngredientName,value.Amount);
            specificRecipes[i]=specificRecipe;
        }

        RecipeTable recipeTable = new RecipeTable(specificRecipes,0,length);

        float price = Float.parseFloat(areprice.getText());
        String name = arename.getText();
        String des = aredes.getText();
        int pre = Integer.parseInt(arepre.getText());
        Product product = new Product(0,name,pre,price,des);

        int message = product.AddProduct(recipeTable,product,conn);

        JFXSnackbar snackbar = new JFXSnackbar(BasePane);
        snackbar.show("Send Order Successfully"+message, 1000);
        all_Receipe.clear();
        onClickedbtnShopList();
    }

    public void onClickedbtnShowAllProduct() throws Exception {
        refreshNodes();
    }

    public void onClickedbtnCleanShopList() throws Exception {
        all_Receipe.clear();
        refeshShopList();
    }

    public void onClickedbtnShowAllIs() {
        setShopListCorl(false);

        Ingredient ingredient = new Ingredient();
        Ingredient[] ingredients = ingredient.GetAll(conn);
        pnl_scroll.getChildren().clear();
        int length = ingredients.length;

        //String[] names = Ingredient.GetName(conn,length);

        Node[] nodes = new Node[length];
        Node node;

        for (int i=0;i<length;i++){
            ingredient = ingredients[i];
            try {
                FXMLLoader loader = new
                        FXMLLoader(Objects.requireNonNull(getClass()).getClassLoader()
                        .getResource("data/ui/IsItem.fxml"));
                node = loader.load();
                //调用下面的函数可以得到控制器
                //商品部分
                IsItemController productItemController = loader.getController();
                //roductItemController.setLabAmount(ingredient.amount);
                //assert names != null;
                productItemController.setLabProductName(ingredient.ingredient_name);
                productItemController.setLabProductId(ingredient.ingredient_id);
                productItemController.setLabStaff(String.valueOf(ingredient.ingredient_cost));
                productItemController.setHomeController(this);
                productItemController.setLabTime(ingredient.ingredient_period);
                nodes[i] = node;
                pnl_scroll.getChildren().add(nodes[i]);
            } catch (IOException ex) {
                Logger.getLogger(DeveHomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void addtoReceipe(IsItemController item){
        Integer ingrId = Integer.valueOf(item.labProductId.getText());
        String ingrName = item.labProductName.getText();
        Integer amount = Integer.valueOf(item.tfxNumberInput.getText());
        Receipe_Info receipe_info = new Receipe_Info(ingrId,ingrName,amount);
        if (!all_Receipe.containsKey(ingrId)){
            all_Receipe.put(ingrId,receipe_info);
        }else {
            amount += all_Receipe.get(ingrId).Amount;
            receipe_info.setAmount(amount);
            all_Receipe.put(ingrId,receipe_info);
            System.out.println(receipe_info.getAmount());
        }
    }
}
