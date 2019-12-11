package top.viewv.model;

import java.io.Serializable;

public class Receipe_Info implements Serializable {

    public int IngredientId;
    public String IngredientName;
    public  int Amount;

    public Receipe_Info(){

    }

    public Receipe_Info(int ingredientId, String ingredientName, int amount) {
        IngredientId = ingredientId;
        IngredientName = ingredientName;
        Amount = amount;
    }

    public int getIngredientId() {
        return IngredientId;
    }

    public void setIngredientId(int ingredientId) {
        IngredientId = ingredientId;
    }

    public String getIngredientName() {
        return IngredientName;
    }

    public void setIngredientName(String ingredientName) {
        IngredientName = ingredientName;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }
}
