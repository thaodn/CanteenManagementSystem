/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.dal;

import canteen.common.bean.ItemTypeMaster;
import canteen.common.utility.DataUtility;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ItemTypeMasterDAO extends AbstractDAO<ItemTypeMaster> {

    private ResultSet rs = null;
    private String strSql;
    private ItemTypeMaster itemTypeMaster;

    @Override
    public ItemTypeMaster getById(int id) {
        strSql = "{call sp_ItemType_GetById (?)}";
        Object[] value = {id};
        itemTypeMaster = new ItemTypeMaster();

        rs = DataUtility.getData(strSql, value);
        try {
            while (rs.next()) {
                itemTypeMaster.setItemTypeId(rs.getInt("ItemTypeId"));
                itemTypeMaster.setName(rs.getString("Name"));
                itemTypeMaster.setStatus(rs.getInt("Status"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return itemTypeMaster;
    }

    public List<ItemTypeMaster> getByStatus(int status) {
        strSql = "{call sp_ItemType_GetById (?)}";
        Object[] value = {status};
        List<ItemTypeMaster> lstItemTypeMasters = new ArrayList<>();

        rs = DataUtility.getData(strSql, value);
        try {
            while (rs.next()) {
                itemTypeMaster = new ItemTypeMaster();
                itemTypeMaster.setItemTypeId(rs.getInt("ItemTypeId"));
                itemTypeMaster.setName(rs.getString("Name"));
                itemTypeMaster.setStatus(rs.getInt("Status"));

                lstItemTypeMasters.add(itemTypeMaster);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return lstItemTypeMasters;
    }

    @Override
    public List<ItemTypeMaster> getAll() {
        strSql = "{call sp_ItemType_GetById}";
        List<ItemTypeMaster> lstItemTypeMasters = new ArrayList<>();

        rs = DataUtility.getData(strSql);
        try {
            while (rs.next()) {
                itemTypeMaster = new ItemTypeMaster();
                itemTypeMaster.setItemTypeId(rs.getInt("ItemTypeId"));
                itemTypeMaster.setName(rs.getString("Name"));
                itemTypeMaster.setStatus(rs.getInt("Status"));

                lstItemTypeMasters.add(itemTypeMaster);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return lstItemTypeMasters;
    }

    @Override
    public int create(ItemTypeMaster obj) {
        strSql = "{call sp_ItemType_Insert (?,?)}";
        Object[] value = {
            obj.getName(),
            obj.getStatus()
        };
        return DataUtility.setData(strSql, value);
    }

    @Override
    public int update(ItemTypeMaster obj) {
        strSql = "{call sp_ItemType_Update (?,?,?)}";
        Object[] value = {
            obj.getItemTypeId(),
            obj.getName(),
            obj.getStatus()
        };
        return DataUtility.setData(strSql, value);
    }

    @Override
    public int delete(ItemTypeMaster obj) {
        //strSql = "{call sp_ItemType_Delete (?)}";
        strSql = "DELETE FROM [ItemTypeMaster] WHERE [ItemTypeId]=?";
        Object[] value = {
            obj.getItemTypeId()
        };
        return DataUtility.setData(strSql, value);
    }
}
