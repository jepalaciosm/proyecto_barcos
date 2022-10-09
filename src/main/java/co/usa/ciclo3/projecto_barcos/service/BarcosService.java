/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.projecto_barcos.service;

import co.usa.ciclo3.projecto_barcos.model.Barcos;
import co.usa.ciclo3.projecto_barcos.repository.BarcosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author john0
 */
@Service
public class BarcosService {
    @Autowired
    private BarcosRepository barcosRepository;
    
    public List<Barcos> getAll(){
        return barcosRepository.getAll();
    }
    
    public Optional<Barcos> getBarco(int id){
        return barcosRepository.getBarco(id);
    }
    
    public Barcos save(Barcos b){
        if(b.getId()==null){
            return barcosRepository.save(b);
        }else{
            Optional<Barcos> baux=barcosRepository.getBarco(b.getId());
            if(baux.isEmpty()){
                return barcosRepository.save(b);
            }else{
                return b;
            }
        }
    }
}
