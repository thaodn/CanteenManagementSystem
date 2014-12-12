/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.dal;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Admin
 * @param <T>
 */
public interface DAO<T extends Object> {

    T getById(int id) throws SQLException, ClassNotFoundException;

    List<T> getAll();

    void create(T t);

    void update(T t);

    void delete(T t);
}
