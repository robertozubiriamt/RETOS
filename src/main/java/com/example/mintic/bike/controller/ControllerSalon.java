package com.example.mintic.bike.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;

import com.example.mintic.bike.model.Salon;
import com.example.mintic.bike.service.ServiceSalon;

@RestController
@RequestMapping("/api/Salon")
@CrossOrigin (origins ="*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ControllerSalon {

    @Autowired
    private ServiceSalon serviceSalon;
    

    @GetMapping("/all")
    public List<Salon> getAll(){
        return serviceSalon.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Salon> getSalon(@PathVariable("id") int id) {
        return serviceSalon.getSalon(id);
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Salon save(@RequestBody Salon salon) {
        return serviceSalon.save(salon);
    }

    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Salon update(@RequestBody Salon salon) {
        return serviceSalon.update(salon);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int salonId) {
        return serviceSalon.deleteSalon(salonId);
    }

}
