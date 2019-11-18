package top.viewv.test;

import top.viewv.database.Connect;
import top.viewv.model.Tables.ProductTable;

import java.io.IOException;
import java.sql.Connection;

public class TestProductTable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Connection conn = new Connect().getConnection();
        ProductTable pt = new ProductTable();
        pt.GetLength(conn);
        pt.GetContent(conn);
        for (int i = 0; i < pt.Plength; ++i){
            System.out.println(pt.Ptable[i].product_name);
            System.out.println(pt.Ptable[i].product_price);
            System.out.println(pt.Ptable[i].product_period);
            System.out.println(pt.Ptable[i].description);
        }
    }
}
