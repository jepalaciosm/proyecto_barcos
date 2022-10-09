/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.projecto_barcos.repository;

import co.usa.ciclo3.projecto_barcos.model.Barcos;
import co.usa.ciclo3.projecto_barcos.repository.crud.BarcosCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author john0
 */
@Repository

public class BarcosRepository {
    @Autowired
    private BarcosCrudRepository barcosCrudRepository;
    
    public List<Barcos> getAll(){
        return (List<Barcos>) barcosCrudRepository.findAll();
    }
    
    public Optional<Barcos> getBarco(int id){
        return barcosCrudRepository.findById(id);
    }
    
    public Barcos save(Barcos b){
        return barcosCrudRepository.save(b);
    }
     
}
