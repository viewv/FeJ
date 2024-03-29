package top.viewv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Plan {
    public int plan_id;
    public java.sql.Date start_time;
    public java.sql.Date end_time;
    public String planner_id;
    public int[][] Pro;


    public void SetPlan(int[][] mess, java.sql.Date start_time, java.sql.Date end_time, String Aid, Connection conn){
        try{
            this.Pro = mess;
            this.start_time = start_time;
            this.end_time = end_time;

            String sql;
            PreparedStatement st;
            ResultSet rs;
            sql = "select staff_id from staff where account_id = " + "\"" + Aid +"\"";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            rs.next();
            this.planner_id = rs.getString(1);
            sql = "select plan_id from plan order by plan_id desc limit 1";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            rs.next();
            this.plan_id = rs.getInt(1) + 1;


            sql = "insert into plan values(" +
                    plan_id + ",'" +
                    start_time + " 00:00:00','" +
                    end_time + " 00:00:00'," +
                    planner_id + ")";
            st.execute(sql);


            for (int i = 0; i < mess.length; ++i){
                    int x = mess[i][0]; //product_id
                    int y = mess[i][1]; //amount
                    int z = mess[i][2]; //workshop_id

                    sql = "insert into plan_content(plan_id,workshop_id,product_id,amount)" +
                            " values(" + plan_id + "," + z + "," + x + "," + y + ")";
                    st.execute(sql);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void InitPlanById(int plan_id, Connection conn){
        try{
            String sql = "select * from `plan` where plan_id = " + plan_id;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            rs.next();
            this.plan_id = rs.getInt(1);
            this.start_time = rs.getDate(2);
            this.end_time = rs.getDate(3);
            this.planner_id = rs.getString(4);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public int[][] InitProductById(int plan_id,Connection conn){
        try{
            String sql = "select count(*) from `plan_content` where plan_id = " + plan_id;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            rs.next();
            int row = rs.getInt(1);
            int[][] Content = new int[row][3];

            sql = "select product_id,amount,workshop_id " +
                    "from `plan_content` where plan_id = " + plan_id;
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            int cnt = 0;
            while(rs.next()){
                for(int i = 0; i < 3; ++i){
                    Content[cnt][i] = rs.getInt(i + 1);
                    //0->产品编号 1->产品数量 2->车间号
                }
                cnt ++;
            }
            return Content;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Plan_content[] GetPlist(Connection conn){
        try{
            String sql = "select count(*) from plan_content";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            rs.next();
            int row = rs.getInt(1);

            Plan_content[] Plist = new Plan_content[row];
            sql = "select plan_id,workshop_id,product_id,amount from plan_content";
            rs = st.executeQuery(sql);
            int cnt = 0;
            while(rs.next()){
                Plist[cnt] = new Plan_content(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4));
                cnt++;
            }
            return Plist;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int[] getids(Connection conn) {
        try{
            String sql = "select count(plan_id) from plan";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            rs.next();
            int row = rs.getInt(1);

            sql = "select plan_id from plan";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            int[] id = new int[row];
            int cnt = 0;
            while(rs.next()){
                id[cnt] = rs.getInt(1);
                cnt++;
            }
            return id;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void CancelPlan(Connection conn,int id){
        try{
            String sql = "delete from plan where plan_id = " + id;
            Statement st = conn.prepareStatement(sql);
            st.execute(sql);

            sql = "delete from plan_content where plan_id = " + id;
            st = conn.prepareStatement(sql);
            st.execute(sql);
            System.out.println("delete succeeds!");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

