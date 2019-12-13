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

    public Finance(int a,int b,int c,float d,String e){
        this.id = a;
        this.type = b;
        this.order_id = c;
        this.money = d;
        this.staff_id = e;
    }

    public Finance(){

    }
//type = (1.订单收入 2.退款支出)

    public int InCome(Connection conn, int OrderID, String staff_id) {
        try {
            String sql = "select Income(" +
                    OrderID + ",\"" + staff_id +"\")";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            return rs.getInt(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    //TODO Add result

    public int OutCome(Connection conn, int OrderID,String staff_id){
        try{
            String sql = "select Outcome(" +
                    OrderID + ",\"" + staff_id +"\")";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            return rs.getInt(1);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    //TODO Add result

    public Finance[] GetAll(Connection conn){
        try{
            String sql = "select count(id) from Finance";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            rs.next();
            int cnt = rs.getInt(1);
            Finance[] X = new Finance[cnt];
            cnt = 0;

            sql = "select * from Finance";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            while(rs.next()){
                X[cnt] = new Finance(rs.getInt(1),
                                     rs.getInt(2),
                                     rs.getInt(3),
                                     rs.getFloat(4),
                                     rs.getString(5));
                cnt++;
            }
            return X;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}