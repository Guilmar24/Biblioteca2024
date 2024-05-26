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
import modelo.Prestamo;

/**
 *
 * @author kinch
 */
public class PrestamoDAO {
    
    private PreparedStatement preparedStatement = null;
    private String SELECT_FROM_PRESTAMO = "SELECT * FROM prestamos";
    
    public List<Prestamo> leerPrestamo() {
        List<Prestamo> prestamos = new ArrayList<>();
        try {
            preparedStatement = ConectionDB.obtenerConexion().prepareStatement(SELECT_FROM_PRESTAMO);
            preparedStatement.execute();
            preparedStatement.getResultSet();
            while (preparedStatement.getResultSet().next()) {
                Prestamo prestamo = new Prestamo();
                prestamo.setId(preparedStatement.getResultSet().getInt("id"));
                prestamo.setUsuarioId(preparedStatement.getResultSet().getInt("usuario_id"));
                prestamo.setLibroIsbn(preparedStatement.getResultSet().getInt("libro_isbn"));
                prestamo.setFechaPrestamo(preparedStatement.getResultSet().getInt("fecha_prestamo"));
                prestamo.setFechaVencimiento(preparedStatement.getResultSet().getInt("fecha_vencimiento"));
                prestamo.setFechaDevolucion(preparedStatement.getResultSet().getInt("fecha_devolucion"));
                prestamo.setMulta(preparedStatement.getResultSet().getInt("multa"));
                prestamos.add(prestamo);
            }
        } catch (SQLException e) {
        }
        return prestamos;
    }
}
