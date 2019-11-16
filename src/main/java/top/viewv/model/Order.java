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
    public void PlaceOrder(Connection conn, HashMap mess,int days,String account_id){
        try{
            this.situation = 0;
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
            sql = "select client_id from client where account_id = " +  account_id;
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            rs.next();
            this.client_id = rs.getString(1);
            sql = "select count(order_id) from `order`";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            rs.next();
            this.order_id = rs.getInt(1) + 1;

            sql = "insert into `order`(order_id,client_id,order_time,due_time,situation) values(" +
            this.order_id + "," +
            this.client_id + ",'" +
            this.order_time + " 00:00:00','" +
            this.due_time + " 00:00:00'," +
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
                sum += (rs.getFloat(1) * (float)y);

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
            sql = "update `order` set deposit = " + this.deposit + "where order_id = " +
                    this.order_id;
            st.execute(sql);
            sql = "update `order` set retainage = " + this.retainage + "where order_id = " +
                    this.order_id;
            st.execute(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public void AcceptOrder(Connection conn,String staff_id,int OrderId){
        try {
            this.situation = 2;
            this.staff_id = staff_id;
            String sql = "update `order` set staff_id = "
                    +staff_id
                    +"where order_id = "
                    +OrderId;
            PreparedStatement st = conn.prepareStatement(sql);
            st.execute(sql);
            sql = "update `order` set situation = 2"
                    +staff_id
                    +"where order_id = "
                    +OrderId;
            st = conn.prepareStatement(sql);
            st.execute(sql);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //处理职员接受订单
    }

    public void DenyOrder(Connection conn,int OrderId){
        try{
            String sql = "update `order` set situation = 1 "
                    +"where order_id = "
                    +OrderId;
            PreparedStatement st = conn.prepareStatement(sql);
            st.execute(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void DeliverOrder(Connection conn,int OrderId){
        try{
            String sql = "";
            PreparedStatement st = conn.prepareStatement(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void AskReturn(Connection conn,int OrderId){
        try{
            String sql = "update `order` set situation = 4 "
                    +"where order_id = "
                    +OrderId;
            PreparedStatement st = conn.prepareStatement(sql);
            st.execute(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void AcceptReturn(Connection conn,int OrderId){
        try{
            String sql = "update `order` set situation = 5 "
                    +"where order_id = "
                    +OrderId;
            PreparedStatement st = conn.prepareStatement(sql);
            st.execute(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void DenyReturn(Connection conn,int OrderId){
        try{
            String sql = "update `order` set situation = 3 "
                    +"where order_id = "
                    +OrderId;
            PreparedStatement st = conn.prepareStatement(sql);
            st.execute(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void ProcessReturn(Connection conn,int OrderId){
        try{
            String sql = "";
            PreparedStatement st = conn.prepareStatement(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void InitOrderById(Connection conn,int id) {
        try {
            String sql = "select * from `order` where order_id = " + id;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            this.order_id = rs.getInt(1);
            this.client_id = rs.getString(2);
            this.staff_id = rs.getString(3);
            this.order_time = rs.getDate(4);
            this.due_time = rs.getDate(5);
            this.deposit = rs.getFloat(6);
            this.retainage = rs.getFloat(7);
            this.situation = rs.getInt(8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //从数据库获取订单信息

       public Order_Product[] InitProductById(Connection conn, int id){
        try{
            String sql = "select count(product_id) from order_product where order_id = " + id;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            rs.next();
            int length = rs.getInt(1);
            Order_Product[] OP = new Order_Product[length];

            sql = "select product.product_id,product_name,amount,product_price " +
                    "from order_product,product where order_product.product_id = product.product_id" +
                    " and order_id = " + id;
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            int cnt = 0;
            while(rs.next()){
                OP[cnt] = new Order_Product(rs.getInt(1),rs.getString(2), rs.getInt(3),rs.getInt(4));
                cnt++;
            }
            return OP;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int[] Orders(Connection conn,String account_id){
        try{
            String sql = "select count(order_id) from `order` where client_id = " +
                    "(select client_id from client where account_id = " +
                    account_id + ")";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            rs.next();
            int length = rs.getInt(1);
            int[] O = new int[length];

            sql = "select order_id from `order` where client_id = " +
                    "(select client_id from client where account_id = " +
                    account_id + ")";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            int cnt = 0;
            while(rs.next()){
                O[cnt] = rs.getInt(1);
            }
            return O;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
