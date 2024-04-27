
package com.mycompany.adtarea07.util;

/**
 *
 * @author Heo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USUARIO = "adtarea7";
    private static final String CONTRASEÑA = "adtarea7";

    public static Connection conectar() throws SQLException {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
        } catch (SQLException ex) {
            throw new SQLException("Error al conectar a la base de datos: " + ex.getMessage());
        }
        return conexion;
    }

    public static void cerrarConexion(Connection conexion) throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
}
