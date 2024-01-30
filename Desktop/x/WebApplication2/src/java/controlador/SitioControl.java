/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controlador;

import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modelo.Sitio;

/**
 *
 * @author Yeison De Jesus
 */
@ManagedBean
@SessionScoped
public class SitioControl {

    /**
     * Creates a new instance of SitioControl
     */
    
    Sitio sitio = new Sitio();
    private List<Sitio> sitios = new LinkedList();
    
    public SitioControl() {
    }
    
    

    public Sitio getSitio() {
        return sitio;
    }

    public void setSitio(Sitio sitio) {
        this.sitio = sitio;
    }

    public List<Sitio> getSitios() {
        return sitios;
    }

    public void setSitios(List<Sitio> sitios) {
        this.sitios = sitios;
    }
    
}
