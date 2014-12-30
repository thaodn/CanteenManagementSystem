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

    private static BillDetailDAO objDAO = new BillDetailDAO();

    public static List<BillDetail> getAllByBillId(int id) {
        return objDAO.getAllByBillId(id);
    }

    public static int create(BillDetail obj) {
        return objDAO.create(obj);
    }

    public static int delete(BillDetail obj) {
        return objDAO.delete(obj);
    }

    public static float totalPriceByBId(BillDetail obj) {
        return objDAO.totalPriceByBId(obj);
    }
}
