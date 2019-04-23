/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.mycompany.parcauto.controller;

import static cm.mycompany.parcauto.entities.Constants.ROLE_ADMIN;
import static cm.mycompany.parcauto.entities.Constants.ROLE_USER;
import cm.mycompany.parcauto.entities.Marque;
import cm.mycompany.parcauto.service.MarqueService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vivien saa
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600,
        methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.POST, RequestMethod.PUT, RequestMethod.OPTIONS},
        allowedHeaders = "*")
@RequestMapping(value = "/marque")
public class MarqueController {

    @Autowired
    private MarqueService marqueService;

    @Secured(ROLE_ADMIN)
    @PostMapping
    public ResponseEntity<Marque> createMarque(@RequestBody Marque marque) throws Exception {
        Marque m = marqueService.create(marque);
        return new ResponseEntity<>(m, HttpStatus.CREATED);
    }

    @Secured(ROLE_USER)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Marque> findMarqueById(@PathVariable("id") Long id) throws Exception {
        Marque marque = marqueService.findById(id);
        if (marque == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(marque, HttpStatus.OK);
    }

    @Secured(ROLE_ADMIN)
    @PutMapping
    public ResponseEntity<Marque> updateMarque(@RequestBody Marque marque) throws Exception {
        Marque m = marqueService.findById(marque.getId());
        System.out.println("********************** update method ************************");
        if (m == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        marqueService.update(marque);
        return new ResponseEntity<>(marque, HttpStatus.OK);

    }

    @Secured(ROLE_ADMIN)
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Marque> deleteMarque(@PathVariable("id") Long id) throws Exception {
        Marque marque = marqueService.findById(id);
        if (marque == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        marqueService.delete(marque);
        return new ResponseEntity<>(marque, HttpStatus.OK);
    }

    @Secured(ROLE_USER)
    @GetMapping
    public ResponseEntity<List<Marque>> findAll() throws Exception {
        List<Marque> listMarque = marqueService.findAll();
        if (listMarque.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listMarque, HttpStatus.OK);
    }

}
