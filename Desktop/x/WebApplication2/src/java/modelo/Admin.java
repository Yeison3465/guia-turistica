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
public class Admin {
    private String usuario;
    private String Contraseña;
    
    
    
    public static Admin load(ResultSet rs) throws SQLException {
        Admin ad = new Admin();
        ad.setUsuario(rs.getString(1));
        ad.setContraseña(rs.getString(2));
        return ad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    
    
    
    
    
}
