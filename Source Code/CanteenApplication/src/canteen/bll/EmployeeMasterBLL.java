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

    public static void create(EmployeeMaster obj) {
        objDAO.create(obj);
    }

    public static void update(EmployeeMaster obj) {
        objDAO.update(obj);
    }

    public static void delete(EmployeeMaster obj) {
        objDAO.delete(obj);
    }
}
