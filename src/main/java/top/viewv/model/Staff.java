package top.viewv.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Staff {
    public String staff_id;
    public String name;
    public int age;
    public Date entry_date;
    public String account;

    public Staff(){

    }
    public Staff(String id,String name,int age,Date date,String account){
        this.staff_id = id;
        this.name = name;
        this.age = age;
        this.entry_date = date;
        this.account = account;
    }


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
    //TODO Add Result

    public Staff[] GetDepartmentStaff(Connection conn,String staff_id){
        try{
            String department = staff_id.substring(0,1);
            String sql = "select count(staff_id) from staff where staff_id like " +
                    "\"" + department + "%\"";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            int row = rs.getInt(1);
            System.out.println("Row:"+row);

            sql = "select * from staff where staff_id like " +
                    "\"" + department + "%\"";
            System.out.println("Staff Sql:"+sql);
            st = conn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            int cnt = 0;
            Staff[] S = new Staff[row];
            while (rs.next()){
                S[cnt] = new Staff(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDate(4),
                        rs.getString(5));
                cnt++;
            }
            return S;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
//0.null,1.staff doesn't exist,2.not a manager,3.success
