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

    private static Connection conn = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    /**
     *
     * @return Connection
     */
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
            Logger.getLogger(DBUtility.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DBUtility.class.getName()).log(Level.SEVERE, null, ex);
        }

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
     * @param numPara
     * @return ResultSet
     */
    public static ResultSet getData(String strSql, Object[] value, int numPara) {
        conn = getConnection();
        try {
            pstmt = conn.prepareStatement(strSql);
            for (int i = 0; i < numPara; i++) {
                pstmt.setObject(i, value[i]);
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
     * @param numPara
     * @return result
     */
    public static int setData(String strSql, Object[] value, int numPara) {
        int result = 0;
        conn = getConnection();
        try {
            pstmt = conn.prepareStatement(strSql);
            for (int i = 0; i < numPara; i++) {
                pstmt.setObject(i, value[i]);
            }
            result = pstmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            closeAll(conn, pstmt, rs);
        }

        return result;
    }

    //public static void main(String[] args) {
    //    System.out.println(getConnection());
    //}
}
