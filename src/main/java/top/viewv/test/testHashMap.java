package top.viewv.test;

import java.util.ArrayList;
import java.util.HashMap;

public class testHashMap {
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> order_lists = new HashMap<>();
        ArrayList<Integer> order = new ArrayList<>();
        order.add(1);
        order.add(2);
        order_lists.put(1,order);
        System.out.println(order_lists.get(1));
        ArrayList<Integer> arr;
        arr = order_lists.get(1);
        arr.set(0,3);
        order_lists.put(1,arr);
        System.out.println(order_lists.get(1));
    }
}
