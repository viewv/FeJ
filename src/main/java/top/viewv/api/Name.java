package top.viewv.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Name {
    public static String GetPname(Connection conn,int pid){
        try{
            String sql = "select product_name from product where product_id = " + pid;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            return rs.getString(1);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String GetIname(Connection conn,int iid){
        try{
            String sql = "select ingredient_name from ingredient where ingredient_id = " + iid;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            return rs.getString(1);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
