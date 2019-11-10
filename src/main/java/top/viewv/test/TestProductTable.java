package top.viewv.test;

import top.viewv.model.Tables.ProductTable;

public class TestProductTable {
    public static void main(String[] args){
        ProductTable pt = new ProductTable();
        pt.GetLength();
        pt.GetContent();
        for (int i = 0; i < pt.Plength; ++i){
            System.out.println(pt.Ptable[i].product_name);
            System.out.println(pt.Ptable[i].product_price);
        }
    }
}
