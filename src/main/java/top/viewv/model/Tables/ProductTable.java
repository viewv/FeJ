package top.viewv.model.Tables;

import top.viewv.database.Connect;
import top.viewv.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductTable {
    public Product[] Ptable;
    public int Plength;

    public void GetLength(){
        try{
            Connect connect = new Connect();
            Connection conn = connect.getConnection();
            String sql = "select count(product_id) from product";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            rs.next();
            this.Plength = rs.getInt(1);
            conn.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void GetContent(){
        try{
            this.Ptable = new Product[this.Plength];
            Connect connect = new Connect();
            Connection conn = connect.getConnection();
            String sql = "select * from product";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            int cnt = 0;
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int period = rs.getInt(3);
                float price = rs.getFloat(4);
                this.Ptable[cnt] = new Product(id,name,period,price);
                cnt++;
            }
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
