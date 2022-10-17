package com.example.mintic.bike.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mintic.bike.model.Salon;
import com.example.mintic.bike.repository.RepositorySalon;

@Service
public class ServiceSalon {
    
    @Autowired
    private RepositorySalon repositorySalon;

    
    public List<Salon> getAll() {
        return repositorySalon.getAll();
    }

    public Optional<Salon> getSalon(int id) {
        return repositorySalon.getSalon(id);
    }

    public Salon save(Salon salon) {
        if (salon.getId() == null) {
            return repositorySalon.save(salon);
        } else {
            Optional<Salon> salon1 = repositorySalon.getSalon(salon.getId());
            if (salon1.isEmpty()) {
                return repositorySalon.save(salon);
            } else {
                return salon;
            }
        }
    }


    public Salon update(Salon salon){
        if(salon.getId()!=null){
            Optional<Salon>g= repositorySalon.getSalon(salon.getId());
            if(!g.isEmpty()){
                if(salon.getDescription()!=null){
                    g.get().setDescription(salon.getDescription());
                }
                if(salon.getName()!=null){
                    g.get().setName(salon.getName());
                }
                return repositorySalon.save(g.get());
            }
        }
        return salon;
    }
    public boolean deleteSalon(int id){
        Boolean d= getSalon(id).map(salon -> {
                                                        repositorySalon.delete(salon);
                                                        return true;
                                            }
                                      ).orElse(false);
        return d;
    }

}
