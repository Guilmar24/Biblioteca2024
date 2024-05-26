/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conection.ConectionDB;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

/**
 *
 * @author kinch
 */
public class UsuarioDAO {

    private PreparedStatement preparedStatement = null;
    private final String SELECT_FROM_USUARIOS = "SELECT * FROM usuarios";
    private final String INSERT_INTO_USUARIOS = "INSERT INTO usuarios (nombre, apellido, direccion, telefono, username, password, rol_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String DELETE_FROM_USUARIOS = "DELETE FROM usuarios WHERE id = ?";
    private final String UPDATE_USUARIOS = "UPDATE usuario SET id = ?, nombre = ?, apellido = ?, direccion = ?, telefono = ?, username = ?, password = ?";

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            preparedStatement = ConectionDB.obtenerConexion().prepareStatement(SELECT_FROM_USUARIOS);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setApellido(resultSet.getString("apellido"));
                usuario.setDireccion(resultSet.getString("direccion"));
                usuario.setTelefono(resultSet.getNString("telefono"));
                usuario.setUsername(resultSet.getString("email"));
                usuario.setPassword(resultSet.getString("password"));
                usuario.setIdRole(resultSet.getInt("rol_id"));
                usuarios.add(usuario);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public boolean guardarUsuarios(Usuario usuario) {
        try {
            preparedStatement = ConectionDB.obtenerConexion().prepareStatement(INSERT_INTO_USUARIOS);
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getApellido());
            preparedStatement.setString(3, usuario.getDireccion());
            preparedStatement.setString(4, usuario.getTelefono());
            preparedStatement.setString(5, usuario.getUsername());
            preparedStatement.setString(6, usuario.getPassword());
            preparedStatement.setInt(7, usuario.getIdRole());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarUsuarios(int id) {
        try {
            preparedStatement = ConectionDB.obtenerConexion().prepareStatement(DELETE_FROM_USUARIOS);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }        

    

    public boolean actualizarUsuario(Usuario usuario) {
        try {
            preparedStatement = ConectionDB.obtenerConexion().prepareStatement(UPDATE_USUARIOS);
            preparedStatement.setInt(1, usuario.getId());
            preparedStatement.setString(2, usuario.getNombre());
            preparedStatement.setString(3, usuario.getApellido());
            preparedStatement.setString(4, usuario.getDireccion());
            preparedStatement.setString(5, usuario.getTelefono());
            preparedStatement.setString(6, usuario.getUsername());
            preparedStatement.setString(7, usuario.getPassword());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

