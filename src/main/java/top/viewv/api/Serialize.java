package top.viewv.api;

import top.viewv.database.ConnectInfo;

import java.io.*;
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

    public static ConnectInfo connder (String filename) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (ConnectInfo) ois.readObject();
    }
}
