package top.viewv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Product {
    public int product_id;
    public String product_name;
    public int product_period;
    public float product_price;
    public String description;

    public Product(int id,String name,int period,float price,String description){
        this.product_id = id;
        this.product_name = name;
        this.product_period = period;
        this.product_price = price;
        this.description = description;
    }

    public void GetProduct(Connection conn,int id){
        try{
            String sql = "select * from product where product_id = " +
                    id;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            rs.next();
            this.product_id = id;
            this.product_name = rs.getString(2);
            this.product_period = rs.getInt(3);
            this.product_price = rs.getFloat(4);
            this.description = rs.getString(5);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
