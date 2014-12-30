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

    public static List<ItemTypeMaster> getByStatus(int status) {
        return objDAO.getByStatus(status);
    }

    public static List<ItemTypeMaster> getAll() {
        return objDAO.getAll();
    }

    public static int create(ItemTypeMaster obj) {
        return objDAO.create(obj);
    }

    public static int update(ItemTypeMaster obj) {
        return objDAO.update(obj);
    }

    public static int delete(ItemTypeMaster obj) {
        return objDAO.delete(obj);
    }
}
