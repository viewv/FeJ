package top.viewv.model.Tables;
import top.viewv.model.SpecificRecipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RecipeTable {
    public SpecificRecipe[] Itable;
    public int ProductId;
    public int Rlength;

    public RecipeTable(SpecificRecipe[] itable, int productId, int rlength) {
        Itable = itable;
        ProductId = productId;
        Rlength = rlength;
    }

    public RecipeTable(){

    }

    public void GetAll(int ProductId,Connection conn){
        try{
            this.ProductId = ProductId;
            String sql = "select count(ingredient_id) from recipe where product_id = " + ProductId;
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
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
