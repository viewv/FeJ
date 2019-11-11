package top.viewv.model;

public class SpecificRecipe {
    public int IngredientId;
    public String IngredientName;
    public  int Amount;

    public SpecificRecipe(int Id,String Name,int Amount){
        this.IngredientId = Id;
        this.Amount = Amount;
        this.IngredientName = Name;
    }
}
