/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import java.util.List;
import Module.Shopinfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bun
 */
public class ShopInfoDAO extends BaseDAO {

    public static List<Shopinfo> getShopList(String nameS) {
        List<Shopinfo> shopList = new ArrayList<>();

        openConnection();
             String sql = "select * from shopinfo";
             if(nameS != null && !nameS.isEmpty()){
                 sql += " where Shopname like ? ";
             }
             
        try {
           
            statement = conn.prepareStatement(sql);
            if(nameS != null && !nameS.isEmpty()){
                 statement.setString(1, nameS);
             }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Shopinfo s = new Shopinfo(
                        resultSet.getInt("Id_Shop"),
                        resultSet.getString("Shopname"),
                        resultSet.getString("ShopPhone"),
                        resultSet.getString("Address"),
                        resultSet.getString("Email")
                );
                shopList.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShopInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }

        return shopList;
    }

    public static void insertShop(Shopinfo si) {

        openConnection();

        try {
            String sql = "insert into shopinfo(Shopname, ShopPhone, Address, Email)value(?,?,?,?)";
            statement = conn.prepareStatement(sql);

            statement.setString(1, si.getShopname());
            statement.setString(2, si.getShopPhone());
            statement.setString(3, si.getAddress());
            statement.setString(4, si.getEmail());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ShopInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }

    }

    public static void updateShop(Shopinfo si) {

        openConnection();

        try {
            String sql = "update shopinfo set Shopname = ?, ShopPhone = ?, Address = ?, Email = ? where Id_Shop = ? ";
            statement = conn.prepareStatement(sql);

            statement.setString(1, si.getShopname());
            statement.setString(2, si.getShopPhone());
            statement.setString(3, si.getAddress());
            statement.setString(4, si.getEmail());
            statement.setInt(5, si.getIdShop());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ShopInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }

    public static void deleteShop(int Id) {

        openConnection();

        try {
            String sql = "delete from shopinfo where Id_Shop = ? ";
            statement = conn.prepareStatement(sql);

            statement.setInt(1, Id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ShopInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
    }
}
