package top.viewv.model;

public class Order_product {
    private int id;
    private int amount;
    private int order_id;
    private int due_day;

    public Order_product(int id, int amount, int order_id,int due_day) {
        this.id = id;
        this.amount = amount;
        this.order_id = order_id;
        this.due_day = due_day;
    }
}
