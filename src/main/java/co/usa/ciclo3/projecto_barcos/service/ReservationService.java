/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.projecto_barcos.service;

import co.usa.ciclo3.projecto_barcos.model.Reservation;
import co.usa.ciclo3.projecto_barcos.repository.CountClient;
import co.usa.ciclo3.projecto_barcos.repository.ReservationRepository;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author john0
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getMessage(int id){
        return reservationRepository.getReservation(id);
    }
    
    public Reservation save(Reservation b){
        if(b.getIdReservation()==null){
            return reservationRepository.save(b);
        }else{
            Optional<Reservation> baux=reservationRepository.getReservation(b.getIdReservation());
            if(baux.isEmpty()){
                return reservationRepository.save(b);
            }else{
                return b;
            }
        }
    }
    
    public Status getReservationStatusReport(){
         List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
         List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");
         return new Status(completed.size(),cancelled.size());
     } 
     
     public List<Reservation> informePeriodoTiempoReservas(String datoA, String datoB) throws java.text.ParseException{
         SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
         Date a = new Date();
         Date b = new Date();
         
         a = parser.parse(datoA);
         b = parser.parse(datoB);
         if(a.before(b)){
            return reservationRepository.informePeriodoTiempoReservas(a, b);
         }else{
             return new ArrayList<>();
         }
     }
     
     public List<CountClient> getTopClients(){
         return reservationRepository.getTopClient();
     }
}
