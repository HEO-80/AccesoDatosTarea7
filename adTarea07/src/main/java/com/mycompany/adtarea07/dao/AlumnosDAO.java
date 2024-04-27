package com.mycompany.adtarea07.dao;

import com.mycompany.adtarea07.model.Alumnos;
import com.mycompany.adtarea07.model.GestorMatriculas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Heo
 */
public class AlumnosDAO {
    private Connection conexion;

    public AlumnosDAO() {
    }
 
    public Vector<Alumnos> recuperarAlumnos () throws SQLException{
         Vector<Alumnos> alumnos = new Vector();
        
        return alumnos;
        
    }
    
    public void insertarAlumno(Alumnos alumno) throws SQLException{
        String sql = "INSERT INTO ALUMNOS (NOMBRE,APELLIDOS,DNI,DIRECCION,FECHANAC) VALUES (?,?,?,?,?)";
        
        try(PreparedStatement statement = conexion.prepareStatement(sql)){
            statement.setString(1, alumno.getNombre());
            statement.setString(2, alumno.getApellidos());
            statement.setString(3, alumno.getDni());
            statement.setString(4, alumno.getDireccion());
            statement.executeUpdate();
        }
    }
    
    public void actualizarAlumno(Alumnos alumno) throws SQLException{
        String sql = "UPDATE ALUMNOS SET NOMBRE = ?, APELLIDOS = ?, DIRECCION = ? WHERE DNI = ?";
        try(PreparedStatement statement = conexion.prepareStatement(sql)){
            statement.setString(1, alumno.getNombre());
            statement.setString(2, alumno.getApellidos());
            statement.setString(3, alumno.getDireccion());
            statement.setString(4, alumno.getDni());
            statement.executeUpdate();
            
        }
    }
    
    public void eliminarAlumno(String dni) throws SQLException{
        String sql = "DELETE FROM ALUMNOS WHERE DNI = ?";
        try(PreparedStatement statement = conexion.prepareStatement(sql)){
            statement.setString(1, dni);
            statement.executeUpdate();
        }
        
    }
    
    public Vector<Alumnos>  recargarAlumnoPorDni(String Dni) throws SQLException{
        Vector<Alumnos> alumnos = new Vector();
        String sql = "";
        try (PreparedStatement statement = conexion.prepareStatement(sql)){
            try(ResultSet resulSet = statement.executeQuery()){
                Alumnos alumno = new Alumnos();
                alumno.setNombre(resulSet.getString("nombre"));
                alumno.setApellidos(resulSet.getString("apellidos"));
                alumno.setDni(resulSet.getString("dni"));
                alumno.setDireccion(resulSet.getString("direccion"));
                alumno.setFechaNac(resulSet.getDate("fechanac"));
            }
            
        }
        return alumnos;
    }
    
}
