/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author admin
 */
public interface IDao<T>{
    
  void setDataSource(DataSource ds);

  void create(T entity);

  T select(String id);
  
  List<T> selectAll();

  void delete(String id);

  void modificar(T entity);
  
}
