/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteen.common.bean;

/**
 *
 * @author Admin
 */
public class OrderDetail {

    private int orderId;
    private int itemId;
    private int quantity;
    private float rate;

    public OrderDetail() {
    }

    public OrderDetail(int orderId, int itemId, int quantity, float rate) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.rate = rate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

}
