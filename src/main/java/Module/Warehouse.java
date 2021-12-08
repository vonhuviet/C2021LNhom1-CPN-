/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module;

/**
 *
 * @author Bun
 */
public class Warehouse {
    int IdWhouse;
    String NameWhouse,Address,Note;

    public Warehouse() {
    }

    public Warehouse(int IdWhouse, String NameWhouse,String Address ,String Note) {
        this.IdWhouse = IdWhouse;
        this.NameWhouse = NameWhouse;
        this.Address = Address;
        this.Note = Note;
    }

    public Warehouse(String NameWhouse, String Address, String Note) {
        this.NameWhouse = NameWhouse;
        this.Address = Address;
        this.Note = Note;
    }
    
    

    public int getIdWhouse() {
        return IdWhouse;
    }

    public void setIdWhouse(int IdWhouse) {
        this.IdWhouse = IdWhouse;
    }

    public Warehouse(int IdWhouse, String NameWhouse) {
        this.IdWhouse = IdWhouse;
        this.NameWhouse = NameWhouse;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    
    
    public String getNameWhouse() {
        return NameWhouse;
    }

    public void setNameWhouse(String NameWhouse) {
        this.NameWhouse = NameWhouse;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    @Override
    public String toString() {
        return NameWhouse;
    }
    
    
}
