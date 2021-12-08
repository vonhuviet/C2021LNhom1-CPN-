package Module;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Bun
 */
public class Users {
    int IdUser;
    String Username,Password;
    public int IdRole, Active;
    String Mobile,Address,Fullname,Email;

    public Users() {
    }

    public Users(int IdUser, String Username, String Password, int IdRole, int Active, String Mobile, String Address, String Fullname, String Email) {
        this.IdUser = IdUser;
        this.Username = Username;
        this.Password = Password;
        this.IdRole = IdRole;
        this.Active = Active;
        this.Mobile = Mobile;
        this.Address = Address;
        this.Fullname = Fullname;
        this.Email = Email;
    }

    public Users(String Username, String Password, int IdRole, int Active, String Mobile, String Address, String Fullname, String Email) {
        this.Username = Username;
        this.Password = Password;
        this.IdRole = IdRole;
        this.Active = Active;
        this.Mobile = Mobile;
        this.Address = Address;
        this.Fullname = Fullname;
        this.Email = Email;
    }


    public Users(int IdUser, String Username) {
        this.IdUser = IdUser;
        this.Username = Username;
    }
    
    

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getIdRole() {
        return IdRole;
    }

    public void setIdRole(int IdRole) {
        this.IdRole = IdRole;
    }

    public int getActive() {
        return Active;
    }

    public void setActive(int Active) {
        this.Active = Active;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return Username ;
    }
     
    public static String activeStateToString(int active) {
        if (active == 1) {
            return "Active";
        } else {
            return "Inactive";
        }
    }

    public static boolean activeStateToBool(int active) {
        if (active == 1) {
            return true;
        } else {
            return false;
        }
    }
}
