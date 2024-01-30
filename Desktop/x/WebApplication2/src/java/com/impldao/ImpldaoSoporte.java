/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impldao;

import com.dao.DataUtil;
import com.dao.IDao;
import modelo.Soporte;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author Usuario
 */
public class ImpldaoSoporte implements IDao<Soporte> {

    private DataSource dataSource = DataUtil.getDs();

    @Override
    public void create(Soporte soporte) {
        PreparedStatement pst = null;
        try {
            pst = dataSource.getConnection().prepareStatement("Insert Into sopor values(?,?,?)");
            pst.setString(1, soporte.getNombre());
            pst.setString(2, soporte.getApellido());
            pst.setString(3, soporte.getDescripcion());
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
    public Soporte select(String c) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        Soporte proceso = null;
        try {
            pst = dataSource.getConnection().prepareStatement("select * from sopor where nombre = ?");
            pst.setString(1, c);
            rs = pst.executeQuery();
            while (rs.next()) {
                proceso = Soporte.load(rs);
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
    public List<Soporte> selectAll() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        List<Soporte> listaproblema = new LinkedList();
        try {
            pst = dataSource.getConnection().prepareStatement("select * from sopor ");
            rs = pst.executeQuery();
            while (rs.next()) {
                listaproblema.add(Soporte.load(rs));
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
            pst = dataSource.getConnection().prepareStatement("delete from sopor where codigo = ?");
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

    @Override
    public void modificar(Soporte entity) {
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
