/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.bll;

import canteen.common.bean.FeedBack;
import canteen.dal.FeedBackDAO;
import java.util.List;

/**
 *
 * @author Admin
 */
public class FeedBackBLL {

    private static final FeedBackDAO objDAO = new FeedBackDAO();

    public static FeedBack getById(int id) {
        return objDAO.getById(id);
    }

    public static List<FeedBack> getAll() {
        return objDAO.getAll();
    }

    public static void create(FeedBack obj) {
        objDAO.create(obj);
    }

    public static void update(FeedBack obj) {
        objDAO.update(obj);
    }

    public static void delete(FeedBack obj) {
        objDAO.delete(obj);
    }
}
