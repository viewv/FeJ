package top.viewv.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Signup {
    public String SignupFun(String account_id,String user_id,String password,String rep_password,String avatar,Connection conn){
        try {
            String sql = "select checkregister(?,?,?,?,?)"; //sql function
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,account_id);
            preparedStatement.setString(2,user_id);
            preparedStatement.setString(3,password);
            preparedStatement.setString(4,rep_password);
            preparedStatement.setString(5,avatar);

            ResultSet resultSet = preparedStatement.executeQuery();

            String result = null;
            while (resultSet.next()){
                result = resultSet.getString(1);
            }
            conn.close();
            /*
            Account Exists
            Wrong Account Length
            Wrong Password Length
            Password Don't Match
            ----------------------
            Staff Account Created Successfully
            Client Account Created Successfully
             */
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
