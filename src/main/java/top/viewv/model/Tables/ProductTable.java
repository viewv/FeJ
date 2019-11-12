package top.viewv.model.Tables;

import top.viewv.database.Connect;
import top.viewv.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductTable {
    public Product[] Ptable;
    public int Plength;

    public void GetLength(Connection conn){
        try{
            String sql = "select count(product_id) from product";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            rs.next();
            this.Plength = rs.getInt(1);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void GetContent(Connection conn){
        try{
            this.Ptable = new Product[this.Plength];
            String sql = "select * from product";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            int cnt = 0;
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                System.out.println(name);
                int period = rs.getInt(3);
                float price = rs.getFloat(4);
                String description = rs.getString(5);
                this.Ptable[cnt] = new Product(id,name,period,price,description);
                cnt++;
            }
            //conn.close();
        }
        catch(Exception e){
            System.out.println("Product Table Wrong");
            e.printStackTrace();
        }
    }
}
