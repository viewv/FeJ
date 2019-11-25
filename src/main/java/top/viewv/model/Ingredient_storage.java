package top.viewv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ingredient_storage {
    public int id;
    public String date;
    public int ingredient_id;
    public int amount;
    public String staff_id;

    public int EnStorage(Connection conn,int ingredient_id,int amount,String staff_id){
        try{
            String sql = "select EnIngredientStorage(?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,ingredient_id);
            st.setInt(2,amount);
            st.setString(3,"\""+staff_id+"\"");
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
            String sql = "select OutIngredientStorage(?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(2,ingredient_id);
            st.setInt(3,amount);
            st.setString(1,"\""+staff_id+"\"");
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

    public int[] CheckDestroy(Connection conn){
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
            st.executeQuery(sql);
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

    public void DestroyItem(Connection conn,int id){
        try{
            String sql = "delete from ingredient_storage where id = " + id;
            PreparedStatement st = conn.prepareStatement(sql);
            st.execute(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

