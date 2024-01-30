/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controlador;

import com.services.TuristavisiServices;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Admin;

import modelo.Soporte;

import modelo.Turistavisi;

/**
 *
 * @author Yeison De Jesus
 */
@ManagedBean
@SessionScoped
public class TuristavisiControl {

    /**
     * Creates a new instance of TuristavisiControl
     */
    Turistavisi tv = new Turistavisi();
    TuristavisiServices Sv1 = new TuristavisiServices();
    private List<Turistavisi> tt = new LinkedList();
    @ManagedProperty("#{turistaControl1}")
    private TuristaControl1 control;
    private boolean mostPinicio = true;

    public TuristavisiControl() {
        tt = Sv1.listarProcesos();
    }

    public void agregarT() {
        // Verificar si el usuario ya existe
        Turistavisi usuarioExistente = Sv1.consultar(tv.getUsuario(), tv.getContraseña());

        if (usuarioExistente != null) {
            // Mostrar mensaje indicando que el usuario ya existe
            System.out.println("El usuario ya existe en la base de datos");
            // Aquí podrías lanzar un mensaje a tu interfaz o realizar alguna acción
        } else {
            // Si el usuario no existe, se procede a almacenarlo en la base de datos
            Sv1.almacenar(tv);
            System.out.println("Usuario registrado exitosamente");
            tv = new Turistavisi();
            control.inicios();
            obtenerturista();
            FacesUlti.addInfoMessage("Registro completado");
        }

    }

    public void validarUsuario2() {
        Turistavisi usuarioValidado = Sv1.consultar(tv.getUsuario(), tv.getContraseña());

        if (usuarioValidado != null) {
            control.setTurista(usuarioValidado);
            control.retornar();
            mostPinicio = false;
            // Lógica para redirigir a la página deseada después del inicio de sesión
        } else {
            
            FacesUlti.addErrorMessage("Datos Ingresado Erroneos");
        }
    }

    public void cerrar() {
        mostPinicio = true;
        control.inicios();
    }

    public void obtenerturista() {
        tt = Sv1.listarProcesos();
    }

    public boolean isMostPinicio() {
        return mostPinicio;
    }

    public void setMostPinicio(boolean mostPinicio) {
        this.mostPinicio = mostPinicio;
    }

    public TuristavisiServices getSv1() {
        return Sv1;
    }

    public void setSv1(TuristavisiServices Sv1) {
        this.Sv1 = Sv1;
    }

    public List<Turistavisi> getTt() {
        return tt;
    }

    public void setTt(List<Turistavisi> tt) {
        this.tt = tt;
    }

    public TuristavisiServices getSv() {
        return Sv1;
    }

    public void setSv(TuristavisiServices Sv) {
        this.Sv1 = Sv;
    }

    public TuristaControl1 getControl() {
        return control;
    }

    public void setControl(TuristaControl1 control) {
        this.control = control;
    }

    public Turistavisi getTv() {
        return tv;
    }

    public void setTv(Turistavisi tv) {
        this.tv = tv;
    }

}
