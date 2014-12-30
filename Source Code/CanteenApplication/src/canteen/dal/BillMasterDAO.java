/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.dal;

import canteen.common.bean.BillMaster;
import canteen.common.utility.DataUtility;
import java.sql.Date;
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

    private ResultSet rs = null;
    private String strSql;
    private BillMaster billMaster;

    /**
     *
     * @param id
     * @return BillMaster
     */
    @Override
    public BillMaster getById(int id) {
        strSql = "{call sp_Bill_GetById (?)}";
        Object[] value = {id};
        billMaster = new BillMaster();

        rs = DataUtility.getData(strSql, value);
        try {
            while (rs.next()) {
                billMaster.setBillId(rs.getInt("BillId"));
                billMaster.setCreateDate(rs.getDate("CreateDate"));
                billMaster.setCoupenNo(rs.getString("CoupenNo"));
                billMaster.setCoupenDate(rs.getDate("CoupenDate"));
                billMaster.setComment(rs.getString("Comment"));
                billMaster.setEmployeeId(rs.getInt("EmployeeId"));
                billMaster.setStatus(rs.getInt("Status"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return billMaster;
    }

    /**
     *
     * @return List BillMaster
     */
    @Override
    public List<BillMaster> getAll() {
        strSql = "{call sp_Bill_GetByAll}";
        List<BillMaster> lstBillMasters = new ArrayList<>();

        rs = DataUtility.getData(strSql);
        try {
            while (rs.next()) {
                billMaster = new BillMaster();
                billMaster.setBillId(rs.getInt("BillId"));
                billMaster.setCreateDate(rs.getDate("CreateDate"));
                billMaster.setCoupenNo(rs.getString("CoupenNo"));
                billMaster.setCoupenDate(rs.getDate("CoupenDate"));
                billMaster.setComment(rs.getString("Comment"));
                billMaster.setEmployeeId(rs.getInt("EmployeeId"));
                billMaster.setStatus(rs.getInt("Status"));

                lstBillMasters.add(billMaster);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return lstBillMasters;
    }

    /**
     *
     * @param empId
     * @return List BillMaster By EmpId
     */
    public List<BillMaster> getAllByEmpId(int empId) {
        strSql = "{call sp_Bill_GetByEmpId (?)}";
        Object[] value = {empId};
        List<BillMaster> lstBillMasters = new ArrayList<>();

        rs = DataUtility.getData(strSql, value);
        try {
            while (rs.next()) {
                billMaster = new BillMaster();
                billMaster.setBillId(rs.getInt("BillId"));
                billMaster.setCreateDate(rs.getDate("CreateDate"));
                billMaster.setCoupenNo(rs.getString("CoupenNo"));
                billMaster.setCoupenDate(rs.getDate("CoupenDate"));
                billMaster.setComment(rs.getString("Comment"));
                billMaster.setEmployeeId(rs.getInt("EmployeeId"));
                billMaster.setStatus(rs.getInt("Status"));

                lstBillMasters.add(billMaster);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return lstBillMasters;
    }

    /**
     *
     * @param empId
     * @param status
     * @return List BillMaster By EmpId and Status
     */
    public List<BillMaster> getAllByStatus(int empId, int status) {
        strSql = "{call sp_Bill_GetByStatus (?,?)}";
        Object[] value = {empId, status};
        List<BillMaster> lstBillMasters = new ArrayList<>();

        rs = DataUtility.getData(strSql, value);
        try {
            while (rs.next()) {
                billMaster = new BillMaster();
                billMaster.setBillId(rs.getInt("BillId"));
                billMaster.setCreateDate(rs.getDate("CreateDate"));
                billMaster.setCoupenNo(rs.getString("CoupenNo"));
                billMaster.setCoupenDate(rs.getDate("CoupenDate"));
                billMaster.setComment(rs.getString("Comment"));
                billMaster.setEmployeeId(rs.getInt("EmployeeId"));
                billMaster.setStatus(rs.getInt("Status"));

                lstBillMasters.add(billMaster);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return lstBillMasters;
    }

    /**
     *
     * @param obj
     * @return 0 or 1
     */
    @Override
    public int create(BillMaster obj) {
        strSql = "{call sp_Bill_Insert (?,?,?,?,?,?)}";
        Object[] value = {
            new Date(obj.getCreateDate().getTime()),
            obj.getCoupenNo(),
            new Date(obj.getCoupenDate().getTime()),
            obj.getComment(),
            obj.getEmployeeId(),
            obj.getStatus()
        };
        return DataUtility.setData(strSql, value);
    }

    @Override
    public int update(BillMaster obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param obj
     * @return 0 or 1
     */
    public int updateStatus(BillMaster obj) {
        strSql = "{call sp_Bill_UpdateStatus (?,?)}";
        Object[] value = {
            obj.getBillId(),
            obj.getStatus()
        };
        return DataUtility.setData(strSql, value);
    }

    /**
     *
     * @param obj
     * @return 0 or 1
     */
    public int updateComment(BillMaster obj) {
        strSql = "{call sp_Bill_UpdateComment (?,?)}";
        Object[] value = {
            obj.getBillId(),
            obj.getComment()
        };
        return DataUtility.setData(strSql, value);
    }

    /**
     *
     * @param obj
     * @return 0 or 1
     */
    @Override
    public int delete(BillMaster obj) {
        //strSql = "{call }";
        strSql = "DELETE FROM [BillMaster] WHERE [BillId]=?";
        Object[] value = {
            obj.getBillId()
        };
        return DataUtility.setData(strSql, value);
    }
}
