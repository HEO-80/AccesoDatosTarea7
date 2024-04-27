package com.mycompany.adtarea07.dao;

import com.mycompany.adtarea07.model.GestorMatriculas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class GestorMatriculasDAO {
    private Connection conexion;

    public  GestorMatriculasDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void insertarMatricula(GestorMatriculas matricula) throws SQLException {
        String sql = "INSERT INTO matriculas (dni, nombremodulo, curso, nota) VALUES (?, ?, ?, ?)";
        //insert into matriculas(DNI, NombreModulo, Curso, Nota) values ('23456789B', 'Bases de datos', '21-22', 5.0);
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, matricula.getDni());
            statement.setString(2, matricula.getNombreModulo());
            statement.setString(3, matricula.getCurso());
            statement.setDouble(4, matricula.getNota());
            statement.executeUpdate();
        }
    }

    public void actualizarMatricula(GestorMatriculas matricula) throws SQLException {
        String sql = "UPDATE matriculas SET nombremodulo = ?, curso = ?, nota = ? WHERE dni = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, matricula.getNombreModulo());
            statement.setString(2, matricula.getCurso());
            statement.setDouble(3, matricula.getNota());
            statement.setString(4, matricula.getDni());
            statement.executeUpdate();
        }
    }

    public void eliminarMatricula(String dni) throws SQLException {
        String sql = "DELETE FROM matriculas WHERE dni = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, dni);
            statement.executeUpdate();
        }
    }

    public Vector<GestorMatriculas> recuperarMatriculas() throws SQLException {
        Vector<GestorMatriculas> matriculas = new Vector<>();
        String sql = "SELECT dni, nombremodulo, curso, nota FROM matriculas";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    GestorMatriculas matricula = new GestorMatriculas();
                    matricula.setDni(resultSet.getString("dni"));
                    matricula.setNombreModulo(resultSet.getString("nombremodulo"));
                    matricula.setCurso(resultSet.getString("curso"));
                    matricula.setNota(resultSet.getDouble("nota"));
                    matriculas.add(matricula);
                }
                System.out.println("Matriculas" + matriculas);
            }
        }
        return matriculas;
    }

    public GestorMatriculas seleccionarMatricula(int i) {
        // Lógica para seleccionar la matrícula número i desde la base de datos
        // y devolverla como un objeto de tipo Matricula
        return null; // Devuelve null como ejemplo, debes implementar la lógica de acceso a la base de datos
    }

    public Vector<GestorMatriculas> recargarMatriculasPorDNI(String dni) throws SQLException {
        Vector<GestorMatriculas> matriculas = new Vector<>();
        String sql = "SELECT dni, nombremodulo, curso, nota FROM matriculas WHERE dni = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, dni);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    GestorMatriculas matricula = new GestorMatriculas();
                    matricula.setDni(resultSet.getString("dni"));
                    matricula.setNombreModulo(resultSet.getString("nombremodulo"));
                    matricula.setCurso(resultSet.getString("curso"));
                    matricula.setNota(resultSet.getDouble("nota"));
                    matriculas.add(matricula);
                }
            }
        }
        return matriculas;
    }

//    public void addMatricula(GestorMatriculas matricula) throws SQLException {
//        insertarMatricula(matricula); 
//        
//       
//    
//    }
}
