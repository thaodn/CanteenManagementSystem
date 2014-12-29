/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.dal;

import canteen.common.bean.DepartmentMaster;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DepartmentMasterDAO extends AbstractDAO<DepartmentMaster> {

    @Override
    public DepartmentMaster getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DepartmentMaster> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(DepartmentMaster obj) {
        return false;
    }

    @Override
    public boolean update(DepartmentMaster obj) {
        return false;
    }

    @Override
    public boolean delete(DepartmentMaster obj) {
        return false;
    }
}
