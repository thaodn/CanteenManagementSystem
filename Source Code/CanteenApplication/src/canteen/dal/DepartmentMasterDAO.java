/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.dal;

import canteen.common.bean.DepartmentMaster;
import canteen.common.utility.DataUtility;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class DepartmentMasterDAO extends AbstractDAO<DepartmentMaster> {

    private ResultSet rs = null;
    private String strSql;
    private DepartmentMaster departmentMaster;

    @Override
    public DepartmentMaster getById(int id) {
        strSql = "{call sp_Department_GetById (?)}";
        Object[] value = {id};
        departmentMaster = new DepartmentMaster();

        rs = DataUtility.getData(strSql, value);
        try {
            while (rs.next()) {
                departmentMaster.setDepartmentId(rs.getInt("BillId"));
                departmentMaster.setName(rs.getString("Name"));
                departmentMaster.setStatus(rs.getInt("Status"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return departmentMaster;
    }

    public List<DepartmentMaster> getByStatus(int status) {
        strSql = "{call sp_Department_GetByStatus (?)}";
        Object[] value = {status};
        List<DepartmentMaster> lstDepartmentMasters = new ArrayList<>();

        rs = DataUtility.getData(strSql, value);
        try {
            while (rs.next()) {
                departmentMaster = new DepartmentMaster();
                departmentMaster.setDepartmentId(rs.getInt("BillId"));
                departmentMaster.setName(rs.getString("Name"));
                departmentMaster.setStatus(rs.getInt("Status"));

                lstDepartmentMasters.add(departmentMaster);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return lstDepartmentMasters;
    }

    @Override
    public List<DepartmentMaster> getAll() {
        strSql = "{call sp_Department_GetByAll}";
        List<DepartmentMaster> lstDepartmentMasters = new ArrayList<>();

        rs = DataUtility.getData(strSql);
        try {
            while (rs.next()) {
                departmentMaster = new DepartmentMaster();
                departmentMaster.setDepartmentId(rs.getInt("BillId"));
                departmentMaster.setName(rs.getString("Name"));
                departmentMaster.setStatus(rs.getInt("Status"));

                lstDepartmentMasters.add(departmentMaster);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return lstDepartmentMasters;
    }

    @Override
    public int create(DepartmentMaster obj) {
        strSql = "{call sp_Department_Insert (?,?)}";
        Object[] value = {
            obj.getName(),
            obj.getStatus()
        };
        return DataUtility.setData(strSql, value);
    }

    @Override
    public int update(DepartmentMaster obj) {
        strSql = "{call sp_Department_Update (?,?,?)}";
        Object[] value = {
            obj.getDepartmentId(),
            obj.getName(),
            obj.getStatus()
        };
        return DataUtility.setData(strSql, value);
    }

    @Override
    public int delete(DepartmentMaster obj) {
        //strSql = "{call sp_Department_Delete (?)}";
        strSql = "DELETE FROM [DepartmentMaster] WHERE [DepartmentId]=?";
        Object[] value = {
            obj.getDepartmentId()
        };
        return DataUtility.setData(strSql, value);
    }
}
