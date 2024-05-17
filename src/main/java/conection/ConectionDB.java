/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author kinch
 */
public class ConectionDB {
    private static final String NOMBRE_BASE_DE_DATOS = "guilmarprogra";
    private static final String URL_CONEXION = "jdbc:postgresql:// guilmarpogra.postgres.database.azure.com:5432/" + NOMBRE_BASE_DE_DATOS;
    private static final String USERNAME_DBA = "guilmar2024";
    private static final String PASSWROD_DBA = "$Hello2024";

    public static Connection obtenerConexion () {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL_CONEXION, USERNAME_DBA, PASSWROD_DBA);
            System.out.println("Conexión realizada con exito");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
