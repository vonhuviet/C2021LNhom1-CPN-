/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module;

/**
 *
 * @author Bun
 */
public class Warehouse_history {
    int ID;
    Warehouse warehouse;
    Orders orders;
    String CreateAt;

    public Warehouse_history() {
    }

    public Warehouse_history(int ID, Warehouse warehouse, Orders orders, String CreateAt) {
        this.ID = ID;
        this.warehouse = warehouse;
        this.orders = orders;
        this.CreateAt = CreateAt;
    }

    public Warehouse_history(int ID, String CreateAt) {
        this.ID = ID;
        this.CreateAt = CreateAt;
    }
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public String getCreateAt() {
        return CreateAt;
    }

    public void setCreateAt(String CreateAt) {
        this.CreateAt = CreateAt;
    }
    
    
}
