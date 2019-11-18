package top.viewv.model;

import java.io.Serializable;

public class plan_info implements Serializable {
    private int product_id;
    private int amount;
    private int line_id;


    public plan_info(int product_id, int amount, int line_id) {
        this.product_id = product_id;
        this.amount = amount;
        this.line_id = line_id;
    }


    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getLine_id() {
        return line_id;
    }

    public void setLine_id(int line_id) {
        this.line_id = line_id;
    }
}
