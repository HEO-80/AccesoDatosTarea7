package com.mycompany.adtarea07.model;

/**
 *
 * @author Heo
 */
import java.util.EventObject;

// Clase principal del componente de gestión de matrículas
public class GestorMatriculas {

    // Propiedades para almacenar la información de la matrícula
    private String dni;
    private String nombreModulo;
    private String curso;
    private double nota;

    
    // Constructor por defecto
    public GestorMatriculas() {
        // Inicializa las propiedades con valores por defecto o vacíos
        dni = "";
        nombreModulo = "";
        curso = "";
        nota = 0.0;
    }

    // Métodos para acceder y modificar la información de la matrícula
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreModulo() {
        return nombreModulo;
    }

    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    // Clase para representar un evento de cambio de modo
    class CambioModoEvent extends EventObject {

        public CambioModoEvent(Object source) {
            super(source);
        }
    }
    
    

//    // Método para seleccionar una fila específica
//    public void seleccionarFila(int i) {
//        // Lógica para seleccionar la fila número i
//        // Aquí puedes acceder a los datos de la fila desde la base de datos y asignarlos a las propiedades
//    }
//
//    // Método para recargar la estructura interna del componente con las matrículas de un DNI en particular
//    public void recargarDNI() {
//        // Lógica para recargar la información de las matrículas para un DNI específico
//    }
//
//    // Método para añadir un registro nuevo a la base de datos con la información almacenada en las propiedades del componente
//    public void addMatricula() {
//        // Lógica para agregar un nuevo registro a la base de datos utilizando los valores de las propiedades
//    }
//
//    // Método para lanzar el evento de cambio de modo cuando se cargan todas las matrículas
//    public void cargarMatriculas() {
//        // Lógica para cargar todas las matrículas desde la base de datos
//        // Después de cargar las matrículas, lanza el evento de cambio de modo
//        fireCambioModoEvent();
//    }
//
//    // Método para lanzar el evento de cambio de modo
//    private void fireCambioModoEvent() {
//        CambioModoEvent event = new CambioModoEvent(this);
//        // Aquí deberías notificar a los listeners que se ha producido un cambio de modo
//    }

    @Override
    public String toString() {
        return "\n \n GestorMatriculas{" + "dni =" + dni + ",\n nombreModulo =" + nombreModulo + ",\n curso =" + curso + ",\n nota =" + nota + '}';
    }
}
