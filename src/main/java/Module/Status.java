/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module;

/**
 *
 * @author Bun
 */
public class Status {
    int IdStatus;
    String NameStatus;

    public Status() {
    }

    public Status(int IdStatus, String NameStatus) {
        this.IdStatus = IdStatus;
        this.NameStatus = NameStatus;
    }

    public int getIdStatus() {
        return IdStatus;
    }

    public void setIdStatus(int IdStatus) {
        this.IdStatus = IdStatus;
    }

    public String getNameStatus() {
        return NameStatus;
    }

    public void setNameStatus(String NameStatus) {
        this.NameStatus = NameStatus;
    }

    @Override
    public String toString() {
        return NameStatus;
    }
    
    
}
