package canteen.common.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @Roll Number: Student756725
 * @author: Nguyen Duy Khanh
 * @version: 1.0.0
 */
public class EncriptionText {

    public static String getMD5(String text) {
        try {
            String md5;
            byte[] data = text.trim().getBytes();
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(data);
            byte[] md5Byte = digest.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < md5Byte.length; i++) {
                sb.append(String.format("%02x", md5Byte[i]));
            }
            md5 = sb.toString().toLowerCase();
            return md5;
        } catch (NoSuchAlgorithmException ex) {
            return "";
        }
    }

    public static String getSHA1(String text) {
        try {
            String sha1;
            byte[] data = text.trim().getBytes();
            MessageDigest digest = MessageDigest.getInstance("SHA1");
            digest.update(data);
            byte[] sha1Byte = digest.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < sha1Byte.length; i++) {
                sb.append(String.format("%02x", sha1Byte[i]));
            }
            sha1 = sb.toString().toLowerCase();
            return sha1;
        } catch (NoSuchAlgorithmException ex) {
            return "";
        }
    }

    private static Cipher cipher = null;
    private static SecretKey key = null;
    private static KeyGenerator keyGenerator = null;

    public static String getBase64Encode(String text) {
        try {
            keyGenerator = KeyGenerator.getInstance("DES");

            key = keyGenerator.generateKey();

            cipher = Cipher.getInstance("DES");

            // bat dau ma hoa
            byte[] data = text.getBytes();
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] doFinal = cipher.doFinal(data);

            BASE64Encoder encode = new BASE64Encoder();
            String encode1 = encode.encode(doFinal);

            return encode1;
        } catch (Exception e) {
            return "";
        }
    }

    public static String getBase64Decode(String text) {
        try {
            keyGenerator = KeyGenerator.getInstance("DES");

            key = keyGenerator.generateKey();

            cipher = Cipher.getInstance("DES");

            // bat dau giai ma
            cipher.init(Cipher.DECRYPT_MODE, key);

            BASE64Decoder decode = new BASE64Decoder();
            byte[] buffer = decode.decodeBuffer(text);

            byte[] doFinal = cipher.doFinal(buffer);

            String decoder = new String(doFinal);
            return decoder;
        } catch (Exception e) {
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(getMD5("123456"));
        System.out.println(getSHA1("123456"));
        System.out.println(getBase64Encode("123456"));
        System.out.println(getBase64Decode(getBase64Encode("123456")));
    }
}
