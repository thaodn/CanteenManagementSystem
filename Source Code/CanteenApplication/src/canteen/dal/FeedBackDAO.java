/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.dal;

import canteen.common.bean.FeedBack;
import java.util.List;

/**
 *
 * @author Admin
 */
public class FeedBackDAO extends AbstractDAO<FeedBack> {

    @Override
    public FeedBack getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FeedBack> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(FeedBack obj) {
        return false;
    }

    @Override
    public boolean update(FeedBack obj) {
        return false;
    }

    @Override
    public boolean delete(FeedBack obj) {
        return false;
    }
}
