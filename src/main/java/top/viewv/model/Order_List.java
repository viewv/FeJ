package top.viewv.model;

import java.io.Serializable;

public class Order_List implements Serializable {
    private int amount;
    private int due_day;

    public Order_List(int amount, int due_day) {
        this.amount = amount;
        this.due_day = due_day;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDue_day() {
        return due_day;
    }

    public void setDue_day(int due_day) {
        this.due_day = due_day;
    }
    @Override
    public String toString() {
        return "Order{" +
                ", amount=" + amount +
                ", due_day=" + due_day +
                '}';
    }
}
