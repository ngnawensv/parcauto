/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.mycompany.parcauto.serviceImpl;

import cm.mycompany.parcauto.Dao.UserDao;
import cm.mycompany.parcauto.entities.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import cm.mycompany.parcauto.service.UserService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivien saa
 */
@Transactional
public class UserServiceImpl extends GenericServiceImpl<User, Long, UserDao> implements UserDetailsService, UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        super(userDao);
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        try {
            User user = userDao.findUserByUserName(userName);
            return new UserDetailsImpl(user);
        } catch (Exception ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new UsernameNotFoundException("No user named " + userName);
        }

    }

}
