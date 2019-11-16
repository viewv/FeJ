package top.viewv.model;

public class Order_Product {
    public int id;
    public String name;
    public int amount;
    public float price;

    public Order_Product(int id, String name, int amount, float price) {
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.price = price;
    }
}
