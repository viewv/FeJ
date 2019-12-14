package top.viewv.api;

// Hash creation
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger;

//JFX Image
import javafx.scene.image.Image;

//Net
import java.net.URL;
import java.net.MalformedURLException;

public class Gravatar {
    private static String hash(String input) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        try {
            md5.update(StandardCharsets.UTF_8.encode(input));
            return String.format("%032x", new BigInteger(1, md5.digest()));
        } catch (Exception e) {
            e.printStackTrace();
            return hash("zxnnet@gmail.com");
        }

    }
    public static Image imageFromMail(String mail) {
        try {
            Image image = new Image(String.valueOf(new URL("http://www.gravatar.com/avatar/" + hash(mail))));
            if (image == null) {
                return new Image(String.valueOf(new URL("http://www.gravatar.com/avatar/" + hash("zxnnet@gmail.com"))));
            }else {
                return image;
            }
        } catch (MalformedURLException | NoSuchAlgorithmException ex) {
            return new Image("./logo.png", true);
        }
    }
}
