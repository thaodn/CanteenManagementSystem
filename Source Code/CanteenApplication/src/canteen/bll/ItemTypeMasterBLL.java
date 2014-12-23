/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.bll;

import canteen.common.bean.ItemTypeMaster;
import canteen.dal.ItemTypeMasterDAO;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ItemTypeMasterBLL {

    private static final ItemTypeMasterDAO objDAO = new ItemTypeMasterDAO();

    public static ItemTypeMaster getById(int id) {
        return objDAO.getById(id);
    }

    public static List<ItemTypeMaster> getAll() {
        return objDAO.getAll();
    }

    public static void create(ItemTypeMaster obj) {
        objDAO.create(obj);
    }

    public static void update(ItemTypeMaster obj) {
        objDAO.update(obj);
    }

    public static void delete(ItemTypeMaster obj) {
        objDAO.delete(obj);
    }
}
