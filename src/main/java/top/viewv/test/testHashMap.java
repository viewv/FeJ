package top.viewv.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class testHashMap {
    public static void main(String[] args) {
        HashMap<Integer, Integer> order_lists = new HashMap<>();
        order_lists.put(1,1);
        System.out.println(order_lists.get(1));
        order_lists.clear();
        System.out.println("Clear Order List");

        for(Map.Entry<Integer, Integer> entry : order_lists.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key);
            System.out.println(value);
            System.out.println("-----");
        }
    }
}
