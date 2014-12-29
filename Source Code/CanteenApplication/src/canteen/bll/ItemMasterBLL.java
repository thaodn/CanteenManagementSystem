/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.bll;

import canteen.common.bean.ItemMaster;
import canteen.dal.ItemMasterDAO;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ItemMasterBLL {

    private static final ItemMasterDAO objDAO = new ItemMasterDAO();

    public static ItemMaster getById(int id) {
        return objDAO.getById(id);
    }

    public static List<ItemMaster> getAll() {
        return objDAO.getAll();
    }

    public static boolean create(ItemMaster obj) {
        return objDAO.create(obj);
    }

    public static boolean update(ItemMaster obj) {
        return objDAO.update(obj);
    }

    public static boolean delete(ItemMaster obj) {
        return objDAO.delete(obj);
    }
}
