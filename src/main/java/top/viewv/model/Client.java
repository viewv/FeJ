package top.viewv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Client {
    public String client_id;
    public float balance;
    public String account_id;
    public int credit;

    public Client(String a,float b,String c,int d){
        this.client_id = a;
        this.balance = b;
        this.account_id = c;
        this.credit = d;
    }

    public String CreateClient(Connection conn,String client_id,float balance){
        try{
            this.account_id = "0";
            this.credit = 3;
            this.balance = balance;
            this.client_id = client_id;

            String sql = "select CreateClient(?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,client_id);
            st.setFloat(2,balance);
            ResultSet rs = st.executeQuery();
            rs.next();
            return rs.getString(1);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String UpdateClient(Connection conn,String oldid,String newid,float balance,int credit){
        try{
            String sql = "select UpdateClient(?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,oldid);
            st.setString(2,newid);
            st.setFloat(3,balance);
            st.setInt(4,credit);
            ResultSet rs = st.executeQuery();
            rs.next();
            return rs.getString(1);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String DeleteClient(Connection conn,String client_id){
        try{
            String sql = "select DeleteClient(?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,client_id);
            ResultSet rs = st.executeQuery();
            rs.next();
            return rs.getString(1);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static Client GetClient(Connection conn,String client_id){
        try{
            String sql = "select count(*) from client where client_id = " + '"'+ client_id +'"' ;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            rs.next();
            int cnt = rs.getInt(1);
            if (cnt == 0) return null;
            else{
                sql = "select * from client where client_id = " + '"'+ client_id +'"';
//                System.out.println("SQL:"+sql);
                st = conn.prepareStatement(sql);
                rs = st.executeQuery();
                rs.next();
                Client c = new Client(rs.getString(1),rs.getFloat(2),rs.getString(3),rs.getInt(4));
                return c;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String[] GetAllClient(Connection conn){
        try{
            String sql = "select count(client_id) from client";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            rs.next();
            int row = rs.getInt(1);
            String c[] = new String[row];
            if (row == 0) return null;
            else{
                sql = "select client_id from client";
                st = conn.prepareStatement(sql);
                rs = st.executeQuery();
                int cnt = 0;
                while (rs.next()){
                    c[cnt] = rs.getString(1);
                    cnt++;
                }
                return c;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
