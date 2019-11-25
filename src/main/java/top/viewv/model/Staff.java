package top.viewv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Staff {
    public String staff_id;
    public String name;
    public int age;
    public java.sql.Date entry_date;
    public String account;


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

    public int AddStaff(Connection conn,String staff_id,String name,int age){
        try{
            this.name = name;
            this.age = age;
            this.entry_date = new java.sql.Date(System.currentTimeMillis());
            this.staff_id = staff_id;
            this.account = "0";
            String sql = "select AddStaff(\"" + staff_id +
                    "\",\"" + name +"\"," + age +")";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            return rs.getInt(1);

        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    //1.staff already exists 2.success 0.null

    public int DeleteStaff(Connection conn,String staff_id){
        try{
            String sql = "select DeleteStaff(\"" + staff_id +
                    "\")";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            return rs.getInt(1);
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    //1.staff doesn't exist 2.success 0.null

    public int PromoteStaff(Connection conn,String id){
        try{
            String sql = "select PromoteStaff(\"" + staff_id +
                    "\")";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            return rs.getInt(1);
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    //0.null,1.staff doesn't exist,2.already a manager,3.success

    public int DismissManager(Connection conn,String id){
        try{
            String sql = "select DismissManager(\"" + staff_id +
                    "\")";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            return rs.getInt(1);
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
//0.null,1.staff doesn't exist,2.not a manager,3.success
