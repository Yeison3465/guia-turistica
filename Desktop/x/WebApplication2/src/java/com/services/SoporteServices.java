/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.services;

import com.impldao.ImpldaoSoporte;
import modelo.Soporte;
import java.util.List;

/**
 *
 * @author JCMM
 */
public class SoporteServices {
        ImpldaoSoporte idpro=new ImpldaoSoporte();
    
    public void almacenar(Soporte p){
        idpro.create(p);
    }
    public Soporte consultar(String c){
        Soporte pro=idpro.select(c);
        return pro;
    }
    public List<Soporte> listarProcesos(){
        return idpro.selectAll();
    }
    
    public void eliminar(Soporte p){
        idpro.delete(p.getNombre());
    }
    
}
