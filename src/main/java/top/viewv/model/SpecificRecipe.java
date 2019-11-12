package top.viewv.model;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

public class SpecificRecipe extends RecursiveTreeObject<SpecificRecipe> {
    public int IngredientId;
    public String IngredientName;
    public  int Amount;

    public SpecificRecipe(int Id,String Name,int Amount){
        this.IngredientId = Id;
        this.Amount = Amount;
        this.IngredientName = Name;
    }
}
