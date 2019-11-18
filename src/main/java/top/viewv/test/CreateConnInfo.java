package top.viewv.test;

import top.viewv.api.Serialize;
import top.viewv.database.ConnectInfo;

public class CreateConnInfo {

    public static void main(String[] args) throws Exception {
        ConnectInfo connectInfo = new ConnectInfo(
                "com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://rm-wz9sa6hd1097u6rx4bo.mysql.rds.aliyuncs.com:3306/fems",
                "root","Ingram14");
        Serialize.ser(connectInfo,"conn.ser");
    }
}
