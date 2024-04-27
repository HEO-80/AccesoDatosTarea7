package com.mycompany.adtarea07;

import com.mycompany.adtarea07.controller.MatriculasController;
import com.mycompany.adtarea07.util.ConnectionBD;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Heo
 */
public class AdTarea07 {

    public static void main(String[] args) {

        try {
            Connection conexion = ConnectionBD.conectar();
            if (conexion != null && !conexion.isClosed()) {
                System.out.println("Conexión establecida correctamente.");
                MatriculasController matriculasController = new MatriculasController(conexion);
                matriculasController.listarMatriculas();
                ConnectionBD.cerrarConexion(conexion);
                System.out.println("Conexión cerrada.");
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al establecer la conexión: " + ex.getMessage());
        }

    }
}
