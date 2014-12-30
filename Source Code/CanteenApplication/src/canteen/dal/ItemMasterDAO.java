/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.dal;

import canteen.common.bean.ItemMaster;
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
public class ItemMasterDAO extends AbstractDAO<ItemMaster> {

    private ResultSet rs = null;
    private String strSql;
    private ItemMaster itemMaster;

    @Override
    public ItemMaster getById(int id) {
        strSql = "{call sp_Item_GetById (?)}";
        Object[] value = {id};
        itemMaster = new ItemMaster();

        rs = DataUtility.getData(strSql, value);
        try {
            while (rs.next()) {
                itemMaster.setItemId(rs.getInt("ItemId"));
                itemMaster.setName(rs.getString("Name"));
                itemMaster.setImage(rs.getString("Image"));
                itemMaster.setItemTypeId(rs.getInt("ItemTypeId"));
                itemMaster.setRate(rs.getFloat("Rate"));
                itemMaster.setQuantity(rs.getInt("Quantity"));
                itemMaster.setSpecial(rs.getInt("Special"));
                itemMaster.setStatus(rs.getInt("Status"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return itemMaster;
    }

    public List<ItemMaster> getByStatus(int status) {
        strSql = "{call sp_Item_GetByStatus (?)}";
        Object[] value = {status};
        List<ItemMaster> lstItemMasters = new ArrayList<>();

        rs = DataUtility.getData(strSql, value);
        try {
            while (rs.next()) {
                itemMaster = new ItemMaster();
                itemMaster.setItemId(rs.getInt("ItemId"));
                itemMaster.setName(rs.getString("Name"));
                itemMaster.setImage(rs.getString("Image"));
                itemMaster.setItemTypeId(rs.getInt("ItemTypeId"));
                itemMaster.setRate(rs.getFloat("Rate"));
                itemMaster.setQuantity(rs.getInt("Quantity"));
                itemMaster.setSpecial(rs.getInt("Special"));
                itemMaster.setStatus(rs.getInt("Status"));

                lstItemMasters.add(itemMaster);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return lstItemMasters;
    }

    @Override
    public List<ItemMaster> getAll() {
        strSql = "{call sp_Item_GetByAll}";
        List<ItemMaster> lstItemMasters = new ArrayList<>();

        rs = DataUtility.getData(strSql);
        try {
            while (rs.next()) {
                itemMaster = new ItemMaster();
                itemMaster.setItemId(rs.getInt("ItemId"));
                itemMaster.setName(rs.getString("Name"));
                itemMaster.setImage(rs.getString("Image"));
                itemMaster.setItemTypeId(rs.getInt("ItemTypeId"));
                itemMaster.setRate(rs.getFloat("Rate"));
                itemMaster.setQuantity(rs.getInt("Quantity"));
                itemMaster.setSpecial(rs.getInt("Special"));
                itemMaster.setStatus(rs.getInt("Status"));

                lstItemMasters.add(itemMaster);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return lstItemMasters;
    }

    @Override
    public int create(ItemMaster obj) {
        strSql = "{call sp_Item_Insert (?,?,?,?,?,?,?)}";
        Object[] value = {
            obj.getName(),
            obj.getImage(),
            obj.getItemTypeId(),
            obj.getRate(),
            obj.getQuantity(),
            obj.getSpecial(),
            obj.getStatus()
        };
        return DataUtility.setData(strSql, value);
    }

    @Override
    public int update(ItemMaster obj) {
        strSql = "{call sp_Item_Update (?,?,?,?,?,?,?,?)}";
        Object[] value = {
            obj.getItemId(),
            obj.getName(),
            obj.getImage(),
            obj.getItemTypeId(),
            obj.getRate(),
            obj.getQuantity(),
            obj.getSpecial(),
            obj.getStatus()
        };
        return DataUtility.setData(strSql, value);
    }

    @Override
    public int delete(ItemMaster obj) {
        //strSql = "{call sp_Item_Delete (?)}";
        strSql = "DELETE FROM [ItemMaster] WHERE [ItemId]=?";
        Object[] value = {
            obj.getItemId()
        };
        return DataUtility.setData(strSql, value);
    }
}
