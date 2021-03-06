/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.dal;

import java.util.List;

/**
 *
 * @author Admin
 * @param <T>
 */
public interface IDAO<T extends Object> {

    T getById(int id);

    List<T> getAll();

    int create(T obj);

    int update(T obj);

    int delete(T obj);
}
