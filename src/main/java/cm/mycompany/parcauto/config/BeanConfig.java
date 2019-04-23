/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.mycompany.parcauto.config;

import cm.mycompany.parcauto.Dao.MarqueDao;
import cm.mycompany.parcauto.Dao.PersonneDao;
import cm.mycompany.parcauto.Dao.UserDao;
import cm.mycompany.parcauto.Dao.VehiculeDao;
import cm.mycompany.parcauto.DaoImpl.MarqueDaoImpl;
import cm.mycompany.parcauto.DaoImpl.PersonneDaoImpl;
import cm.mycompany.parcauto.DaoImpl.UserDaoImpl;
import cm.mycompany.parcauto.DaoImpl.VehiculeDaoImpl;
import cm.mycompany.parcauto.service.MarqueService;
import cm.mycompany.parcauto.service.PersonneService;
import cm.mycompany.parcauto.service.UserService;
import cm.mycompany.parcauto.service.VehiculeService;
import cm.mycompany.parcauto.serviceImpl.MarqueServiceImpl;
import cm.mycompany.parcauto.serviceImpl.PersonneServiceImpl;
import cm.mycompany.parcauto.serviceImpl.UserServiceImpl;
import cm.mycompany.parcauto.serviceImpl.VehiculeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author vivien saa
 */
@Configuration
public class BeanConfig {

    // Dao beans
    @Bean
    public PersonneDao getPersonneDao() {
        return new PersonneDaoImpl();
    }

    @Bean
    public MarqueDao getMarqueDao() {
        return new MarqueDaoImpl();
    }

    @Bean
    public VehiculeDao getVehiculeDao() {
        return new VehiculeDaoImpl();
    }

    @Bean
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
    // Service beans

    @Bean
    @Autowired
    public PersonneService getPersonneService(PersonneDao personneDao) {
        return new PersonneServiceImpl(personneDao);
    }

    @Bean
    @Autowired
    public MarqueService getMarqueService(MarqueDao marqueDao) {
        return new MarqueServiceImpl(marqueDao);
    }

    @Bean
    @Autowired
    public VehiculeService getVehiculeService(VehiculeDao vehiculeDao) {
        return new VehiculeServiceImpl(vehiculeDao);
    }

    @Bean(name = "userService")
    @Autowired
    public UserService getUserService(UserDao userDao) {
        return new UserServiceImpl(userDao);
    }
}
