package top.viewv.database;

import top.viewv.database.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {
    public String LoginFun(String user_id,String password){
        try {
            Connect connect = new Connect();
            Connection conn = connect.getConnection();
            String sql = "select checklogin(?,?)"; //sql function
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,user_id);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            String result = "";
            while (resultSet.next()){
                result = resultSet.getString(1);
            }
            conn.close();
            return  result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
