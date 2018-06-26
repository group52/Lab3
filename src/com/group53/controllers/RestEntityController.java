package com.group53.controllers;

import com.group53.beans.Entity;
import com.group53.beans.Person;
import com.group53.dao.EntityDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * class RestEntityController is controller for operation under the entities for Rest
 */
@RestController
public class RestEntityController {
    @Autowired
    private EntityDAOImpl entityDAO;

    /**
     * Return the view of the all entites from the table GRP5_Entity
     * @return json with the all entites from the table GRP5_Entity
     */
    @RequestMapping(value = "/viewAllRest/", method = RequestMethod.GET,produces = "application/json")

    public ResponseEntity viewAllRest(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        List<Entity> entityList = entityDAO.getAllEntitys();
        if(entityList.isEmpty()){
            return new ResponseEntity<List>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List>(entityList, HttpStatus.OK);
    }
    /**
     * Return the view of the  entity from the table GRP5_Entity by id
     * @return json with the  entity from the table GRP5_Entity by id
     */
    @RequestMapping(value ="/viewAllRest/{id}", method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity viewByID(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Entity entity = entityDAO.getEntity(id);
        if (entity.equals(null)) {
            return new ResponseEntity("No entity found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(entity, HttpStatus.OK);
    }

    @RequestMapping(value ="/viewAllRestXML/{id}", method = RequestMethod.GET,produces ="application/xml" )
    public ResponseEntity viewByIdXml(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/xml");
        Entity entity = entityDAO.getEntity(id);
        if (entity.equals(null)) {
            return new ResponseEntity("No entity found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(entity, HttpStatus.OK);
    }
}
