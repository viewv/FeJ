package top.viewv.model;

public class SpecificRecipe {
    public int IngredientId;
    public String IngredientName;
    public  int Amount;
    public String Description;

    public SpecificRecipe(int Id,String Name,int Amount,String Description){
        this.IngredientId = Id;
        this.Amount = Amount;
        this.IngredientName = Name;
        this.Description = Description;
    }
}
