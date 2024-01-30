/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.services;

import com.impldao.ImpldaoAdmin;
import java.util.List;
import modelo.Admin;

/**
 *
 * @author Yeison De Jesus
 */
public class AdminServices {
    ImpldaoAdmin idpro=new ImpldaoAdmin();
    
    public Admin consultar(String l, String p) {
        Admin usu = idpro.consultar(l, p);
        return usu;
    }
    
    public void almacenar(Admin p){
        idpro.create(p);
    }
    public Admin consultar(String c){
        Admin pro=idpro.select(c);
        return pro;
    }
    public List<Admin> listarProcesos(){
        return idpro.selectAll();
    }
    
    public void eliminar(Admin p){
        idpro.delete(p.getUsuario());
    }
}
