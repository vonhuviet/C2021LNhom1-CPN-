/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import Module.*;

/**
 *
 * @author Bun
 */
public class DataMgr {
    public Users loginWithId;
    private static DataMgr instance = null;
 
    
    private DataMgr(){
        loginWithId = new Users();
    }
    
    public static DataMgr getInstance(){
        if(instance == null){
            instance = new DataMgr();
        }
        return instance;
    }
    
}
