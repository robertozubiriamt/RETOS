package com.example.mintic.bike.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mintic.bike.model.Client;
import com.example.mintic.bike.model.Reservation;
import com.example.mintic.bike.reportes.ContadorClientes;
import com.example.mintic.bike.reportes.StatusReservas;
import com.example.mintic.bike.repository.RepositoryReservation;

@Service
public class ServiceReservation {
    
    @Autowired
    private RepositoryReservation repositoryReservation;

    
    public List<Reservation> getAll() {
        return repositoryReservation.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return repositoryReservation.getReservation(id);
    }

    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return repositoryReservation.save(reservation);
        } else {
            Optional<Reservation> reservation1 = repositoryReservation.getReservation(reservation.getIdReservation());
            if (reservation1.isEmpty()) {
                return repositoryReservation.save(reservation);
            } else {
                return reservation;
            }
        }
    }


    public StatusReservas ReservacionStatus(){
       
        List<Reservation> completed = repositoryReservation.ReservacionStatus("completed");
        List<Reservation> cancelled = repositoryReservation.ReservacionStatus("cancelled");

        return new StatusReservas(completed.size(), cancelled.size());
    }

    public List<Reservation> ReservacionTiempo(String fechaInicial,String fechaFinal){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        Date fechaUno = new Date();
        Date fechaDos = new Date();

        try {
            fechaUno = parser.parse(fechaInicial);
            fechaDos = parser.parse(fechaFinal);
        } catch (ParseException evt) {
            evt.printStackTrace();
        }
        if (fechaUno.before(fechaDos)) {
            return repositoryReservation.ReservacionTiempo(fechaUno, fechaDos);
        } else {
            return new ArrayList<>();
        }
    }

  

    public List<ContadorClientes> reporteClientes() {        
        List<ContadorClientes> resultado = new ArrayList<>();
        List<Object[]> reporte = repositoryReservation.reporteClientes();
        System.out.println(reporte);
        for (int i = 0; i < reporte.size(); i++) {
            resultado.add(new ContadorClientes((Long) reporte.get(i)[1], (Client) reporte.get(i)[0]));
        }
        return resultado;
    }


}
