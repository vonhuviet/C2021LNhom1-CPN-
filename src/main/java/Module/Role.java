/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module;

/**
 *
 * @author Bun
 */
public class Role {
    int IdRole;
    String NameRole;

    public Role() {
    }

    public Role(int IdRole, String NameRole) {
        this.IdRole = IdRole;
        this.NameRole = NameRole;
    }

    public int getIdRole() {
        return IdRole;
    }

    public void setIdRole(int IdRole) {
        this.IdRole = IdRole;
    }

    public String getNameRole() {
        return NameRole;
    }

    public void setNameRole(String NameRole) {
        this.NameRole = NameRole;
    }

    @Override
    public String toString() {
        return  NameRole;
    }
    
    public static String roleIDtoString(int IdRole){
        if(IdRole == 1){
            return "Admin";
        }else if(IdRole == 2){
            return  "Staff";
        }else{
            return "Unknown";
        }
    }
}
