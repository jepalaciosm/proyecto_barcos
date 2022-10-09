/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.projecto_barcos.web;

import co.usa.ciclo3.projecto_barcos.model.Barcos;
import co.usa.ciclo3.projecto_barcos.service.BarcosService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author john0
 */
@RestController
@RequestMapping("/api/Boat")
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class BarcosController {
    @Autowired
    private BarcosService barcosService;
    
    @GetMapping("/all")
    public List<Barcos> getBarcos(){
        return barcosService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Barcos> getBarco(@PathVariable("id") int id){
        return barcosService.getBarco(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Barcos saveBarcos(@RequestBody Barcos b){
        return barcosService.save(b);
    }
       
}
