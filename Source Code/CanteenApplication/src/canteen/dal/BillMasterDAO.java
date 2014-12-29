/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.dal;

import canteen.common.bean.BillMaster;
import canteen.common.utility.DBUtility;
import java.sql.Connection;
import java.sql.Date;
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
public class BillMasterDAO extends AbstractDAO<BillMaster> {

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private String strSql;
    private BillMaster billMaster;

    @Override
    public BillMaster getById(int id) {
        conn = DBUtility.getConnection();
        strSql = "SELECT [BId],[CreateDate],[CoupenNo],[CoupenDate],[Comment],[EmployeeId],[Status] FROM [BillMaster] WHERE [BId]=? ORDER BY [BId] DESC";
        try {
            pstmt = conn.prepareStatement(strSql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                billMaster = new BillMaster();
                billMaster.setbId(rs.getInt("BId"));
                billMaster.setCreateDate(rs.getDate("CreateDate"));
                billMaster.setCoupenNo(rs.getString("CoupenNo"));
                billMaster.setCoupenDate(rs.getDate("CoupenDate"));
                billMaster.setComment(rs.getString("Comment"));
                billMaster.setEmployeeId(rs.getInt("EmployeeId"));
                billMaster.setStatus(rs.getBoolean("Status"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            DBUtility.closeAll(conn, pstmt, rs);
        }

        return billMaster;
    }

    @Override
    public List<BillMaster> getAll() {
        List<BillMaster> lstBillMasters = new ArrayList<>();
        conn = DBUtility.getConnection();
        strSql = "SELECT [BId],[CreateDate],[CoupenNo],[CoupenDate],[Comment],[EmployeeId],[Status] FROM [BillMaster] ORDER BY [BId] DESC";
        try {
            pstmt = conn.prepareStatement(strSql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                billMaster = new BillMaster();
                billMaster.setbId(rs.getInt("BId"));
                billMaster.setCreateDate(rs.getDate("CreateDate"));
                billMaster.setCoupenNo(rs.getString("CoupenNo"));
                billMaster.setCoupenDate(rs.getDate("CoupenDate"));
                billMaster.setComment(rs.getString("Comment"));
                billMaster.setEmployeeId(rs.getInt("EmployeeId"));
                billMaster.setStatus(rs.getBoolean("Status"));

                lstBillMasters.add(billMaster);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            DBUtility.closeAll(conn, pstmt, rs);
        }

        return lstBillMasters;
    }

    public List<BillMaster> getAllByEmpId(int empId) {
        List<BillMaster> lstBillMasters = new ArrayList<>();
        conn = DBUtility.getConnection();
        strSql = "SELECT [BId],[CreateDate],[CoupenNo],[CoupenDate],[Comment],[EmployeeId],[Status] FROM [BillMaster] WHERE [EmployeeId]=? ORDER BY [BId] DESC";
        try {
            pstmt = conn.prepareStatement(strSql);
            pstmt.setInt(1, empId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                billMaster = new BillMaster();
                billMaster.setbId(rs.getInt("BId"));
                billMaster.setCreateDate(rs.getDate("CreateDate"));
                billMaster.setCoupenNo(rs.getString("CoupenNo"));
                billMaster.setCoupenDate(rs.getDate("CoupenDate"));
                billMaster.setComment(rs.getString("Comment"));
                billMaster.setEmployeeId(rs.getInt("EmployeeId"));
                billMaster.setStatus(rs.getBoolean("Status"));

                lstBillMasters.add(billMaster);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            DBUtility.closeAll(conn, pstmt, rs);
        }

        return lstBillMasters;
    }

    @Override
    public boolean create(BillMaster obj) {
        conn = DBUtility.getConnection();
        strSql = "INSERT INTO [BillMaster] ([CreateDate] ,[CoupenNo] ,[CoupenDate] ,[Comment] ,[EmployeeId] ,[Status]) VALUES (?,?,?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(strSql);
            pstmt.setDate(1, new Date(obj.getCreateDate().getTime()));
            pstmt.setString(2, obj.getCoupenNo());
            pstmt.setDate(3, new Date(obj.getCoupenDate().getTime()));
            pstmt.setString(4, obj.getComment());
            pstmt.setInt(5, obj.getEmployeeId());
            pstmt.setBoolean(6, obj.isStatus());
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
    public boolean update(BillMaster obj) {
        return false;
    }

    public boolean updateStatus(BillMaster obj) {
        conn = DBUtility.getConnection();
        strSql = "UPDATE [BillMaster] SET [Status]=? WHERE [BId]=?";
        try {
            pstmt = conn.prepareStatement(strSql);
            pstmt.setBoolean(1, obj.isStatus());
            pstmt.setInt(2, obj.getbId());
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

    public boolean updateComment(BillMaster obj) {
        conn = DBUtility.getConnection();
        strSql = "UPDATE [BillMaster] SET [Comment]=? WHERE [BId]=?";
        try {
            pstmt = conn.prepareStatement(strSql);
            pstmt.setString(1, obj.getComment());
            pstmt.setInt(2, obj.getbId());
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
    public boolean delete(BillMaster obj) {
        conn = DBUtility.getConnection();
        strSql = "DELETE FROM [BillMaster] WHERE [BId]=?";
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
}
