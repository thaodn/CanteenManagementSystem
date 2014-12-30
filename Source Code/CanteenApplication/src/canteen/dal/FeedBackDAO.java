/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.dal;

import canteen.common.bean.FeedBack;
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
public class FeedBackDAO extends AbstractDAO<FeedBack> {

    private ResultSet rs = null;
    private String strSql;
    private FeedBack feedBack;

    @Override
    public FeedBack getById(int id) {
        strSql = "{call sp_FeedBack_GetById (?)}";
        Object[] value = {id};
        feedBack = new FeedBack();

        rs = DataUtility.getData(strSql, value);
        try {
            while (rs.next()) {
                feedBack.setFeedBackId(rs.getInt("FeedBackId"));
                feedBack.setEmployeeId(rs.getInt("EmployeeId"));
                feedBack.setTitle(rs.getString("Title"));
                feedBack.setDate(rs.getDate("Date"));
                feedBack.setMessage(rs.getString("Message"));
                feedBack.setStatus(rs.getInt("Status"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return feedBack;
    }

    public List<FeedBack> getByStatus(int status) {
        strSql = "{call sp_FeedBack_GetByStatus (?)}";
        Object[] value = {status};
        List<FeedBack> lstFeedBacks = new ArrayList<>();

        rs = DataUtility.getData(strSql, value);
        try {
            while (rs.next()) {
                feedBack = new FeedBack();
                feedBack.setFeedBackId(rs.getInt("FeedBackId"));
                feedBack.setEmployeeId(rs.getInt("EmployeeId"));
                feedBack.setTitle(rs.getString("Title"));
                feedBack.setDate(rs.getDate("Date"));
                feedBack.setMessage(rs.getString("Message"));
                feedBack.setStatus(rs.getInt("Status"));

                lstFeedBacks.add(feedBack);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return lstFeedBacks;
    }

    @Override
    public List<FeedBack> getAll() {
        strSql = "{call sp_FeedBack_GetByAll}";
        List<FeedBack> lstFeedBacks = new ArrayList<>();

        rs = DataUtility.getData(strSql);
        try {
            while (rs.next()) {
                feedBack = new FeedBack();
                feedBack.setFeedBackId(rs.getInt("FeedBackId"));
                feedBack.setEmployeeId(rs.getInt("EmployeeId"));
                feedBack.setTitle(rs.getString("Title"));
                feedBack.setDate(rs.getDate("Date"));
                feedBack.setMessage(rs.getString("Message"));
                feedBack.setStatus(rs.getInt("Status"));

                lstFeedBacks.add(feedBack);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return lstFeedBacks;
    }

    @Override
    public int create(FeedBack obj) {
        strSql = "{call sp_FeedBack_Insert (?,?,?,?,?)}";
        Object[] value = {
            obj.getEmployeeId(),
            obj.getTitle(),
            obj.getDate(),
            obj.getMessage(),
            obj.getStatus()
        };
        return DataUtility.setData(strSql, value);
    }

    @Override
    public int update(FeedBack obj) {
        strSql = "{call sp_FeedBack_Update (?,?,?,?,?,?)}";
        Object[] value = {
            obj.getFeedBackId(),
            obj.getEmployeeId(),
            obj.getTitle(),
            obj.getDate(),
            obj.getMessage(),
            obj.getStatus()
        };
        return DataUtility.setData(strSql, value);
    }

    @Override
    public int delete(FeedBack obj) {
        //strSql = "{call sp_FeedBack_Delete (?)}";
        strSql = "DELETE FROM [FeedBack] WHERE [FeedBackId]=?";
        Object[] value = {obj.getFeedBackId()};
        return DataUtility.setData(strSql, value);
    }
}
