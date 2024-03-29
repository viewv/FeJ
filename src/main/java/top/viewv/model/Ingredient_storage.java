package top.viewv.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ingredient_storage {
    public int id;
    public Date date;
    public int ingredient_id;
    public int amount;
    public String staff_id;

    public Ingredient_storage(int a,Date b,int c,int d,String e){
        this.id = a;
        this.date = b;
        this.ingredient_id = c;
        this.amount = d;
        this.staff_id = e;
    }

    public Ingredient_storage(){

    }

    public Ingredient_storage[] GetAll(Connection conn){
        try{
            int cnt;
            String sql = "select count(*) from ingredient_storage";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            cnt = rs.getInt(1);
            Ingredient_storage[] X = new Ingredient_storage[cnt];
            sql = "select * from ingredient_storage";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            cnt = 0;
            while(rs.next()){
                X[cnt] = new Ingredient_storage(rs.getInt(1),rs.getDate(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
                cnt++;
            }
            return X;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int EnStorage(Connection conn,int ingredient_id,int amount,String staff_id){
        try{
            String sql = "select EnIngredientStorage("+ingredient_id+","+amount+","+"\""+staff_id+"\""+")";
            PreparedStatement st = conn.prepareStatement(sql);
//            st.setInt(1,ingredient_id);
//            st.setInt(2,amount);
//            st.setString(3,"\""+staff_id+"\"");
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            return rs.getInt(1);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    //0.null 1.ingredient doesn't exist 2.amount error 3.staff doesn't exist 4.success

    public int OutStorage(Connection conn,int ingredient_id,int amount,String staff_id){
        try{
            String sql = "select OutIngredientStorage("+"\""+staff_id+ "\""+"," +ingredient_id+","+amount+ ")";
            System.out.println(sql);
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
    //0.null 1.ingredient doesn't exist 2.amount error 3.staff doesn't exist 4.success

    public static int[] CheckDestroy(Connection conn){
        try{
            String sql = "select count(ingredient_storage.id) from ingredient_storage,ingredient where " +
                    "ingredient_storage.ingredient_id = ingredient.ingredient_id and" +
                    " (ingredient_period-TIMESTAMPDIFF(DAY,date,CURRENT_DATE)) < 0";
            PreparedStatement st = conn.prepareStatement(sql);
            st.executeQuery(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            int row = rs.getInt(1);
            int[] temp = new int[row];
            int cnt = 0;

            sql = "select ingredient_storage.id from ingredient_storage,ingredient where " +
                    "ingredient_storage.ingredient_id = ingredient.ingredient_id and" +
                    " (ingredient_period-TIMESTAMPDIFF(DAY,date,CURRENT_DATE)) < 0";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            while(rs.next()){
                temp[cnt] = rs.getInt(1);
                cnt++;
            }
            return temp;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void DestroyItem(Connection conn,int id){
        try{
            String sql = "delete from ingredient_storage where id = " + id;
            PreparedStatement st = conn.prepareStatement(sql);
            st.execute(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static String[] GetName(Connection conn,int cnt){
        try{
            String[] X = new String[cnt];
            String sql = "select ingredient_name from `full ingredient_storage`";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);

            int a = 0;
            while(rs.next()){
                X[a] = rs.getString(1);
                a++;
            }
            return X;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Ingredient_storage[] GetOut(Connection conn){
        try{
            int cnt;
            String sql = "select count(*) from out_ingredient";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            cnt = rs.getInt(1);
            Ingredient_storage[] X = new Ingredient_storage[cnt];
            sql = "select * from out_ingredient";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            cnt = 0;
            while(rs.next()){
                X[cnt] = new Ingredient_storage(rs.getInt(1),rs.getDate(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
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

