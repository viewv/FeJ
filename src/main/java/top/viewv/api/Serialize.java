package top.viewv.api;

import top.viewv.model.Order_Info;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Serialize {
    public static void ser(Object object,String filename) throws Exception {
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(object);
        oos.flush();
        oos.close();
    }


    public static HashMap dSer(String filename) throws Exception {
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        HashMap hashMap = (HashMap) ois.readObject();
        return hashMap;
    }

//    public static Order_Info oInfodSer(String filename) throws Exception{
//        FileInputStream fis = new FileInputStream(filename);
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        Order_Info order_info = (Order_Info) ois.readObject();
//        return order_info;
//    }
}
