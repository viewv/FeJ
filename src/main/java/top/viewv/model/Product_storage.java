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

    public Product_storage(){}

    public Product_storage(int a,int b,int c,String d,int e,int f,java.sql.Date g){
        this.order_id = a;
        this.product_id = b;
        this.amount = c;
        this.staff_id = d;
        this.workshop_id = e;
        this.plan_id = f;
        this.product_time = g;
    }

    public Product_storage[] GetAll(Connection conn){
        try{
            int cnt;
            String sql = "select count(*) from product_storage";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            cnt = rs.getInt(1);
            Product_storage[] X = new Product_storage[cnt];
            sql = "select * from product_storage";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            cnt = 0;
            while(rs.next()){
                X[cnt] = new Product_storage(rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getDate(8));
                cnt++;
            }
            return X;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


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

    public void EnStorage2(Connection conn,int OrderID){
        try{
            String sql = "update product_storage set order_id = 0 where order_id = " +
                    OrderID;
            PreparedStatement st = conn.prepareStatement(sql);
            st.executeQuery(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    //To Do
    public void OutStorage(Connection conn,int OrderId,int ProductId,int amount){
        try{
            String sql = "call OutProductStorage("+OrderId+","+ProductId+","+amount+")";
            System.out.println(sql);
            PreparedStatement st = conn.prepareStatement(sql);
            st.execute(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public int[] CheckDestroy(Connection conn){
        try{
            String sql = "select count(product_storage.id) from product_storage,product where " +
                    "product_storage.product_id = product.product_id and" +
                    " (product_period-TIMESTAMPDIFF(DAY,product_time,CURRENT_DATE)) < 0" +
                    "and order_id = 0";
            PreparedStatement st = conn.prepareStatement(sql);
            st.executeQuery(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            int row = rs.getInt(1);
            int[] temp = new int[row];
            int cnt = 0;

            sql = "select product_storage.id from product_storage,product where " +
                    "product_storage.product_id = product.product_id and" +
                    " (product_period-TIMESTAMPDIFF(DAY,product_time,CURRENT_DATE)) < 0" +
                    "and order_id = 0";
            st = conn.prepareStatement(sql);
            st.executeQuery(sql);
            while(rs.next()){
                temp[cnt] = rs.getInt(1);
                cnt++;
            }
            return temp;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void DestroyItem(Connection conn,int id){
        try{
            String sql = "delete from product_storage where id = " + id;
            PreparedStatement st = conn.prepareStatement(sql);
            st.execute(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}