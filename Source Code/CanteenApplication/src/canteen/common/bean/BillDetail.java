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
public class BillDetail {

    private int billId;
    private int itemId;
    private int quantity;
    private float rate;

    public BillDetail() {
    }

    public BillDetail(int billId, int itemId, int quantity, float rate) {
        this.billId = billId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.rate = rate;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
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
