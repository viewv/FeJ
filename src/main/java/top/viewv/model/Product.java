package top.viewv.model;

public class Product {
    public int product_id;
    public String product_name;
    public int product_period;
    public float product_price;

    public Product(int id,String name,int period,float price){
        this.product_id = id;
        this.product_name = name;
        this.product_period = period;
        this.product_price = price;
    }
}
