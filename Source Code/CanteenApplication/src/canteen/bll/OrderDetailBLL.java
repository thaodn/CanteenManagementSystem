/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.bll;

import canteen.common.bean.OrderDetail;
import canteen.dal.OrderDetailDAO;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderDetailBLL {

    private static final OrderDetailDAO objDAO = new OrderDetailDAO();

    public OrderDetail getById(int id) {
        return objDAO.getById(id);
    }

    public List<OrderDetail> getAll() {
        return objDAO.getAll();
    }

    public void create(OrderDetail obj) {
        objDAO.create(obj);
    }

    public void update(OrderDetail obj) {
        objDAO.update(obj);
    }

    public void delete(OrderDetail obj) {
        objDAO.delete(obj);
    }
}
