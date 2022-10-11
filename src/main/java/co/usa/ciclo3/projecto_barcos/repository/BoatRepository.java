/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.projecto_barcos.repository;

import co.usa.ciclo3.projecto_barcos.model.Boat;
import co.usa.ciclo3.projecto_barcos.repository.crud.BoatCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author john0
 */
@Repository
public class BoatRepository {
    @Autowired
    private BoatCrudRepository boatCrudRepository;
    
    public List<Boat> getAll(){
        return (List<Boat>) boatCrudRepository.findAll();
    }
    
    public Optional<Boat> getBoat(int id){
        return boatCrudRepository.findById(id);
    }
    
    public Boat save(Boat b){
        return boatCrudRepository.save(b);
    }
    
}
