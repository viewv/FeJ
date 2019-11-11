package top.viewv.model;

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
}
