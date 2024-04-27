package com.mycompany.adtarea07;

/**
 *
 * @author Heo
 */
import com.mycompany.adtarea07.controller.MatriculasController;
import com.mycompany.adtarea07.util.ConnectionBD;
import com.mycompany.adtarea07.vista.VistaMatriculasFrame;
import com.mycompany.adtarea07.componente.ComponenteMatriculas;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class MainController {

    public static void main(String[] args) {
        // Crear una instancia de MainController y llamar al método runApplication()
        MainController mainController = new MainController();
        mainController.runApplication();
    }

    public void runApplication() {
        // Mensaje a mostrar en el cuadro de diálogo
        String mensaje = "¿Qué parte de la aplicación deseas ejecutar?\n"
                + "1. Lógica principal (AdTarea07)\n"
                + "2. Interfaz de usuario (VistaMatriculasFrame)";

        // Mostrar cuadro de diálogo y obtener la opción ingresada por el usuario
        String opcion = JOptionPane.showInputDialog(null, mensaje, "Elegir opción", JOptionPane.QUESTION_MESSAGE);

        // Convertir la opción ingresada a un número entero
        int opcionSeleccionada = Integer.parseInt(opcion);

        // Ejecutar la opción seleccionada
        switch (opcionSeleccionada) {
            case 1:
                ejecutarAdTarea07();
                break;
            case 2:
                ejecutarVistaMatriculasFrame();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }

    }

    private void ejecutarAdTarea07() {
        // Lógica para ejecutar la parte principal de la aplicación (AdTarea07)
        AdTarea07.main(null);
    }

    private void ejecutarVistaMatriculasFrame() {
        try {
            Connection conexion = ConnectionBD.conectar(); // Establecer conexión a la base de datos
            MatriculasController controller = new MatriculasController(conexion);
            VistaMatriculasFrame frame = new VistaMatriculasFrame(controller);
            frame.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar el error adecuadamente
        }
    }

}
