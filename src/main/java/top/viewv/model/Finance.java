package top.viewv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Finance {
    public int id;
    public int type;
    public int order_id;
    public float money;
    public String staff_id;

//type = (1.订单收入 2.退款支出)

    public int InCome(Connection conn, int OrderID, String staff_id) {
        try {
            String sql = "select Income(?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,OrderID);
            st.setString(2,staff_id);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            return rs.getInt(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int OutCome(Connection conn, int OrderID,String staff_id){
        try{
            String sql = "select Outcome(?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,OrderID);
            st.setString(2,staff_id);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            return rs.getInt(1);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}