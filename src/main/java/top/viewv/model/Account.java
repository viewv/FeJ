package top.viewv.model;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class Account {
    public boolean login(String account_id,String passsword){
        String sha_password = Hashing.sha256().hashString(passsword, StandardCharsets.UTF_8).toString();
        // TODO search
        boolean token = true;
        return token;
    }
    public boolean register(String account_name,String password){
        String sha_password = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        Date data = new Date();
        String avitor = ""; // from input
        //TODO storge
        boolean token = true;
        return token;
    }
}
