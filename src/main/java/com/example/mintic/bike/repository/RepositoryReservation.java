package com.example.mintic.bike.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.mintic.bike.model.Client;
import com.example.mintic.bike.model.Reservation;
import com.example.mintic.bike.reportes.ContadorClientes;
import com.example.mintic.bike.repository.crud.CrudRepositoryReservation;

@Repository
public class RepositoryReservation {
    
    @Autowired
    private CrudRepositoryReservation crudRepositoryReservation;

    
    public List<Reservation> getAll(){
        return (List<Reservation>) crudRepositoryReservation.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return crudRepositoryReservation.findById(id);
    }
    
    public Reservation save(Reservation reservation){
        return crudRepositoryReservation.save(reservation);
    }

    public List<Reservation> ReservacionStatus(String status){
        return crudRepositoryReservation.findAllByStatus(status);
    }

    public List<Reservation> ReservacionTiempo(Date fechaInicial, Date fechaFinal){
        return crudRepositoryReservation.findAllByStartDateAfterAndStartDateBefore(fechaInicial, fechaFinal);
    }

       
    public   List<Object[]> reporteClientes() {
        return crudRepositoryReservation.reporteClientes();

    }
}   