/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.mycompany.parcauto.serviceImpl;

import cm.mycompany.parcauto.Dao.PersonneDao;
import cm.mycompany.parcauto.entities.Personne;
import cm.mycompany.parcauto.service.PersonneService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PersonneServiceImpl extends
        GenericServiceImpl<Personne, Long, PersonneDao>
        implements PersonneService {

    public PersonneServiceImpl(PersonneDao personneDao) {
        super(personneDao);
    }
}
