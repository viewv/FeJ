package top.viewv.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Worker {
    public int workshop;
    public Staff me;

    public Worker(String id, String name, int age, Date date, String account){
        this.me.staff_id = id;
        this.me.name = name;
        this.me.age = age;
        this.me.entry_date = date;
        this.me.account = account;
        this.workshop = Integer.parseInt(me.staff_id.substring(3,4));
    }

    //本车间的所有员工
    public Worker[] GetWorker(Connection conn,String staff_id){
        try{
            String department = staff_id.substring(0,1);
            String workshop = staff_id.substring(3,4);
            String sql = "select count(*) from staff where SUBSTR(staff_id,1,1)" +
                    "= \""  + department +"\"" + " and SUBSTR(staff_id,4,1) " +
                    "= \""  + workshop +"\"";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            int cnt = rs.getInt(1);

            Worker[] X = new Worker[cnt];
            sql = "select * from staff where SUBSTR(staff_id,1,1)" +
                    "= \""  + department +"\"" + " and SUBSTR(staff_id,4,1) " +
                    "= \""  + workshop +"\"";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            cnt = 0;
            while (rs.next()){
                X[cnt] = new Worker(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDate(4),
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

    //分配车间
    public int AllocateWorkshop(Connection conn,String id,int newwork){
        try{
            String sql = "select AllocateWorkshop(\"" + id +
                    "\","+ newwork + ")";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            return rs.getInt(1);
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    //1.无此人 2.错误车间 3.成功
}
