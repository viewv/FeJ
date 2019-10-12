package top.viewv.database;

import java.sql.*;

public class Connect {

    Connection conn = null;

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://rm-wz9sa6hd1097u6rx4bo.mysql.rds.aliyuncs.com:3306/fems";
    static final String USER = "root";
    static final String PASS = "Ingram14";

    public Connection getConnection(){

        try {
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


// public class TestConnection {


//    public static void main(String[] args) {
//        Connection conn = null;
//        Statement stmt = null;
//        try{
//            // 注册 JDBC 驱动
//            Class.forName(JDBC_DRIVER);
//
//            // 打开链接
//            System.out.println("连接数据库...");
//            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//
//            // 执行查询
//            System.out.println(" 实例化Statement对象...");
//            stmt = conn.createStatement();
//            String sql;
//            sql = "SELECT account_id,password FROM account";
//            ResultSet rs = stmt.executeQuery(sql);
//
//            while(rs.next()){
//                // 通过字段检索
//                String id  = rs.getString("account_id");
//                String password = rs.getString("password");
//
//
//                // 输出数据
//                System.out.println("ID: " + id);
//                System.out.println("Password: "+ password);
//
//            }
//            // 完成后关闭
//            rs.close();
//            stmt.close();
//            conn.close();
//        } catch(Exception se){
//            // 处理 JDBC 错误
//            se.printStackTrace();
//        }// 处理 Class.forName 错误
//        finally{
//            // 关闭资源
//            try{
//                if(stmt!=null) stmt.close();
//            }catch(SQLException se2){
//            }// 什么都不做
//            try{
//                if(conn!=null) conn.close();
//            }catch(SQLException se){
//                se.printStackTrace();
//            }
//        }
//        System.out.println("Goodbye!");
//    }
//}


