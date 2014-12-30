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
    private int status;

    public ItemTypeMaster() {
    }

    public ItemTypeMaster(int itemTypeId, String name, int status) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
