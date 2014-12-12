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
public class ItemTypeMaster {

    private int itemTypeId;
    private String name;
    private boolean status;

    public ItemTypeMaster() {
    }

    public ItemTypeMaster(int itemTypeId, String name, boolean status) {
        this.itemTypeId = itemTypeId;
        this.name = name;
        this.status = status;
    }

    public int getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(int itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String itemTypeName) {
        this.name = itemTypeName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
