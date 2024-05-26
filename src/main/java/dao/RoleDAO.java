/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conection.ConectionDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Role;

/**
 *
 * @author kinch
 */
public class RoleDAO {

    private PreparedStatement preparedStatement = null;
    private final String SELECT_FROM_ROLES = "SELECT * FROM roles";

    public List<Role> leerRoles() {
        List<Role> listaRole = new ArrayList<>();
        try {
            preparedStatement = ConectionDB.obtenerConexion().prepareStatement(SELECT_FROM_ROLES);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getInt("id"));
                role.setNombre(resultSet.getString("nombre"));
                listaRole.add(role);
            }
        } catch (SQLException e) {
        }
        return listaRole;
    }
}
