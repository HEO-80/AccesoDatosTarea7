package com.mycompany.adtarea07.controller;

import com.mycompany.adtarea07.dao.GestorMatriculasDAO;
import com.mycompany.adtarea07.model.GestorMatriculas;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Heo
 */
public class MatriculasController {

    private GestorMatriculas gestorMatriculas;
    private GestorMatriculasDAO gestorMatriculasDAO;
    private Connection conexion;

    // Agregar esta variable de clase
    private Vector<GestorMatriculas> matriculas;

    public MatriculasController() {

    }

    public MatriculasController(Connection conexion) {
        this.conexion = conexion;
        this.gestorMatriculasDAO = new GestorMatriculasDAO(conexion); // Inicializar el DAO aquí
    }

    public void seleccionarMatricula(int i) {
        GestorMatriculas gestorMatriculas = gestorMatriculasDAO.seleccionarMatricula(i);
        // Lógica adicional según sea necesario
    }

    public Vector<GestorMatriculas> recargarMatriculasPorDNI(String dni) throws SQLException {
        this.matriculas = gestorMatriculasDAO.recargarMatriculasPorDNI(dni);
        // Lógica adicional según sea necesario
        return this.matriculas;
    }

//
//    public void addMatricula() {
//        // Lógica para agregar una nueva matrícula
//        // Normalmente, esta lógica implicaría interactuar con la vista y luego llamar a GestorMatriculasDao para agregar la matrícula
//        GestorMatriculasDAO gestorMatriculas = new GestorMatriculasDAO(conexion);
//
//        try {
//            // Verificar si los objetos ya existen en la base de datos
//           if(gestorMatriculasDAO.recuperarMatriculas().isEmpty()){
//                // Si no existen matrículas, inicializar y almacenar algunos ejemplos
//                GestorMatriculas matricula1 = new GestorMatriculas();
//                matricula1.setDni("12345678A");
//                matricula1.setNombreModulo("Matemáticas");
//                matricula1.setCurso("2023");
//                matricula1.setNota(8.5);
//
//                GestorMatriculas matricula2 = new GestorMatriculas();
//                matricula2.setDni("98765432B");
//                matricula2.setNombreModulo("Física");
//                matricula2.setCurso("2023");
//                matricula2.setNota(7.2);
//
//                GestorMatriculas matricula3 = new GestorMatriculas();
//                matricula3.setDni("16468454f");
//                matricula3.setNombreModulo("Lenguaje");
//                matricula3.setCurso("2023");
//                matricula3.setNota(6.2);
//
//                GestorMatriculas matricula4 = new GestorMatriculas();
//                matricula4.setDni("45765432B");
//                matricula4.setNombreModulo("Filosofia");
//                matricula4.setCurso("2024");
//                matricula4.setNota(7.4);
//                
//                //("12345678A");
//                GestorMatriculas matricula5 = new GestorMatriculas();
//                matricula5.setDni("12345678A");
//                matricula5.setNombreModulo("Fisica");
//                matricula5.setCurso("2023");
//                matricula5.setNota(8.5);
//                
//                //("12345678A");
//                GestorMatriculas matricula6 = new GestorMatriculas();
//                matricula6.setDni("12345678A");
//                matricula6.setNombreModulo("Filosofia");
//                matricula6.setCurso("2023");
//                matricula6.setNota(8.5);
//                
//                //("12345678A");
//                GestorMatriculas matricula7 = new GestorMatriculas();
//                matricula7.setDni("12345678A");
//                matricula7.setNombreModulo("Lenguaje");
//                matricula7.setCurso("2023");
//                matricula7.setNota(8.5);
//                
//                //"98765432B");
//                GestorMatriculas matricula8 = new GestorMatriculas();
//                matricula8.setDni("98765432B");
//                matricula8.setNombreModulo("Lenguaje");
//                matricula8.setCurso("2023");
//                matricula8.setNota(7.2);
//                
//                //"98765432B");
//                GestorMatriculas matricula9 = new GestorMatriculas();
//                matricula9.setDni("98765432B");
//                matricula9.setNombreModulo("Filosofia");
//                matricula9.setCurso("2023");
//                matricula9.setNota(7.2);
//                
//                //"98765432B");
//                GestorMatriculas matricula10 = new GestorMatriculas();
//                matricula10.setDni("98765432B");
//                matricula10.setNombreModulo("Matematicas");
//                matricula10.setCurso("2023");
//                matricula10.setNota(7.2);
//                  
//                //"16468454f");
//                GestorMatriculas matricula12 = new GestorMatriculas();
//                matricula12.setDni("16468454f");
//                matricula12.setNombreModulo("Fisica");
//                matricula12.setCurso("2023");
//                matricula12.setNota(6.2);
//                
//                //"16468454f");
//                GestorMatriculas matricula13 = new GestorMatriculas();
//                matricula13.setDni("16468454f");
//                matricula13.setNombreModulo("Matematicas");
//                matricula13.setCurso("2023");
//                matricula13.setNota(6.2);
//                
//                //"16468454f");
//                GestorMatriculas matricula14 = new GestorMatriculas();
//                matricula14.setDni("16468454f");
//                matricula14.setNombreModulo("Filosofia");
//                matricula14.setCurso("2023");
//                matricula14.setNota(6.2);
//
//                //"45765432B");
//                GestorMatriculas matricula15 = new GestorMatriculas();
//                matricula15.setDni("45765432B");
//                matricula15.setNombreModulo("Fisica");
//                matricula15.setCurso("2024");
//                matricula15.setNota(8.2);
//                
//                //"45765432B");
//                GestorMatriculas matricula16 = new GestorMatriculas();
//                matricula16.setDni("45765432B");
//                matricula16.setNombreModulo("Lenguaje");
//                matricula16.setCurso("2024");
//                matricula16.setNota(9.2);
//                
//                //"45765432B");
//                GestorMatriculas matricula17 = new GestorMatriculas();
//                matricula17.setDni("45765432B");
//                matricula17.setNombreModulo("Matematicas");
//                matricula17.setCurso("2024");
//                matricula17.setNota(7.2);
//                
//                // Insertar las matrículas en la base de datos
//                gestorMatriculas.insertarMatricula(matricula1);
//                gestorMatriculas.insertarMatricula(matricula2);
//                gestorMatriculas.insertarMatricula(matricula3);
//                gestorMatriculas.insertarMatricula(matricula4);
//                
//                gestorMatriculas.insertarMatricula(matricula5);
//                gestorMatriculas.insertarMatricula(matricula6);
//                gestorMatriculas.insertarMatricula(matricula7);
//                gestorMatriculas.insertarMatricula(matricula8);
//                
//                gestorMatriculas.insertarMatricula(matricula9);
//                gestorMatriculas.insertarMatricula(matricula10);
//                gestorMatriculas.insertarMatricula(matricula12);
//                gestorMatriculas.insertarMatricula(matricula13);
//                
//                gestorMatriculas.insertarMatricula(matricula14);
//                gestorMatriculas.insertarMatricula(matricula15);
//                gestorMatriculas.insertarMatricula(matricula16);
//                gestorMatriculas.insertarMatricula(matricula17);
//
//           }
////                // Mostrar las matrículas recién insertadas en la consola
////                System.out.println("Matrículas recién insertadas:");
////                Vector<GestorMatriculas> matriculas = listarMatriculas();
////                for (GestorMatriculas matricula : matriculas) {
////                    System.out.println(matricula);
////                }
//           
//            
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            // Cerrar recursos si es necesario
//        }
//    }
//    public void cargarMatriculas() {
//        // Lógica para cargar todas las matrículas
//        // Normalmente, esta lógica implicaría interactuar con la vista y luego llamar a GestorMatriculasDao para cargar las matrículas
//    }
    // Métodos adicionales según sea necesario
    // Por ejemplo, métodos para listar matrículas, agregar matrículas, etc.
    // Método para listar todas las matrículas
    public Vector<GestorMatriculas> listarMatriculas() throws SQLException {
        return gestorMatriculasDAO.recuperarMatriculas();
    }

    // Método para agregar una nueva matrícula
    public void agregarMatricula(GestorMatriculas matricula) throws SQLException {
        gestorMatriculasDAO.insertarMatricula(matricula);
    }

    public void updateMatricula(GestorMatriculas matricula) throws SQLException {
        gestorMatriculasDAO.actualizarMatricula(matricula);

    }

    public void eliminarMatricula(String dni) throws SQLException {
        gestorMatriculasDAO.eliminarMatricula(dni);
    }

    public boolean existeMatricula(GestorMatriculas matricula) throws SQLException {
        Vector<GestorMatriculas> matriculasExistentes = recargarMatriculasPorDNI(matricula.getDni());
        for (GestorMatriculas m : matriculasExistentes) {
            if (m.getNombreModulo().equalsIgnoreCase(matricula.getNombreModulo()) && m.getCurso().equalsIgnoreCase(matricula.getCurso())) {
                return true; // Existe una matrícula con el mismo DNI y módulo
            }
        }
        return false;
    }

}
