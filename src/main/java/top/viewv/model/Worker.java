package top.viewv.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Worker {
    public int workshop;
    public Staff me;

    public Worker(String id, String name, int age, Date date, String account){
        this.me = new Staff(id,name,age,date,account);
        this.workshop = Integer.parseInt(me.staff_id.substring(3,4));
    }

    public Worker(){

    }

    //本车间的所有员工
    public static Worker[] GetWorker(Connection conn,String staff_id){
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
    public static int AllocateWorkshop(Connection conn,String id,int newwork){
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

    //该车间对应的当前生产计划的内容（产品编号，产品名，数量）
    public static Record[] CheckPlanContent(Connection conn, int workshop){
        try{
            String sql = "select plan_id from plan where CURRENT_DATE > " +
                    "plan.start_date and CURRENT_DATE <= plan.end_date";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            int planid = rs.getInt(1);

            sql = "select count(*) from `full plan_content` " +
                    "where workshop_id = " + workshop + " and plan_id = " +
                    planid;
            st = conn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            rs.next();
            int cnt = rs.getInt(1);
            Record[] X = new Record[cnt];
            cnt = 0;

            sql = "select product_id,product_name,amount from `full plan_content` " +
                    "where workshop_id = " + workshop + " and plan_id = " +
                    planid;
            st = conn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            while(rs.next()){
                X[cnt] = new Record(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)
                );
                cnt++;
            }
            return X;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //已经生产的部分（产品编号，产品名，数量）
    public static Record[] CheckProductContent(Connection conn, int workshop){
        try{
            String sql = "select count(product_id) from (select product.product_id,product.product_name,sum(amount) tot " +
                    "from product_storage,product where workshop_id = " + workshop +
                    " and plan_id = (select plan_id from plan where CURRENT_DATE > plan.start_date " +
                    "and CURRENT_DATE <= plan.end_date) " +
                    "and product_storage.product_id = product.product_id " +
                    "group by product.product_id)x";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            int cnt = rs.getInt(1);
            if (cnt == 0){
                return null;
            }
            else{
                Record[] X = new Record[cnt];
                cnt = 0;

                sql = "select product.product_id,product.product_name,sum(amount) tot " +
                        "from product_storage,product where workshop_id = " + workshop +
                        " and plan_id = (select plan_id from plan " +
                        "where CURRENT_DATE >= plan.start_date " +
                        "and CURRENT_DATE <= plan.end_date) " +
                        "and product_storage.product_id = product.product_id " +
                        "group by product.product_id";
                st = conn.prepareStatement(sql);
                rs = st.executeQuery(sql);
                while(rs.next()){
                    X[cnt] = new Record(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getInt(3)
                    );
                    cnt++;
                }
                return X;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
