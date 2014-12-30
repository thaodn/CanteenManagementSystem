/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.common.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Admin
 */
public class ConfigUtility {

    private static final String CONFIG_PATH = "common/config.properties";
    private static Properties config;

    /**
     *
     * @return
     */
    public static ConfigProperties getConfig() {
        ConfigProperties properties = new ConfigProperties();
        config = new Properties();

        File file = new File(CONFIG_PATH);
        FileInputStream fis = null;

        if (!file.exists()) {
            properties = new ConfigProperties("localhost", "1705", "sa", "1234567", "Canteen");
            System.out.println(createConfig(properties));
        } else {
            try {
                fis = new FileInputStream(file);
                config.load(fis);

                properties.setHost(config.getProperty("Host"));
                properties.setPort(config.getProperty("Port"));
                properties.setUser(Encryption.getBase64Decode(config.getProperty("User")));
                properties.setPassword(Encryption.getBase64Decode(config.getProperty("Password")));
                properties.setDatabase(config.getProperty("Database"));
            } catch (IOException ex) {
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException ex) {
                    }
                }
            }
        }
        return properties;
    }

    /**
     *
     * @param properties
     * @return
     */
    public static boolean createConfig(ConfigProperties properties) {
        config = new Properties();
        File file = new File(CONFIG_PATH);
        FileOutputStream fos = null;

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            config.setProperty("Host", properties.getHost());
            config.setProperty("Port", properties.getPort());
            config.setProperty("User", Encryption.getBase64Encode(properties.getUser()));
            config.setProperty("Password", Encryption.getBase64Encode(properties.getPassword()));
            config.setProperty("Database", properties.getDatabase());
            config.store(fos, null);
            return true;
        } catch (IOException ex) {
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                }
            }
        }

        return false;
    }
}
