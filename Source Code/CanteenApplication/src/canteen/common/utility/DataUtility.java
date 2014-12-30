/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.common.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class DataUtility {

    private static ConfigProperties properties;
    private static Connection conn = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    /**
     *
     * @return Connection
     */
    public static Connection getConnection() {
        properties = ConfigUtility.getConfig();
        Connection connection = null;
        String url = "jdbc:sqlserver://" + properties.getHost() + ":" + properties.getPort() + ";databaseName=" + properties.getDatabase();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, properties.getUser(), properties.getPassword());
        } catch (ClassNotFoundException | SQLException ex) {
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
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException ex) {
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
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

    //public static void main(String[] args) {
    //    System.out.println(getConnection());
    //}
}
