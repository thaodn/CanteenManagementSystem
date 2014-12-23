package canteen.common.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ndkhanh
 */
public class DBUltility {

    public static Connection getConnection() {
        Connection connection = null;

        String url = "";
        String port = "";
        String user = "";
        String password = "";
        String dbName = "";

        // Doc File Propertyes
        Properties p = new Properties();

        try {
            p.load(new FileInputStream("Config.properties"));

            url = p.getProperty("url");
            port = p.getProperty("port");
            user = p.getProperty("user");
            password = p.getProperty("password");
            dbName = p.getProperty("dbName");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBUltility.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DBUltility.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://" + url + ":" + port + ";databaseName=" + dbName, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBUltility.class.getName()).log(Level.SEVERE, null, ex);
        }

        return connection;
    }

    public static void closeAll(Connection connection, PreparedStatement pstmt, ResultSet rs) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBUltility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBUltility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBUltility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

//    public static void main(String[] args) {
//        System.out.println(getConnection());
//    }
}
