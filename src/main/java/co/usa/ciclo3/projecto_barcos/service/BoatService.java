/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.projecto_barcos.service;

import co.usa.ciclo3.projecto_barcos.model.Boat;
import co.usa.ciclo3.projecto_barcos.repository.BoatRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author john0
 */
@Service
public class BoatService {
    @Autowired
    private BoatRepository boatRepository;
    
    public List<Boat> getAll(){
        return boatRepository.getAll();
    }
    
    public Optional<Boat> getBoat(int id){
        return boatRepository.getBoat(id);
    }
    
    public Boat save(Boat b){
        if(b.getId()==null){
            return boatRepository.save(b);
        }else{
            Optional<Boat> baux=boatRepository.getBoat(b.getId());
            if(baux.isEmpty()){
                return boatRepository.save(b);
            }else{
                return b;
            }
        }
    }
}
