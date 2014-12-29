/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.bll;

import canteen.common.bean.BillDetail;
import canteen.dal.BillDetailDAO;
import java.util.List;

/**
 *
 * @author Admin
 */
public class BillDetailBLL {

    private static final BillDetailDAO objDAO = new BillDetailDAO();

    public static BillDetail getById(int id) {
        return objDAO.getById(id);
    }

    public static List<BillDetail> getAll() {
        return objDAO.getAll();
    }

    public static boolean create(BillDetail obj) {
        return objDAO.create(obj);
    }

    public static boolean update(BillDetail obj) {
        return objDAO.update(obj);
    }

    public static boolean delete(BillDetail obj) {
        return objDAO.delete(obj);
    }

    public static float totalPriceByBId(BillDetail obj) {
        return objDAO.totalPriceByBId(obj);
    }
}
