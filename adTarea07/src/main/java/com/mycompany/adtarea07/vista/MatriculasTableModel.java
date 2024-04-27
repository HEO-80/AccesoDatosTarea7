package com.mycompany.adtarea07.vista;

import com.mycompany.adtarea07.controller.MatriculasController;
import com.mycompany.adtarea07.dao.GestorMatriculasDAO;
import com.mycompany.adtarea07.model.GestorMatriculas;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class MatriculasTableModel extends AbstractTableModel {

    private Vector<GestorMatriculas> datos;
    private JTable tabla;
    private GestorMatriculasDAO matriculas;
    private MatriculasController mat;
    
    public MatriculasTableModel(Vector<GestorMatriculas> datos, JTable tabla) {
        this.datos = datos;
        this.tabla = tabla;
    }
    

    public MatriculasTableModel(MatriculasController mat) {
        this.mat = mat;
        try {
            datos = mat.listarMatriculas();
        } catch (SQLException e) {
            // Maneja el error adecuadamente
        }
    }

    public void updateModel() throws SQLException {
        if (datos != null) {
            datos = mat.listarMatriculas();
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "DNI";
            case 1:
                return "MODULO";
            case 2:
                return "CURSO";
            case 3:
                return "NOTA";
            default:
                return "[no]";

        }
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GestorMatriculas preguntado = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return preguntado.getDni();
            case 1:
                return preguntado.getCurso();
            case 2:
                return preguntado.getNombreModulo();
            case 3:
                return preguntado.getNota();
            default:
                return "";
        }

    }

    private GestorMatriculas getMatriculaSeleccionada() {
        // Obtener el DNI de la matrícula seleccionada en la tabla
        String dni = (String) tabla.getValueAt(tabla.getSelectedRow(), 0);

        // Buscar la matrícula correspondiente en los datos del modelo de la tabla
        for (GestorMatriculas matricula : datos) {
            if (matricula.getDni().equals(dni)) {
                return matricula;
            }
        }

        return null; // Devolver null si no se encuentra la matrícula
    }

    public void setMatriculas(Vector<GestorMatriculas> matriculas) {
        this.datos = matriculas;
        fireTableDataChanged(); // Notificar al modelo que los datos han cambiado
    }
}
