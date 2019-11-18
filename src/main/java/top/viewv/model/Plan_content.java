package top.viewv.model;

public class Plan_content {
    public int plan_id;
    public int workshop_id;
    public int product_id;
    public int amount;

    public  Plan_content(int pid,int wid,int prid,int amount){
        this.amount = amount;
        this.plan_id = pid;
        this.product_id = prid;
        this.workshop_id = wid;
    }
}
