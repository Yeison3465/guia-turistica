/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controlador;

import com.services.AdminServices;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Admin;
import modelo.Soporte;
import javax.faces.context.FacesContext;
import java.io.IOException;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Yeison De Jesus
 */
@ManagedBean
@SessionScoped
public class AdminControl {

    /**
     * Creates a new instance of AdminControl
     */
    
    private Admin ad1 = new Admin();
    private AdminServices Sv = new AdminServices();
    @ManagedProperty("#{turistaControl1}")
    private TuristaControl1 control;
    private boolean mostPinicio = true;

    public TuristaControl1 getControl() {
        return control;
    }

    public void setControl(TuristaControl1 control) {
        this.control = control;
    }
    
    public AdminControl() {
    }
    
    public void validarUsuario() {
        Admin usuarioValidado = Sv.consultar(ad1.getUsuario(), ad1.getContraseña());

        if (usuarioValidado != null) {
            control.adminsmenu();
            // Lógica para redirigir a la página deseada después del inicio de sesión
        } else {
            FacesUlti.addErrorMessage("Datos Ingresado Erroneos");
        }
    }
    
    public void cerrar(){
        mostPinicio = true;
        control.inicios();
    }

    public boolean isMostPinicio() {
        return mostPinicio;
    }

    public void setMostPinicio(boolean mostPinicio) {
        this.mostPinicio = mostPinicio;
    }
    
    





    public Admin getAd1() {
        return ad1;
    }

    public void setAd1(Admin ad1) {
        this.ad1 = ad1;
    }

    public AdminServices getSv() {
        return Sv;
    }

    public void setSv(AdminServices Sv) {
        this.Sv = Sv;
    }
    
    
    
    
}
