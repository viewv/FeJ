package top.viewv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Product_storage {
    public int order_id;
    public int product_id;
    public int amount;
    public String staff_id;
    public int workshop_id;
    public int plan_id;
    public java.sql.Date product_time;

    public void EnStorage(Connection conn,int product_id,int amount,String staff_id,int workshop_id,int plan_id){
        try{
            this.product_id = product_id;
            this.amount = amount;
            this.staff_id = staff_id;
            this.workshop_id = workshop_id;
            this.plan_id = plan_id;
            this.order_id = 0; //刚入库时对应的订单ID都为0
            this.product_time = new java.sql.Date(System.currentTimeMillis());

            String sql;
            PreparedStatement st;
            sql = "insert into product_storage" +
                    "(order_id,product_id,amount,staff_id,workshop_id,plan_id,product_time) values(" +
                    0 + "," + product_id + "," + amount + "," + staff_id + "," +
                    workshop_id + "," + plan_id + ",'" +
                    this.product_time + " 00:00:00')";
            st = conn.prepareStatement(sql);
            st.execute(sql);
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }

    //To Do
    public void OutStorage(Connection conn,int OrderId,int ProductId,int amount){
        try{

        }
        catch(Exception e){

        }
    }
}