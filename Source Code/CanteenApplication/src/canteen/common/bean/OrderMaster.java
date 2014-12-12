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
public class OrderMaster {

    private int orderId;
    private Date orderDate;
    private String coupenNo;
    private Date coupenDate;
    private String orderInfo;
    private int employeeId;
    private boolean status;

    public OrderMaster() {
    }

    public OrderMaster(int orderId, Date orderDate, String coupenNo, Date coupenDate, String orderInfo, int employeeId, boolean status) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.coupenNo = coupenNo;
        this.coupenDate = coupenDate;
        this.orderInfo = orderInfo;
        this.employeeId = employeeId;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
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

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
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
