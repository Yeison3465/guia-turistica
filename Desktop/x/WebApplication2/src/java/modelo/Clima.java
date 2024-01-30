/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Yeison De Jesus
 */
public class Clima {
    private String ciudad;
    private String descripcionClima;
    private double temperaturaCelsius;

    public Clima(String ciudad, String descripcionClima, double temperaturaCelsius) {
        this.ciudad = ciudad;
        this.descripcionClima = descripcionClima;
        this.temperaturaCelsius = temperaturaCelsius;
    }

    public Clima() {
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDescripcionClima() {
        return descripcionClima;
    }

    public void setDescripcionClima(String descripcionClima) {
        this.descripcionClima = descripcionClima;
    }

    public double getTemperaturaCelsius() {
        return temperaturaCelsius;
    }

    public void setTemperaturaCelsius(double temperaturaCelsius) {
        this.temperaturaCelsius = temperaturaCelsius;
    }
    
    
    
    
}
