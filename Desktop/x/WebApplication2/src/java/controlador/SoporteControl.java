/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controlador;

import com.services.SoporteServices;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import modelo.Soporte;

/**
 *
 * @author Yeison De Jesus
 */
@ManagedBean
@SessionScoped
public class SoporteControl {

    /**
     * Creates a new instance of SoporteControl
     */
    
    Soporte sp = new Soporte();
    private List<Soporte> sopor = new LinkedList();
    SoporteServices Sv = new SoporteServices();
    public SoporteControl() {
        sopor=Sv.listarProcesos();
    }
    
    
    public void agregar(){
        Sv.almacenar(sp);
        FacesUlti.addInfoMessage("se agrego reporte");
        System.out.println("agregare una queja");
        Sv.almacenar(sp);
        System.out.println("se registró una queja");
        sp= new Soporte();
        obtenerProcesos();
        
        
        
    }
    
    
    public void obtenerProcesos(){
        sopor=Sv.listarProcesos();
    }

    public List<Soporte> getSopor() {
        return sopor;
    }

    public void setSopor(List<Soporte> sopor) {
        this.sopor = sopor;
    }

    public SoporteServices getSv() {
        return Sv;
    }

    public void setSv(SoporteServices Sv) {
        this.Sv = Sv;
    }
    
    

    public Soporte getSp() {
        return sp;
    }
    
    

    public void setSp(Soporte sp) {
        this.sp = sp;
    }
    
}
