/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import Connect.Config;
import Module.Orders;
import Module.Shopinfo;
import Module.Service;
import Module.Warehouse;
import Module.Users;
import Module.Status;
import static Utility.BaseDAO.closeConnection;
import static Utility.BaseDAO.conn;
import static Utility.BaseDAO.openConnection;
import static Utility.BaseDAO.statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quocviet
 */
public class OrderDAO extends BaseDAO {

    //orders List
    public static List<Orders> getOrdersList(String rollNo) {
        List<Orders> ordersList = new ArrayList<>();

        openConnection();
             String sql = "select orders.*, "
                     + "status.Name_Status as Name_Status,"
                     + "shopinfo.Shopname as Shopname, "
                     + "users.Username as Username, "
                     + "warehouse.Name_Whouse as Name_Whouse, "
                     + "service.Name_Service as Name_Service "
                     + "from orders "
                     + "left join status on status.Id_Status = orders.Id_Status "
                     + "left join shopinfo on shopinfo.Id_Shop = orders.Id_Shop "
                     + "left join users on users.Id_User = orders.Id_User "
                     + "left join warehouse on warehouse.Id_Whouse = orders.Id_Whouse "
                     + "left join service on service.Id_Service = orders.Id_Service";
             if(rollNo != null && !rollNo.isEmpty()){
                 sql += " where RollNo like ? ";
             }
             
        try {
           
            statement = conn.prepareStatement(sql);
            if(rollNo != null && !rollNo.isEmpty()){
                 statement.setString(1, rollNo);
             }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Orders od = new Orders(
                        resultSet.getInt("Id_Orders"), 
                        resultSet.getString("RollNo"), 
                        resultSet.getString("Name_Product"), 
                        resultSet.getString("Name_Customer"), 
                        resultSet.getString("Address_Customer"), 
                        resultSet.getString("Mobile_Customer"), 
                        resultSet.getInt("Weight"), 
                        resultSet.getInt("Total_price"), 
                        resultSet.getString("Note")
                );
                
                Status st = new Status(resultSet.getInt("Id_Status"), resultSet.getString("Name_Status"));
                od.setStatus(st);
                
                Shopinfo si = new Shopinfo(resultSet.getInt("Id_Shop"), resultSet.getString("Shopname"));
                od.setShopinfo(si);
                
                Users u = new Users(resultSet.getInt("Id_User"), resultSet.getString("Username"));
                od.setUsers(u);
                
                Warehouse wh = new Warehouse(resultSet.getInt("Id_Whouse"), resultSet.getString("Name_Whouse"));
                od.setWarehouse(wh);
                
                Service sv = new Service(resultSet.getInt("Id_Service"), resultSet.getString("Name_Service"));
                od.setService(sv);
                
                
                
                ordersList.add(od);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShopInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }

        return ordersList;
    }
    
    //delete
    public static void deleteOrders(int Id) {

        openConnection();

        try {
            String sql = "delete from orders where Id_Orders = ? ";
            statement = conn.prepareStatement(sql);

            statement.setInt(1, Id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ShopInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }

    
    public static void insert(Orders o) {
        openConnection();

        try {
            conn = DriverManager.getConnection(Config.BD_URL, Config.USERNAME, Config.PASSWORD);

            String sql = "insert into orders(RollNo, Name_Product, Id_Status, Id_User, Id_Service, Name_Customer, Address_Customer, Mobile_Customer, Id_Whouse, Weight, Delivery_fee, Height, Wide, Length, Total_price, Note, Id_Shop)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

            statement = conn.prepareStatement(sql);
            statement.setString(1, o.getRollNo());
            statement.setString(2, o.getNameProduct());
            statement.setInt(3, o.getStatus().getIdStatus());
            statement.setInt(4, o.getUsers().getIdUser());
            statement.setInt(5, o.getService().getIdService());
            statement.setString(6, o.getNameCustomer());
            statement.setString(7, o.getAddressCustomer());
            statement.setString(8, o.getMobileCustomer());
            statement.setInt(9, o.getWarehouse().getIdWhouse());
            statement.setFloat(10, o.getWeight());
            statement.setInt(11, o.getDeliveryFee());
            statement.setFloat(12, o.getHeight());
            statement.setFloat(13, o.getWide());
            statement.setFloat(14, o.getLength());
            statement.setInt(15, o.getTotalPrice());
            statement.setString(16, o.getNote());
            statement.setInt(17, o.getShopinfo().getIdShop());
            System.out.println(statement);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }

    }
    
    
}
