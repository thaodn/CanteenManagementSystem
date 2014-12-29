/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.bll;

import canteen.common.bean.BillMaster;
import canteen.dal.BillMasterDAO;
import java.util.List;

/**
 *
 * @author Admin
 */
public class BillMasterBLL {

    private static final BillMasterDAO objDAO = new BillMasterDAO();

    public static BillMaster getById(int id) {
        return objDAO.getById(id);
    }

    public static List<BillMaster> getAll() {
        return objDAO.getAll();
    }

    public static List<BillMaster> getAllByEmpId(int empId) {
        return objDAO.getAllByEmpId(empId);
    }

    public static boolean create(BillMaster obj) {
        return objDAO.create(obj);
    }

    public static boolean updateStatus(BillMaster obj) {
        return objDAO.updateStatus(obj);
    }

    public static boolean updateComment(BillMaster obj) {
        return objDAO.updateComment(obj);
    }

    public static boolean delete(BillMaster obj) {
        return objDAO.delete(obj);
    }
}
