package com.example.mintic.bike.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;

import com.example.mintic.bike.model.Reservation;
import com.example.mintic.bike.reportes.ContadorClientes;
import com.example.mintic.bike.reportes.StatusReservas;
import com.example.mintic.bike.service.ServiceReservation;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin (origins ="*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class ControllerReservation {

    @Autowired
    private ServiceReservation serviceReservation;

    
    @GetMapping("/all")
    public List<Reservation> getAll(){
        return serviceReservation.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id) {
        return serviceReservation.getReservation(id);
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return serviceReservation.save(reservation);
    }
    
    @GetMapping("/report-status")
    public StatusReservas getStatusReservas() {
        return serviceReservation.ReservacionStatus();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservasTiempo(@PathVariable("dateOne") String fechaInicial,@PathVariable("dateTwo") String fechaFinal) {
        return serviceReservation.ReservacionTiempo(fechaInicial, fechaFinal);
    }

    @GetMapping("/report-clients")
    public List<ContadorClientes> getClientes() {
        return serviceReservation.reporteClientes();
    }
    
}

//R5OCT 27 1:17