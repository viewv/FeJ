package top.viewv.model;

import top.viewv.model.Tables.RecipeTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Product {
    public int product_id;
    public String product_name;
    public int product_period;
    public float product_price;
    public String description;

    public Product(int id,String name,int period,float price,String description){
        this.product_id = id;
        this.product_name = name;
        this.product_period = period;
        this.product_price = price;
        this.description = description;
    }

    public Product(){

    }

    public void GetProduct(Connection conn,int id){
        try{
            String sql = "select * from product where product_id = " +
                    id;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            rs.next();
            this.product_id = id;
            this.product_name = rs.getString(2);
            this.product_period = rs.getInt(3);
            this.product_price = rs.getFloat(4);
            this.description = rs.getString(5);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public int UpdatePrice(Connection conn,int id,float newprice){
        try{
            String sql = "select UpdatePrice(" +
                    id + "," + newprice + ")";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            rs.next();
            return rs.getInt(1);
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0; //异常
    }
    //1.illegal price 2.商品不存在 3.成功


    public static Product[] SearchByName(String name,Connection conn){
        try{
            String sql = "select count(*) from product where product_name like \"%"
                    + name +"%\"";
            int cnt = 0;
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            cnt = rs.getInt(1);

            if (cnt == 0){
                Product[] X = new Product[1];
                X[0] = new Product(1,"不存在",0,0,"未找到该商品");
                return X;
            }
            else{
                Product[] X = new Product[cnt];
                cnt = 0;
                sql = "select * from product where product_name like \"%"
                        + name +"%\"";
                st = conn.prepareStatement(sql);
                rs = st.executeQuery(sql);
                while(rs.next()){
                    X[cnt] = new Product(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getFloat(4),
                            rs.getString(5));
                    cnt++;
                }
                return X;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int AddProduct(RecipeTable x,Product y,Connection conn){
        try{
            String sql = "select count(product_id) from product";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            int id = rs.getInt(1);
            if (id == 0){
                id = 1;
            }
            else{
                sql = "select product_id+1 from product order by product_id desc limit 1";
                st = conn.prepareStatement(sql);
                rs = st.executeQuery(sql);
                rs.next();
                id = rs.getInt(1);
            }
            sql = "insert into product values(" + id + ",\"" +
            y.product_name + "\"," + y.product_period + ","
            + y.product_price + ",\"" + y.description + "\")";
            st = conn.prepareStatement(sql);
            st.execute(sql);

            y.product_id = id;
            x.ProductId = id;

            sql = "select count(id) from recipe";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery(sql);
            rs.next();
            id = rs.getInt(1);
            if (id == 0){
                id = 1;
            }
            else{
                sql = "select id+1 from recipe order by id desc limit 1";
                st = conn.prepareStatement(sql);
                rs = st.executeQuery(sql);
                rs.next();
                id = rs.getInt(1);
            }

            System.out.println(x.Rlength);
            for (int i = 0; i < x.Rlength; ++i){

                String a = x.Itable[i].IngredientName;
                int b = x.Itable[i].IngredientId;
                int c = x.Itable[i].Amount;
                System.out.println(a+'-'+b+'-'+c);
                sql = "insert into recipe values(" + id +
                        "," + y.product_id + "," + b + "," + c + ")";
                st = conn.prepareStatement(sql);
                st.execute(sql);
                id++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
