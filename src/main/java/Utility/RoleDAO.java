/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import Module.*;
import static Utility.BaseDAO.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Bun
 */
public class RoleDAO {
    public static List<Role> getRoleList() {
        List<Role> roleList = new ArrayList<>();

        openConnection();

        try {
            String sql = "select * from role";
            statement = conn.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Role rl = new Role(
                        resultSet.getInt("Id_Role"), 
                        resultSet.getString("Name_Role")     
                );
                roleList.add(rl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return roleList;
    }
}
