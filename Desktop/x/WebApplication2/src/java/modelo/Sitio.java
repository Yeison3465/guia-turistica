/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Yeison De Jesus
 */
public class Sitio {
    private String nombre;
    private String descripcion;
    private String horadentrada;
    private String horadesalida;
    private double temperatura;
    private String imagen;

    public Sitio() {
    }

    public Sitio(String nombre, String descripcion, String horadentrada, String horadesalida, double temperatura, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horadentrada = horadentrada;
        this.horadesalida = horadesalida;
        this.temperatura = temperatura;
        this.imagen = imagen;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    
    
    

    
    
    



    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHoradentrada() {
        return horadentrada;
    }

    public void setHoradentrada(String horadentrada) {
        this.horadentrada = horadentrada;
    }

    public String getHoradesalida() {
        return horadesalida;
    }

    public void setHoradesalida(String horadesalida) {
        this.horadesalida = horadesalida;
    }

   
    
    
}
