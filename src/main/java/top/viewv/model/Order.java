package top.viewv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;


public class Order {
    public int order_id;
    public String client_id;
    public String staff_id;
    public java.sql.Date order_time;
    public java.sql.Date due_time;
    public float deposit;
    public float retainage;
    public int situation;
    public HashMap<Integer,Integer> Ingres;

    public void GetId(Connection conn){
        try{
            String sql = "select count(order_id) from `order`";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            rs.next();
            this.order_id = rs.getInt(1);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    //用户下达订单
    public void PlaceOrder(Connection conn, HashMap mess,int days,String client_id){
        try{
            this.situation = 0;
            this.client_id = client_id;
            this.Ingres = mess;
            this.order_time = new java.sql.Date(System.currentTimeMillis());
            Calendar calendar =new GregorianCalendar();
            calendar.setTime(this.order_time);
            calendar.add(calendar.DATE, +days);
            java.util.Date utilDate = calendar.getTime();
            System.out.println(utilDate);
            this.due_time = new java.sql.Date(utilDate.getTime());


            String sql;
            PreparedStatement st;
            ResultSet rs;
            sql = "select count(order_id) from `order`";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            rs.next();
            this.order_id = rs.getInt(1) + 1;
            sql = "insert into order(client_id,order_time,due_time,situation) values(" +
            this.client_id + "," +
            this.order_time + "," +
            this.due_time + "," +
            this.situation + ")";
            st.execute(sql);





            double sum = 0.00;
            Iterator iter = Ingres.entrySet().iterator();
            while(iter.hasNext()){
                Map.Entry entry = (Map.Entry)iter.next();
                int x = Integer.parseInt(entry.getKey().toString());
                int y = Integer.parseInt(entry.getValue().toString());

                sql = "select product_price from product where product_id = " + x;
                st = conn.prepareStatement(sql);
                rs = st.executeQuery();
                rs.next();
                sum += rs.getDouble(1);

                sql = "insert into order_product(amount,product_id,order_id) values(" + y + "," + x + "," + this.order_id + ")" ;
                st.execute(sql);
            }

            int credit;
            sql = "select credit from client where client_id = " + this.client_id;
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            rs.next();
            credit = rs.getInt(1);
            //to do credit

            this.deposit = (float)(0.3 * sum);
            this.retainage = (float)(0.7 * sum);
            sql = "update order set deposit = " + this.deposit + "where order_id = " +
                    this.order_id;
            st.execute(sql);
            sql = "update order set retainage = " + this.retainage + "where order_id = " +
                    this.order_id;
            st.execute(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public void AcceptOrder(Connection conn,String staff_id){
        try {
            this.situation = 2;
            this.staff_id = staff_id;
            String sql = "update `order` set staff_id = "
                    +staff_id
                    +"where order_id = "
                    +this.order_id;
            PreparedStatement st = conn.prepareStatement(sql);
            st.execute(sql);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void ReadById(Connection conn,int id){
        try{
            String sql = "select * from `order` where order_id = " + id;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    //处理职员接受订单
}
