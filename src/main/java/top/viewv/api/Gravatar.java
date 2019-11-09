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
    private static String hash(String input) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(StandardCharsets.UTF_8.encode(input));
            return String.format("%032x", new BigInteger(1, md5.digest()));
        } catch (NoSuchAlgorithmException ex) {
            return null;
        }
    }
    public static Image imageFromMail(String mail) {
        try {
            return new Image(String.valueOf(new URL("http://www.gravatar.com/avatar/" + hash(mail))));
        } catch (MalformedURLException ex) {
            return null;
        }
    }
}
