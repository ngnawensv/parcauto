/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.mycompany.parcauto.serviceImpl;

import cm.mycompany.parcauto.Dao.VehiculeDao;
import cm.mycompany.parcauto.entities.Vehicule;
import cm.mycompany.parcauto.service.VehiculeService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class VehiculeServiceImpl extends
        GenericServiceImpl<Vehicule, Long, VehiculeDao>
        implements VehiculeService {

    public VehiculeServiceImpl(VehiculeDao vehiculeDao) {
        super(vehiculeDao);
    }
}
