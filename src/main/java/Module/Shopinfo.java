/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module;

/**
 *
 * @author Bun
 */
public class Shopinfo {
    int IdShop;
    String Shopname,ShopPhone,Address,Email;

    public Shopinfo() {
    }

    public Shopinfo(int IdShop, String Shopname, String ShopPhone, String Address, String Email) {
        this.IdShop = IdShop;
        this.Shopname = Shopname;
        this.ShopPhone = ShopPhone;
        this.Address = Address;
        this.Email = Email;
    }

    public Shopinfo(int IdShop, String Shopname) {
        this.IdShop = IdShop;
        this.Shopname = Shopname;
    }

    public Shopinfo(String Shopname, String ShopPhone, String Address, String Email) {
        this.Shopname = Shopname;
        this.ShopPhone = ShopPhone;
        this.Address = Address;
        this.Email = Email;
    }
    
    
    
    
    public int getIdShop() {
        return IdShop;
    }

    public void setIdShop(int IdShop) {
        this.IdShop = IdShop;
    }

    public String getShopname() {
        return Shopname;
    }

    public void setShopname(String Shopname) {
        this.Shopname = Shopname;
    }

    public String getShopPhone() {
        return ShopPhone;
    }

    public void setShopPhone(String ShopPhone) {
        this.ShopPhone = ShopPhone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return  Shopname ;
    }
    
    
    
}
