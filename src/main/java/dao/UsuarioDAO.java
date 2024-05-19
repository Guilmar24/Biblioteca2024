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
        public boolean guardarUsuario(Usuario usuario) {
        try {
            preparedStatement = ConectionDB.obtenerConexion().prepareStatement(INSERT_INTO_USUARIOS);
            preparedStatement.setString(1, usuario.getNombre();
            preparedStatement.setString(2, libro.getTitulo());
            preparedStatement.setString(3, libro.getAutor());
            preparedStatement.setString(4, libro.getEditorial());
            preparedStatement.setString(5, libro.getAnioPublicacion());
            preparedStatement.setInt(6, libro.getCantidadDisponible());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
