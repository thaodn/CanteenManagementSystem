/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.dal;

import canteen.common.bean.ItemMaster;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ItemMasterDAO extends AbstractDAO<ItemMaster> {

    @Override
    public ItemMaster getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ItemMaster> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(ItemMaster obj) {
        return false;
    }

    @Override
    public boolean update(ItemMaster obj) {
        return false;
    }

    @Override
    public boolean delete(ItemMaster obj) {
        return false;
    }
}
