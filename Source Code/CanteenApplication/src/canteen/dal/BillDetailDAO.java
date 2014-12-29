/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.dal;

import canteen.common.bean.BillDetail;
import canteen.common.utility.DBUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class BillDetailDAO extends AbstractDAO<BillDetail> {

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private String strSql;
    private BillDetail billDetail;

    @Override
    public BillDetail getById(int id) {
        conn = DBUtility.getConnection();
        strSql = "SELECT [BId],[ItemId],[Quantity],[Rate] FROM [BillDetail] WHERE [BId]=? ORDER BY [BId] DESC";
        try {
            pstmt = conn.prepareStatement(strSql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                billDetail = new BillDetail();
                billDetail.setbId(rs.getInt("BId"));
                billDetail.setItemId(rs.getInt("ItemId"));
                billDetail.setQuantity(rs.getInt("Quantity"));
                billDetail.setRate(rs.getFloat("Rate"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            DBUtility.closeAll(conn, pstmt, rs);
        }

        return billDetail;
    }

    @Override
    public List<BillDetail> getAll() {
        List<BillDetail> lstBillDetails = new ArrayList<>();
        conn = DBUtility.getConnection();
        strSql = "SELECT [BId],[ItemId],[Quantity],[Rate] FROM [BillDetail] ORDER BY [BId] DESC";
        try {
            pstmt = conn.prepareStatement(strSql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                billDetail = new BillDetail();
                billDetail.setbId(rs.getInt("BId"));
                billDetail.setItemId(rs.getInt("ItemId"));
                billDetail.setQuantity(rs.getInt("Quantity"));
                billDetail.setRate(rs.getFloat("Rate"));

                lstBillDetails.add(billDetail);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            DBUtility.closeAll(conn, pstmt, rs);
        }

        return lstBillDetails;
    }

    @Override
    public boolean create(BillDetail obj) {
        conn = DBUtility.getConnection();
        strSql = "INSERT INTO [BillDetail] ([BId],[ItemId],[Quantity],[Rate]) VALUES (?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(strSql);
            pstmt.setInt(1, obj.getbId());
            pstmt.setInt(2, obj.getItemId());
            pstmt.setInt(3, obj.getQuantity());
            pstmt.setFloat(4, obj.getRate());
            if (pstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            DBUtility.closeAll(conn, pstmt, rs);
        }

        return false;
    }

    @Override
    public boolean update(BillDetail obj) {
        return false;
    }

    @Override
    public boolean delete(BillDetail obj) {
        conn = DBUtility.getConnection();
        strSql = "DELETE FROM [BillDetail] WHERE [BId]=?";
        try {
            pstmt = conn.prepareStatement(strSql);
            pstmt.setInt(1, obj.getbId());
            if (pstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            DBUtility.closeAll(conn, pstmt, rs);
        }

        return false;
    }

    public float totalPriceByBId(BillDetail obj) {
        conn = DBUtility.getConnection();
        strSql = "SELECT SUM([Quantity]*[Rate]) AS [TotalPrice] FROM [BillDetail] WHERE [BId]=?";
        try {
            pstmt = conn.prepareStatement(strSql);
            pstmt.setInt(1, obj.getbId());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getFloat("TotalPrice");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            DBUtility.closeAll(conn, pstmt, rs);
        }

        return 0;
    }
}
