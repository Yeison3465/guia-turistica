/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controlador;

import com.services.AdminServices;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Soporte;
import modelo.Admin;
import modelo.Turistavisi;

/**
 *
 * @author Yeison De Jesus
 */
@ManagedBean
@SessionScoped
public class TuristaControl1 {

    private String pagina = "";
    private Soporte usuario = new Soporte();
    ClimaControl climacontrol1 = new ClimaControl();
    private Turistavisi turista=new Turistavisi();
    AdminServices Sv = new AdminServices();
    Admin ad1 = new Admin();
    

    public TuristaControl1() {
        pagina = "Menutu.xhtml";
    }


    
    public void adminsmenu() {
        pagina = "/Asoporte/menuad.xhtml";
    }
    
    public void registrase(){
        pagina = "/RC/registu.xhtml";
    }
    
    public void inicios(){
        pagina = "Menutu.xhtml";
    }
    
    public void verproble(){
        pagina= "/RC/proble.xhtml";
    }
    
    public void verusu(){
        pagina="/RC/verusu.xhtml";
    }
    
    
    
    
    public void calificaciones(){
        pagina = "/Asoporte/calificaciones.xhtml";
    }

    public void versitios() {
        
        pagina = "/RC/g.xhtml";
        
    }

    public void retornar() {
        pagina = "/inicial.xhtml";
        
    }

    public void soporte() {
        pagina = "/Asoporte/soporte.xhtml";

    }

    public void admin() {
        pagina = "/Asoporte/admin.xhtml";
    }

    public void guias() {
        pagina = "/RC/guias.xhtml";
        
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public Soporte getUsuario() {
        return usuario;
    }

    public void setUsuario(Soporte usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the turista
     */
    public Turistavisi getTurista() {
        return turista;
    }

    /**
     * @param turista the turista to set
     */
    public void setTurista(Turistavisi turista) {
        this.turista = turista;
    }

}
