package com.mycompany.adtarea07.componente;

/**
 *
 * @author Heo
 */
import com.mycompany.adtarea07.controller.MatriculasController;
import com.mycompany.adtarea07.model.GestorMatriculas;
import com.mycompany.adtarea07.util.ConnectionBD;
import com.mycompany.adtarea07.vista.MatriculasTableModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public class ComponenteMatriculas {

    
    private Vector<GestorMatriculas> matriculas; // Vector interno para mantener la información de las matrículas
    private Connection conexion; // Conexión a la base de datos
    private MatriculasController controller;
    private MatriculasTableModel model;

    public ComponenteMatriculas() throws SQLException {
        this.conexion = ConnectionBD.conectar();
        this.controller = new MatriculasController(conexion); // Inicializa el controlador
        
        // Inicializa el vector de matrículas
        this.matriculas = new Vector<>();
        
//        cargarMatriculas(); // Cargar todas las matrículas al inicializar el componente
    }

//    public Vector<GestorMatriculas> cargarMatriculas() {
//        try {
//            this.matriculas = controller.listarMatriculas();
//            return this.matriculas;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Manejar el error adecuadamente
//            return new Vector<>(); // Devuelve un vector vacío en caso de error
//        }
//    }

    // Método para seleccionar una matrícula por su posición en el vector interno
    public GestorMatriculas seleccionarFila(int i) {
        if (i >= 0 && i < matriculas.size()) {
            return matriculas.get(i);
        }
        return null; // Devuelve null si la posición está fuera del rango válido
    }

    // Método para recargar la estructura interna del componente con las matrículas de un DNI específico
    public void recargarDNI(String dni) throws SQLException {
        MatriculasController controller = new MatriculasController(conexion);

        this.matriculas = controller.recargarMatriculasPorDNI(dni);
        //Vector<GestorMatriculas> matriculas = controller.listarMatriculas();
    }

//    public void recargarDNI(String dni) throws SQLException {
//    MatriculasController controller = new MatriculasController(conexion);
//    this.matriculas = controller.recargarMatriculasPorDNI(dni);
//}
    // Método para agregar una nueva matrícula a la base de datos y actualizar el vector interno
    public void addMatricula(GestorMatriculas matricula) throws SQLException {
        MatriculasController controller = new MatriculasController(conexion);
        controller.agregarMatricula(matricula);
        // Actualizar el vector interno después de agregar la matrícula
        this.matriculas = controller.listarMatriculas();
    }
}
