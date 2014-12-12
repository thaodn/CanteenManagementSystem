/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.common.bean;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class FeedBack {

    private int feedBackId;
    private int employeeId;
    private String title;
    private Date date;
    private String message;
    private boolean status;

    public FeedBack() {
    }

    public FeedBack(int feedBackId, int employeeId, String title, Date date, String message, boolean status) {
        this.feedBackId = feedBackId;
        this.employeeId = employeeId;
        this.title = title;
        this.date = date;
        this.message = message;
        this.status = status;
    }

    public int getFeedBackId() {
        return feedBackId;
    }

    public void setFeedBackId(int feedBackId) {
        this.feedBackId = feedBackId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
