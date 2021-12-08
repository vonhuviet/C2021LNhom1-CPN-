/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import java.util.List;
import Module.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bun
 */
public class ServiceDAO extends BaseDAO {

    public static List<Service> getSerList() {
        List<Service> serviceList = new ArrayList<>();

        openConnection();
             String sql = "select * from service";
             
        try {
           
            statement = conn.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Service sv = new Service(
                        resultSet.getInt("Id_Service"), 
                        resultSet.getString("Name_Service"), 
                        resultSet.getInt("Price_Service"), 
                        resultSet.getString("Note")    
                );
                serviceList.add(sv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }

        return serviceList;
    }

    public static void insertSer(Service sv) {

        openConnection();

        try {
            String sql = "insert into service(Name_Service, Price_Service, Note)value(?,?,?)";
            statement = conn.prepareStatement(sql);

            statement.setString(1, sv.getNameService());
            statement.setInt(2, sv.getPriceService());
            statement.setString(3, sv.getNote());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }

    }

    public static void updateSer(Service sv) {

        openConnection();

        try {
            String sql = "update service set Name_Service = ?, Price_Service = ?, AddrNoteess = ? where Id_Service = ? ";
            statement = conn.prepareStatement(sql);

            statement.setString(1, sv.getNameService());
            statement.setInt(2, sv.getPriceService());
            statement.setString(3, sv.getNote());
            statement.setInt(4, sv.getIdService());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }

    public static void deleteSerID(int Id) {

        openConnection();

        try {
            String sql = "delete from service where Id_Service = ? ";
            statement = conn.prepareStatement(sql);

            statement.setInt(1, Id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }
}
