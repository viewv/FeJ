package top.viewv.model;

import java.io.Serializable;
import java.sql.Date;

public class Order_Info implements Serializable {
    private int order_id;
    private String client_id;
    private String staff_id;
    private java.sql.Date order_time;
    private java.sql.Date due_time;
    private float deposit;
    private float retainage;
    private int situation;

    public Order_Info() {
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public Date getDue_time() {
        return due_time;
    }

    public void setDue_time(Date due_time) {
        this.due_time = due_time;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public float getRetainage() {
        return retainage;
    }

    public void setRetainage(float retainage) {
        this.retainage = retainage;
    }

    public int getSituation() {
        return situation;
    }

    public void setSituation(int situation) {
        this.situation = situation;
    }
}
