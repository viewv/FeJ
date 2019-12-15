package top.viewv.api;

import top.viewv.database.ConnectInfo;
import top.viewv.model.Plan;
import top.viewv.model.PlanInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Serialize {
    public static void ser(Object object,String filename) throws Exception {
        String path =  Objects.requireNonNull(Thread.currentThread().
                getContextClassLoader().
                getResource("data/file/"+filename)).getPath();
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(object);
        oos.flush();
        oos.close();
    }


    public static HashMap dSer(String filename) throws Exception {
        String path =  Objects.requireNonNull(Thread.currentThread().
                getContextClassLoader().
                getResource("data/file/"+filename)).getPath();
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        HashMap hashMap = (HashMap) ois.readObject();
        return hashMap;
    }

    public static ConnectInfo connder (String filename) throws IOException, ClassNotFoundException {
        String path =  Objects.requireNonNull(Thread.currentThread().
                getContextClassLoader().
                getResource("data/file/"+filename)).getPath();
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (ConnectInfo) ois.readObject();
    }

    public static ArrayList<PlanInfo> planInfodser (String filename) throws IOException, ClassNotFoundException {
        String path =  Objects.requireNonNull(Thread.currentThread().
                getContextClassLoader().
                getResource("data/file/"+filename)).getPath();
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (ArrayList<PlanInfo>) ois.readObject();
    }
}
