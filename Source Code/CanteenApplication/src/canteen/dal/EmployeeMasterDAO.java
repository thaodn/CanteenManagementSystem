/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.dal;

import canteen.common.bean.EmployeeMaster;
import java.util.List;

/**
 *
 * @author Admin
 */
public class EmployeeMasterDAO extends AbstractDAO<EmployeeMaster> {

    @Override
    public EmployeeMaster getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EmployeeMaster> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(EmployeeMaster obj) {
        return false;
    }

    @Override
    public boolean update(EmployeeMaster obj) {
        return false;
    }

    @Override
    public boolean delete(EmployeeMaster obj) {
        return false;
    }
}
