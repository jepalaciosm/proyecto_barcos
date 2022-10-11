/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.projecto_barcos.service;

import co.usa.ciclo3.projecto_barcos.model.Category;
import co.usa.ciclo3.projecto_barcos.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author john0
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    
    public Category save(Category b){
        if(b.getId()==null){
            return categoryRepository.save(b);
        }else{
            Optional<Category> baux=categoryRepository.getCategory(b.getId());
            if(baux.isEmpty()){
                return categoryRepository.save(b);
            }else{
                return b;
            }
        }
    }
}
