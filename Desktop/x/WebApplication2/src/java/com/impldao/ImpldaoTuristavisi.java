/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.impldao;

import com.dao.DataUtil;
import com.dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import modelo.Turistavisi;

/**
 *
 * @author Yeison De Jesus
 */
public class ImpldaoTuristavisi implements IDao<Turistavisi>{
    private DataSource dataSource = DataUtil.getDs();

    @Override
    public void create(Turistavisi soporte) {
        PreparedStatement pst = null;
        try {
            pst = dataSource.getConnection().prepareStatement("Insert Into turista values(?,?,?,?,?)");
            pst.setString(1, soporte.getNombre());
            pst.setString(2, soporte.getApellido());
            pst.setString(3, soporte.getPais());
            pst.setString(4, soporte.getUsuario());
            pst.setString(5, soporte.getContraseña());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSoporte.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Turistavisi select(String c) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        Turistavisi proceso = null;
        try {
            pst = dataSource.getConnection().prepareStatement("select * from turista where usuario = ?");
            pst.setString(1, c);
            rs = pst.executeQuery();
            while (rs.next()) {
                proceso = Turistavisi.load(rs);
            }
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSoporte.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSoporte.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return proceso;
        }
    }

    @Override
    public List<Turistavisi> selectAll() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        List<Turistavisi> listaproblema = new LinkedList();
        try {
            pst = dataSource.getConnection().prepareStatement("select * from turista ");
            rs = pst.executeQuery();
            while (rs.next()) {
                listaproblema.add(Turistavisi.load(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImpldaoSoporte.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSoporte.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSoporte.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listaproblema;
    }

    @Override
    public void delete(String cod) {
        PreparedStatement pst = null;
        try {
            pst = dataSource.getConnection().prepareStatement("delete from turista where codigo = ?");
            pst.setString(1, cod);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Logger.getLogger(ImpldaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoSoporte.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public Turistavisi consultar(String l,String p) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        Turistavisi usuario = null;
        try {
            pst = dataSource.getConnection().prepareStatement("select * from turista where usuario = ? and contraseña = ?");
            pst.setString(1, l);
            pst.setString(2, p);
            rs = pst.executeQuery();
            while (rs.next()) {
                usuario = Turistavisi.load(rs);
            }
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ImpldaoAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return usuario;
        }
    }

    @Override
    public void modificar(Turistavisi entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setDataSource(DataSource ds) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the dataSource
     */
    public DataSource getDataSource() {
        return dataSource;
    }
}
