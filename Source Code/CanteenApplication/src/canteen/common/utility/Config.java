/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.common.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Admin
 */
public class Config {

    public Config() {
    }

    public Config(Properties config, String host, String port, String user, String password, String database) {
        this.config = config;
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
        this.database = database;
    }

    private static final String CONFIG_PATH = "common/config.properties";
    private Properties config;
    private String host;
    private String port;
    private String user;
    private String password;
    private String database;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public Properties getConfig() {
        config = new Properties();
        File file = new File(CONFIG_PATH);
        FileInputStream fis = null;
        if (!file.exists()) {
            config = createConfig();

        } else {
            try {
                fis = new FileInputStream(file);
                config.load(fis);
            } catch (IOException ex) {
            }
        }
        return config;
    }

    public Properties createConfig() {
        config = new Properties();

        return config;
    }
}
