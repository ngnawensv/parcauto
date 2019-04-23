/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.mycompany.parcauto.serviceImpl;

import cm.mycompany.parcauto.Dao.GenericDao;
import cm.mycompany.parcauto.service.GenericService;
import java.io.Serializable;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vvs@uni2grow
 * @param <T>
 * @param <ID>
 * @param <D>
 */
public abstract class GenericServiceImpl<T extends Object, ID extends Serializable, D extends GenericDao<T, ID>>
        implements GenericService<T, ID, D> {

    Class<T> entityClass;
    protected D genericDao;

    public GenericServiceImpl(D genericDao) {
        this.genericDao = genericDao;
    }

    @Override
    public D getGenericDao() {
        return genericDao;
    }

    @Override
    public void setGenericDao(D genericDao) {
        this.genericDao = genericDao;
    }

    @Override
    public T findById(ID id) throws Exception {
        try {
            return genericDao.findById(id);
        } catch (Exception e) {
            Logger.getLogger(GenericServiceImpl.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            throw new Exception("unable to find entity " + entityClass.getName(), e);
        }
    }

    @Override
    public List<T> findAll() throws Exception {
        try {
            return genericDao.findAll();
        } catch (Exception e) {
            Logger.getLogger(GenericServiceImpl.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            throw new Exception("unable to find All " + entityClass.getName(), e);
        }
    }

    @Override
    @Transactional
    public T create(T t) throws Exception {
        try {
            return genericDao.create(t);
        } catch (Exception e) {
            Logger.getLogger(GenericServiceImpl.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            throw new Exception("unable to create a " + entityClass.getName(), e);
        }
    }

    @Override
    @Transactional
    public void delete(T t) throws Exception {
        try {
            genericDao.delete(t);
        } catch (Exception e) {
            Logger.getLogger(GenericServiceImpl.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            throw new Exception("unable to delete a " + entityClass.getName(), e);
        }
    }

    @Override
    @Transactional
    public T update(T t) throws Exception {
        try {
            return genericDao.update(t);
        } catch (Exception e) {
            Logger.getLogger(GenericServiceImpl.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            throw new Exception("unable to update a" + entityClass.getName(), e);
        }
    }

//	@Override
//	public Long countAll() throws Exception {
//		return genericDao.countAll();
//	}
}
