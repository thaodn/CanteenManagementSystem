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

    public static List<EmployeeMaster> getAll() {
        return objDAO.getAll();
    }

    public static boolean create(EmployeeMaster obj) {
        return objDAO.create(obj);
    }

    public static boolean update(EmployeeMaster obj) {
        return objDAO.update(obj);
    }

    public static boolean delete(EmployeeMaster obj) {
        return objDAO.delete(obj);
    }
}
