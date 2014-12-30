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
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class DBUtility {

    public DBUtility() {
        conn = getConnection();
    }

    private static Connection conn = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    /**
     *
     * @return Connection
     */
    public static Connection getConnection() {
        // Read config from Config.properties
        Properties p = new Properties();
        String url = "";
        String port = "";
        String user = "";
        String password = "";
        String dbName = "";
        try {
            p.load(new FileInputStream("Config.properties"));

            url = p.getProperty("url");
            port = p.getProperty("port");
            user = p.getProperty("user");
            password = p.getProperty("password");
            dbName = p.getProperty("dbName");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBUtility.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DBUtility.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Get Connection
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://" + url + ":" + port + ";databaseName=" + dbName, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBUtility.class.getName()).log(Level.SEVERE, null, ex);
        }

        return connection;
    }

    /**
     *
     * @param connection
     * @param pstmt
     * @param rs
     */
    public static void closeAll(Connection connection, PreparedStatement pstmt, ResultSet rs) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param strSql
     * @return ResultSet
     */
    public static ResultSet getData(String strSql) {
        conn = getConnection();
        try {
            pstmt = conn.prepareStatement(strSql);
            rs = pstmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            closeAll(conn, pstmt, rs);
        }
        return rs;
    }

    /**
     *
     * @param strSql
     * @param value
     * @return ResultSet
     */
    public static ResultSet getData(String strSql, Object[] value) {
        conn = getConnection();
        try {
            pstmt = conn.prepareStatement(strSql);
            for (int i = 0; i < value.length; i++) {
                pstmt.setObject(i + 1, value[i]);
            }
            rs = pstmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            closeAll(conn, pstmt, rs);
        }
        return rs;
    }

    /**
     *
     * @param strSql
     * @param value
     * @return result
     */
    public static int setData(String strSql, Object[] value) {
        int result = 0;
        conn = getConnection();
        try {
            pstmt = conn.prepareStatement(strSql);
            for (int i = 0; i < value.length; i++) {
                pstmt.setObject(i + 1, value[i]);
            }
            result = pstmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            closeAll(conn, pstmt, rs);
        }

        return result;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
