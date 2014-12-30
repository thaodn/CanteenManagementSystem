/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.dal;

import canteen.common.bean.EmployeeMaster;
import canteen.common.utility.DataUtility;
import canteen.common.utility.Encryption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class EmployeeMasterDAO extends AbstractDAO<EmployeeMaster> {

    private ResultSet rs = null;
    private String strSql;
    private EmployeeMaster employeeMaster;

    @Override
    public EmployeeMaster getById(int id) {
        strSql = "{call sp_Employee_GetById (?)}";
        Object[] value = {id};
        employeeMaster = new EmployeeMaster();

        rs = DataUtility.getData(strSql, value);
        try {
            while (rs.next()) {
                employeeMaster.setEmployeeId(rs.getInt("EmployeeId"));
                employeeMaster.setDepartmentId(rs.getInt("DepartmentId"));
                employeeMaster.setUserName(rs.getString("Username"));
                employeeMaster.setPassword(rs.getString("Password"));
                employeeMaster.setFullName(rs.getString("FullName"));
                employeeMaster.setAddress(rs.getString("Address"));
                employeeMaster.setPhone(rs.getString("Phone"));
                employeeMaster.setEmail(rs.getString("Email"));
                employeeMaster.setStatus(rs.getInt("Status"));
                employeeMaster.setRole(rs.getInt("Role"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return employeeMaster;
    }

    public EmployeeMaster getByLogin(String userName, String password) {
        strSql = "{call sp_Employee_GetByLogin (?,?)}";
        Object[] value = {userName, Encryption.getMD5(password)};
        employeeMaster = new EmployeeMaster();

        rs = DataUtility.getData(strSql, value);
        try {
            while (rs.next()) {
                employeeMaster.setEmployeeId(rs.getInt("EmployeeId"));
                employeeMaster.setDepartmentId(rs.getInt("DepartmentId"));
                employeeMaster.setUserName(rs.getString("Username"));
                employeeMaster.setPassword(rs.getString("Password"));
                employeeMaster.setFullName(rs.getString("FullName"));
                employeeMaster.setAddress(rs.getString("Address"));
                employeeMaster.setPhone(rs.getString("Phone"));
                employeeMaster.setEmail(rs.getString("Email"));
                employeeMaster.setStatus(rs.getInt("Status"));
                employeeMaster.setRole(rs.getInt("Role"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return employeeMaster;
    }

    @Override
    public List<EmployeeMaster> getAll() {
        strSql = "{call sp_Bill_GetByAll}";
        List<EmployeeMaster> lstEmployeeMasters = new ArrayList<>();

        rs = DataUtility.getData(strSql);
        try {
            while (rs.next()) {
                employeeMaster = new EmployeeMaster();
                employeeMaster.setEmployeeId(rs.getInt("EmployeeId"));
                employeeMaster.setDepartmentId(rs.getInt("DepartmentId"));
                employeeMaster.setUserName(rs.getString("Username"));
                employeeMaster.setPassword(rs.getString("Password"));
                employeeMaster.setFullName(rs.getString("FullName"));
                employeeMaster.setAddress(rs.getString("Address"));
                employeeMaster.setPhone(rs.getString("Phone"));
                employeeMaster.setEmail(rs.getString("Email"));
                employeeMaster.setStatus(rs.getInt("Status"));
                employeeMaster.setRole(rs.getInt("Role"));

                lstEmployeeMasters.add(employeeMaster);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return lstEmployeeMasters;
    }

    @Override
    public int create(EmployeeMaster obj) {
        strSql = "{call sp_Employee_Insert (?,?,?,?,?,?,?,?,?)}";
        Object[] value = {
            obj.getDepartmentId(),
            obj.getUserName(),
            Encryption.getMD5(obj.getPassword()),
            obj.getFullName(),
            obj.getAddress(),
            obj.getPhone(),
            obj.getEmail(),
            obj.getStatus(),
            obj.getRole()
        };
        return DataUtility.setData(strSql, value);
    }

    @Override
    public int update(EmployeeMaster obj) {
        strSql = "{call sp_Employee_Update (?,?,?,?,?,?,?,?,?,?)}";
        Object[] value = {
            obj.getEmployeeId(),
            obj.getDepartmentId(),
            obj.getUserName(),
            Encryption.getMD5(obj.getPassword()),
            obj.getFullName(),
            obj.getAddress(),
            obj.getPhone(),
            obj.getEmail(),
            obj.getStatus(),
            obj.getRole()
        };
        return DataUtility.setData(strSql, value);
    }

    @Override
    public int delete(EmployeeMaster obj) {
        //strSql = "{call sp_Employee_Delete (?)}";
        strSql = "DELETE FROM [EmployeeMaster] WHERE [EmployeeId]=?";
        Object[] value = {
            obj.getDepartmentId()
        };
        return DataUtility.setData(strSql, value);
    }

    public int changePassword(int id, String password) {
        strSql = "{call sp_Employee_ChangePassword (?,?)}";
        Object[] value = {id, Encryption.getMD5(password)};
        return DataUtility.setData(strSql, value);
    }

    public int forgotPassword(int id, String userName) {
        strSql = "{call sp_Employee_ForgotPassword (?,?)}";
        Object[] value = {id, Encryption.getMD5(userName)};
        return DataUtility.setData(strSql, value);
    }
}
