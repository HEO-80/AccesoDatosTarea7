
package com.mycompany.adtarea07.model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Heo
 */
public class Alumnos {
    
    private String Dni = "";
    private String Nombre = "";
    private String Apellidos = "";
    private String Direccion = "";
    private Date FechaNac  = new Date(0, 0, 0);

    
     public Alumnos(){     
    }
     
    public Alumnos(String dni, String nombre, String Apellidos, String Direccion, Date FechaNac) {
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Dni = Dni;
        this.Direccion = Direccion;
        this.FechaNac = FechaNac;
        
    }

   
    @Override
    public String toString() {
        return "Alumnos{" + "Dni=" + Dni + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", Direccion=" + Direccion + ", FechaNac=" + FechaNac + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.Dni);
        hash = 89 * hash + Objects.hashCode(this.Nombre);
        hash = 89 * hash + Objects.hashCode(this.Apellidos);
        hash = 89 * hash + Objects.hashCode(this.Direccion);
        hash = 89 * hash + Objects.hashCode(this.FechaNac);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumnos other = (Alumnos) obj;
        if (!Objects.equals(this.Dni, other.Dni)) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.Apellidos, other.Apellidos)) {
            return false;
        }
        if (!Objects.equals(this.Direccion, other.Direccion)) {
            return false;
        }
        return Objects.equals(this.FechaNac, other.FechaNac);
    }

    
    
    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public Date getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(Date FechaNac) {
        this.FechaNac = FechaNac;
    }
    
    
    
}
