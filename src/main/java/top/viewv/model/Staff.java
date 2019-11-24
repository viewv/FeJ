package top.viewv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Staff {
    public static String GetStaffID(String AID, Connection conn){
        try{
            String sql = "select staff_id from `full staff` where account_id = " + '"' + AID +'"';
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
