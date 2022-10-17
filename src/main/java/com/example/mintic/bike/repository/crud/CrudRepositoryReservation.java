package com.example.mintic.bike.repository.crud;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.mintic.bike.model.Reservation;

public interface CrudRepositoryReservation extends CrudRepository<Reservation, Integer> {

    // Cantidad de reservas completatas vs canceladas
    public List<Reservation> findAllByStatus(String status);

    // Cantidad de reservas en un tiempo determinado.
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date fechaInicio, Date fechaFin);



    // Top de los clientes que más dinero le han dejado a la compañía.
    // INSTRUCCION SQL SELECT clientid, COUNT(*) AS total FROM reservacion group by clientid order by desc;
    
    @Query("SELECT c.client, COUNT(c.client) from Reservation  AS c  group by c.client order by COUNT(c.client)DESC ")
    public List<Object[]> reporteClientes();

}

// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods