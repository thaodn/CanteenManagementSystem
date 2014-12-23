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

    public static void create(DepartmentMaster obj) {
        objDAO.create(obj);
    }

    public static void update(DepartmentMaster obj) {
        objDAO.update(obj);
    }

    public static void delete(DepartmentMaster obj) {
        objDAO.delete(obj);
    }
}
