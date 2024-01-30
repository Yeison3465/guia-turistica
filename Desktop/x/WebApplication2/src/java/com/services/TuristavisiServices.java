/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.services;

import com.dao.DataUtil;
import com.dao.IDao;
import com.impldao.ImpldaoSoporte;
import com.impldao.ImpldaoTuristavisi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import modelo.Turistavisi;
import modelo.Turistavisi;

/**
 *
 * @author Yeison De Jesus
 */
public class TuristavisiServices {
    ImpldaoTuristavisi idpro=new ImpldaoTuristavisi();
    
    public Turistavisi consultar(String l, String p) {
        Turistavisi usu1 = idpro.consultar(l, p);
        return usu1;
    }
    
    public void almacenar(Turistavisi p){
        idpro.create(p);
    }
    public Turistavisi consultar(String c){
        Turistavisi pro=idpro.select(c);
        return pro;
    }
    public List<Turistavisi> listarProcesos(){
        return idpro.selectAll();
    }
    
    public void eliminar(Turistavisi p){
        idpro.delete(p.getUsuario());
    }
}
