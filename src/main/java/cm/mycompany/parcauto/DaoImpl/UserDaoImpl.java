/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.mycompany.parcauto.DaoImpl;

import cm.mycompany.parcauto.Dao.UserDao;
import cm.mycompany.parcauto.entities.User;
import javax.persistence.Query;
import org.slf4j.Logger;

/**
 *
 * @author vivien saa
 */
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public User findUserByUserName(String userName) throws Exception {
        logger.debug("Getting user by username " + userName);
        Query query = getEntityManager().createNamedQuery("user_find_user_by_user_name");
        query.setParameter("userName", userName);
        User user = null;
        try {
            user = (User) query.getSingleResult();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return user;
    }

}
