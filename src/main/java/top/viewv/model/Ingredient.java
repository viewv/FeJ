package top.viewv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ingredient {
    public int ingredient_id;
    public String ingredient_name;
    public int ingredient_period;
    public float ingredient_cost;

    public Ingredient(int id,String name,int period,float cost){
        this.ingredient_id = id;
        this.ingredient_name = name;
        this.ingredient_period =period;
        this.ingredient_cost = cost;
    }

    public Ingredient[] GetAll(Connection conn){
        try{
            String sql = "select count(*) from ingredient";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            int cnt = rs.getInt(1);

            Ingredient[] X = new Ingredient[cnt];
            cnt = 0;
            sql = "select * from ingredient";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            while(rs.next()){
                X[cnt] = new Ingredient(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getFloat(4)
                );
                cnt++;
            }
            return X;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int AddIngredient(Connection conn,String name,int period,float price){
        try {
            String sql = "select AddIngredient(\"" +
                    name + "\"," + period + "," + price + ")";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    //1.price error 2.period error 3.success

    public int DeleteIngredient(Connection conn,int id){
        try{

        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    //1.not exist 2.success
}
