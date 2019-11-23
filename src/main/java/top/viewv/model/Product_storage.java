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

    public int EnStorage1(Connection conn,int product_id,int amount,String staff_id,int workshop_id,int plan_id){
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
            sql = "select (EnProductStorage1(?,?,?,?,?))";
            st = conn.prepareStatement(sql);
            st.setInt(1,product_id);
            st.setInt(2,amount);
            st.setString(3,staff_id);
            st.setInt(4,workshop_id);
            st.setInt(5,plan_id);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            return rs.getInt(1);
        }

        catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    //To Do
    public void OutStorage(Connection conn,int OrderId,int ProductId,int amount){
        try{
            String sql = "call OutProductStorage(?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,OrderId);
            st.setInt(2,ProductId);
            st.setInt(3,amount);
            st.execute(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}