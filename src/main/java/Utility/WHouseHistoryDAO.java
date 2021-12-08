/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import java.util.List;
import Module.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bun
 */
public class WHouseHistoryDAO extends BaseDAO {

    public static List<Warehouse_history> getWHouseList() {
        List<Warehouse_history> whouseHistoryList = new ArrayList<>();

        openConnection();
             String sql = "select warehouse_history.*,"
                     + "orders.RollNo as Name_Orders, "
                     + "warehouse.Name_Whouse as Name_Whouse "
                     + "from warehouse_history "
                     + "left join orders on orders.Id_Orders = warehouse_history.Id_Orders "
                     + "left join warehouse on warehouse.Id_Whouse = warehouse_history.Id_Orders ";
        try {
           
            statement = conn.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Warehouse_history whh = new Warehouse_history(
                        resultSet.getInt("Id_Whouse"), 
                        resultSet.getString("Create_At")
                );
                        
                
                Orders od = new Orders(resultSet.getInt("Id_Orders"), resultSet.getString("RollNo"));
                whh.setOrders(od);
                
                Warehouse wh = new Warehouse(resultSet.getInt("Id_Whouse"), resultSet.getString("Name_Whouse"));
                whh.setWarehouse(wh);
                
                whouseHistoryList.add(whh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WHouseHistoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }

        return whouseHistoryList;
    }

    public static void insertWhouse(Warehouse wh) {

        openConnection();

        try {
            String sql = " insert into warehouse(Name_Whouse,Address ,Note) value (?,?,?) ";
            statement = conn.prepareStatement(sql);

            statement.setString(1, wh.getNameWhouse());
            statement.setString(2, wh.getAddress());
            statement.setString(3, wh.getNote());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(WHouseHistoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }

    }

    public static void updateWhouse(Warehouse wh) {

        openConnection();

        try {
            String sql = "update warehouse set Name_Whouse = ?,Address = ? ,Note = ? where Id_Whouse = ? ";
            statement = conn.prepareStatement(sql);

            statement.setString(1, wh.getNameWhouse());
            statement.setString(2, wh.getAddress());
            statement.setString(3, wh.getNote());
            
            statement.setInt(4, wh.getIdWhouse());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(WHouseHistoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }

    public static void deleteWhouse(int Id) {

        openConnection();

        try {
            String sql = "delete from warehouse where Id_Whouse = ? ";
            statement = conn.prepareStatement(sql);

            statement.setInt(1, Id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(WHouseHistoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }
}
