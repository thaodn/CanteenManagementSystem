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
public class BillMaster {

    private int bId;
    private Date createDate;
    private String coupenNo;
    private Date coupenDate;
    private String comment;
    private int employeeId;
    private boolean status;

    public BillMaster() {
    }

    public BillMaster(int bId, Date createDate, String coupenNo, Date coupenDate, String comment, int employeeId, boolean status) {
        this.bId = bId;
        this.createDate = createDate;
        this.coupenNo = coupenNo;
        this.coupenDate = coupenDate;
        this.comment = comment;
        this.employeeId = employeeId;
        this.status = status;
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCoupenNo() {
        return coupenNo;
    }

    public void setCoupenNo(String coupenNo) {
        this.coupenNo = coupenNo;
    }

    public Date getCoupenDate() {
        return coupenDate;
    }

    public void setCoupenDate(Date coupenDate) {
        this.coupenDate = coupenDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
