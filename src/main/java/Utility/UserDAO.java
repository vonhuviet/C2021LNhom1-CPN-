/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import java.util.List;
import Module.Users;
import Connect.Config;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bun
 */
public class UserDAO extends BaseDAO {

    // select Users
    public static List<Users> getUserList() {
        List<Users> dataList = new ArrayList<>();

        openConnection();

        try {
            String sql = "select * from users";
            statement = conn.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Users u = new Users(
                        resultSet.getInt("Id_User"),
                        resultSet.getString("Username"),
                        resultSet.getString("Password"),
                        resultSet.getInt("Id_Role"),
                        resultSet.getInt("Active"),
                        resultSet.getString("Mobile"),
                        resultSet.getString("Address"),
                        resultSet.getString("Fullname"),
                        resultSet.getString("Email")
                );
                dataList.add(u);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return dataList;
    }

    //Login
    public static Users login(String username, String password) {
        Users u = null;
        openConnection();
        try {

            String sql = "select * from `users` where username = ? and password = ? ";
            statement = conn.prepareStatement(sql);

            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                u = new Users(
                        resultSet.getInt("Id_User"),
                        resultSet.getString("Username"),
                        resultSet.getString("Password"),
                        resultSet.getInt("Id_Role"),
                        resultSet.getInt("Active"),
                        resultSet.getString("Mobile"),
                        resultSet.getString("Address"),
                        resultSet.getString("Fullname"),
                        resultSet.getString("Email")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return u;
    }

    public static void Save(Users u) {
        if (u.getIdUser() > 0) {
            update(u);
        } else {
            insert(u);
        }

    }

    // insert Users
    public static void insert(Users u) {
        openConnection();

        try {
            conn = DriverManager.getConnection(Config.BD_URL, Config.USERNAME, Config.PASSWORD);

            String sql = "insert into users(Username, Password, Id_Role, Active, Mobile, Address, Fullname, Email)"
                    + "values (?,?,?,?,?,?,?,?) ";

            statement = conn.prepareStatement(sql);
            
            statement.setString(1, u.getUsername());
            statement.setString(2, u.getPassword());
            statement.setInt(3, u.getIdRole());
            statement.setInt(4, u.getActive());
            statement.setString(5, u.getMobile());
            statement.setString(6, u.getAddress());
            statement.setString(7, u.getFullname());
            statement.setString(8, u.getEmail());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }

    }

    //Update 
    public static void update(Users u) {
        openConnection();

        try {
            conn = DriverManager.getConnection(Config.BD_URL, Config.USERNAME, Config.PASSWORD);

            String sql = "update users set Username = ?, Password = ?, Id_Role = ?, Active = ?, "
                    + "Mobile = ?, Address = ?, Fullname = ?, Email = ? where Id_User = ? ";

            statement = conn.prepareStatement(sql);

            statement.setString(1, u.getUsername());
            statement.setString(2, u.getPassword());
            statement.setInt(3, u.getIdRole());
            statement.setInt(4, u.getActive());
            statement.setString(5, u.getMobile());
            statement.setString(6, u.getAddress());
            statement.setString(7, u.getFullname());
            statement.setString(8, u.getEmail());

            statement.setInt(9, u.getIdUser());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }

    }

    //Delete 
    public static void deleteID(int Id) {
        openConnection();

        try {
            conn = DriverManager.getConnection(Config.BD_URL, Config.USERNAME, Config.PASSWORD);

            String sql = "delete from users where Id_User = ? ";

            statement = conn.prepareStatement(sql);

            statement.setInt(1, Id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }

    }

}
