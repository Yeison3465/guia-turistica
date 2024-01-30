/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.impldao;
import modelo.Admin;
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

/**
 *
 * @author Yeison De Jesus
 */
public class ImpldaoAdmin implements IDao<Admin>{
    private DataSource dataSource = DataUtil.getDs();

    public void create(Admin admin) {
        PreparedStatement pst = null;
        try {
            pst = dataSource.getConnection().prepareStatement("Insert Into adminis values(?,?)");
            pst.setString(1, admin.getUsuario());
            pst.setString(2, admin.getContraseña());
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
    public Admin select(String c) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        Admin admin = null;
        try {
            pst = dataSource.getConnection().prepareStatement("select * from adminis where usuario = ?");
            pst.setString(1, c);
            rs = pst.executeQuery();
            while (rs.next()) {
                admin = Admin.load(rs);
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
            return admin;
        }
    }

    @Override
    public List<Admin> selectAll() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        List<Admin> listaproblema = new LinkedList();
        try {
            pst = dataSource.getConnection().prepareStatement("select * from adminis ");
            rs = pst.executeQuery();
            while (rs.next()) {
                listaproblema.add(Admin.load(rs));
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
            pst = dataSource.getConnection().prepareStatement("delete from adminis where usuario = ?");
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
     public Admin consultar(String l,String p) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        Admin usuario = null;
        try {
            pst = dataSource.getConnection().prepareStatement("select * from adminis where usuario = ? and contraseña = ?");
            pst.setString(1, l);
            pst.setString(2, p);
            rs = pst.executeQuery();
            while (rs.next()) {
                usuario = Admin.load(rs);
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
    public void modificar(Admin entity) {
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
