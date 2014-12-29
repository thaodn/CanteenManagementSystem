/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.bll;

import canteen.common.bean.DepartmentMaster;
import canteen.dal.DepartmentMasterDAO;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DepartmentMasterBLL {

    private static final DepartmentMasterDAO objDAO = new DepartmentMasterDAO();

    public static DepartmentMaster getById(int id) {
        return objDAO.getById(id);
    }

    public static List<DepartmentMaster> getAll() {
        return objDAO.getAll();
    }

    public static boolean create(DepartmentMaster obj) {
        return objDAO.create(obj);
    }

    public static boolean update(DepartmentMaster obj) {
        return objDAO.update(obj);
    }

    public static boolean delete(DepartmentMaster obj) {
        return objDAO.delete(obj);
    }
}
