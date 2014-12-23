/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.bll;

import canteen.common.bean.OrderMaster;
import canteen.dal.OrderMasterDAO;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderMasterBLL {

    private static final OrderMasterDAO objDAO = new OrderMasterDAO();

    public static OrderMaster getById(int id) {
        return objDAO.getById(id);
    }

    public static List<OrderMaster> getAll() {
        return objDAO.getAll();
    }

    public static void create(OrderMaster obj) {
        objDAO.create(obj);
    }

    public static void update(OrderMaster obj) {
        objDAO.update(obj);
    }

    public static void delete(OrderMaster obj) {
        objDAO.delete(obj);
    }
}
