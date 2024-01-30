/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Yeison De Jesus
 */
public class Turistavisi {
    private String Nombre;
    private String Apellido;
    private String Pais;
    private String Usuario;
    private String Contraseña;

    public Turistavisi() {
    }

    public Turistavisi(String Nombre, String Apellido, String Pais, String Usuario, String Contraseña) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Pais = Pais;
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
    }
    
    public static Turistavisi load(ResultSet rs) throws SQLException {
        Turistavisi pro = new Turistavisi();
        pro.setNombre(rs.getString(1));
        pro.setApellido(rs.getString(2));
        pro.setPais(rs.getString(3));
        pro.setUsuario(rs.getString(4));
        pro.setContraseña(rs.getString(5));
        return pro;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    
    
}
