/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.bll;

import canteen.common.bean.EmployeeMaster;
import canteen.dal.EmployeeMasterDAO;
import java.util.List;

/**
 *
 * @author Admin
 */
public class EmployeeMasterBLL {

    private static final EmployeeMasterDAO objDAO = new EmployeeMasterDAO();

    public static EmployeeMaster getById(int id) {
        return objDAO.getById(id);
    }

    public static EmployeeMaster getByLogin(String userName, String password) {
        return objDAO.getByLogin(userName, password);
    }

    public static List<EmployeeMaster> getAll() {
        return objDAO.getAll();
    }

    public static int create(EmployeeMaster obj) {
        return objDAO.create(obj);
    }

    public static int update(EmployeeMaster obj) {
        return objDAO.update(obj);
    }

    public static int delete(EmployeeMaster obj) {
        return objDAO.delete(obj);
    }

    public static int changePassword(int id, String password) {
        return objDAO.changePassword(id, password);
    }

    public static int forgotPassword(int id, String userName) {
        return objDAO.forgotPassword(id, userName);
    }
}
