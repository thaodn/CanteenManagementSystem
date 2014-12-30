/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.dal;

import canteen.common.bean.BillDetail;
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
public class BillDetailDAO extends AbstractDAO<BillDetail> {

    private ResultSet rs = null;
    private String strSql;
    private BillDetail billDetail;

    @Override
    public BillDetail getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BillDetail> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return List BillDetail By BillId
     */
    public List<BillDetail> getAllByBillId(int id) {
        strSql = "{call sp_BillDetail_GetByBillId (?)}";
        Object[] value = {id};
        List<BillDetail> lstBillDetails = new ArrayList<>();

        rs = DataUtility.getData(strSql, value);
        try {
            while (rs.next()) {
                billDetail = new BillDetail();
                billDetail.setBillId(rs.getInt("BillId"));
                billDetail.setItemId(rs.getInt("ItemId"));
                billDetail.setQuantity(rs.getInt("Quantity"));
                billDetail.setRate(rs.getFloat("Rate"));

                lstBillDetails.add(billDetail);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return lstBillDetails;
    }

    /**
     *
     * @param obj
     * @return 0 or 1
     */
    @Override
    public int create(BillDetail obj) {
        strSql = "{call sp_BillDetail_Insert (?,?,?,?)}";
        Object[] value = {
            obj.getBillId(),
            obj.getItemId(),
            obj.getQuantity(),
            obj.getRate()
        };
        return DataUtility.setData(strSql, value);
    }

    @Override
    public int update(BillDetail obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param obj
     * @return 0 or 1
     */
    @Override
    public int delete(BillDetail obj) {
        //strSql = "{call }";
        strSql = "DELETE FROM [BillDetail] WHERE [BillId]=?";
        Object[] value = {
            obj.getBillId()
        };
        return DataUtility.setData(strSql, value);
    }

    /**
     *
     * @param obj
     * @return TotalPrice
     */
    public float totalPriceByBId(BillDetail obj) {
        //strSql = "{call }";
        strSql = "SELECT SUM([Quantity]*[Rate]) AS [TotalPrice] FROM [BillDetail] WHERE [BillId]=?";
        Object[] value = {
            obj.getBillId()
        };
        float totalPrice = 0;

        try {
            rs = DataUtility.getData(strSql, value);
            if (rs.next()) {
                totalPrice = rs.getFloat("TotalPrice");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return totalPrice;
    }
}
