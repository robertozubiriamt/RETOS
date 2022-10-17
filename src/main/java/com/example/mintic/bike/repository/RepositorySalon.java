package com.example.mintic.bike.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mintic.bike.model.Salon;
import com.example.mintic.bike.repository.crud.CrudRepositorySalon;

@Repository
public class RepositorySalon {
    
    @Autowired
    private CrudRepositorySalon crudRepositorySalon;


    public List<Salon> getAll(){
        return (List<Salon>) crudRepositorySalon.findAll();
    }
    public Optional<Salon> getSalon(int id){
        return crudRepositorySalon.findById(id);
    }
    
    public Salon save(Salon salon){
        return crudRepositorySalon.save(salon);
    }
    
    public void delete(Salon salon){
        crudRepositorySalon.delete(salon);
    }


}
