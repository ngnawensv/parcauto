/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.mycompany.parcauto.service;

import cm.mycompany.parcauto.Dao.GenericDao;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vivien saa
 * @param <T>
 * @param <ID>
 * @param <D>
 */
public interface GenericService<T extends Object, ID extends Serializable, D extends GenericDao<T, ID>> {

    public T findById(ID id) throws Exception;

    public List<T> findAll() throws Exception;

    public T create(T t) throws Exception;

    public void delete(T t) throws Exception;

    public T update(T t) throws Exception;

    public D getGenericDao();

    public void setGenericDao(D genericDao);

//    public Long countAll() throws Exception;
}
