package top.viewv.model.Tables;

import top.viewv.database.Connect;
import top.viewv.model.Ingredient;
import top.viewv.model.Recipe;
import top.viewv.model.SpecificRecipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RecipeTable {
    public SpecificRecipe[] Itable;
    public int ProductId;
    public int Rlength;

    public void GetAll(int ProductId){
        try{
            this.ProductId = ProductId;
            Connect connect = new Connect();
            Connection conn = connect.getConnection();
            String sql = "select count(ingredient_id) from ingredient";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            rs.next();
            this.Rlength = rs.getInt(1);
            this.Itable = new SpecificRecipe[this.Rlength];

            int cnt = 0;
            sql = "select recipe.ingredient_id,ingredient.ingredient_name,amount from recipe,ingredient where recipe.ingredient_id = ingredient.ingredient_id and product_id = "
            + ProductId;
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int amount = rs.getInt(3);
                this.Itable[cnt] = new SpecificRecipe(id,name,amount);
                cnt++;
            }

            conn.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
