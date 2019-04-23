/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.mycompany.parcauto.Dao;

import cm.mycompany.parcauto.entities.User;

/**
 *
 * @author vivien saa
 */
public interface UserDao extends GenericDao<User, Long> {

    public User findUserByUserName(String userName) throws Exception;
}
