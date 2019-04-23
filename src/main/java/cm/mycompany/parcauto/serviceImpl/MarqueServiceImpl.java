/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.mycompany.parcauto.serviceImpl;

import cm.mycompany.parcauto.Dao.MarqueDao;
import cm.mycompany.parcauto.entities.Marque;
import cm.mycompany.parcauto.service.MarqueService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MarqueServiceImpl extends
        GenericServiceImpl<Marque, Long, MarqueDao>
        implements MarqueService {

    public MarqueServiceImpl(MarqueDao marqueDao) {
        super(marqueDao);
    }

}
