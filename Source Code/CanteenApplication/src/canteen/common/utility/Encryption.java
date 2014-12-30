package canteen.common.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @Roll Number: Student756725
 * @author: Nguyen Duy Khanh
 * @version: 1.0.0
 */
public class Encryption {

    /**
     *
     * @param text
     * @return String
     */
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
            return null;
        }
    }

    /**
     *
     * @param text
     * @return String
     */
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
            return null;
        }
    }

    /**
     *
     * @param text
     * @return String
     */
    public static String getBase64Encode(String text) {
        try {
            cipher = Cipher.getInstance("DES");

            // Encode
            byte[] data = text.getBytes();
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey());

            byte[] encyptData = cipher.doFinal(data);
            BASE64Encoder encode = new BASE64Encoder();
            return encode.encode(encyptData);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            return null;
        }
    }

    /**
     *
     * @param text
     * @return String
     */
    public static String getBase64Decode(String text) {
        try {
            cipher = Cipher.getInstance("DES");

            // Decode
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey());

            BASE64Decoder decode = new BASE64Decoder();
            byte[] decoderBuffer = decode.decodeBuffer(text);

            byte[] decryptData = cipher.doFinal(decoderBuffer);
            String strDecypt = new String(decryptData);
            return strDecypt;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IOException | IllegalBlockSizeException | BadPaddingException ex) {
            return null;
        }
    }

    private static Cipher cipher = null;
    private static final String KEY_PATH = "common/key.dat";

    /**
     *
     * @return SecretKey
     */
    public static SecretKey getSecretKey() {
        SecretKey secretKey = null;
        File file = new File(KEY_PATH);
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        if (!file.exists()) {
            secretKey = createSecretKey();
        } else {
            try {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);

                secretKey = (SecretKey) ois.readObject();
                if (secretKey == null) {
                    secretKey = createSecretKey();
                }
            } catch (IOException | ClassNotFoundException ex) {
            } finally {
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException ex) {
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException ex) {
                    }
                }
            }
        }

        return secretKey;
    }

    /**
     *
     * @return SecretKey
     */
    public static SecretKey createSecretKey() {
        KeyGenerator keyGenerator;
        SecretKey secretKey = null;

        try {
            keyGenerator = KeyGenerator.getInstance("DES");
            secretKey = keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException ex) {
        }

        File file = new File(KEY_PATH);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(secretKey);
            oos.flush();
        } catch (IOException ex) {
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                }
            }
        }

        return secretKey;
    }

    public static void main(String[] args) {
        System.out.println(getMD5("123456"));
        System.out.println(getSHA1("123456"));

        String code = getBase64Encode("123456");
        System.out.println(code);
        System.out.println(getBase64Decode(code));
    }
}
