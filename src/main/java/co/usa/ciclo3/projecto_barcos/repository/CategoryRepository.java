/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.usa.ciclo3.projecto_barcos.repository;

import co.usa.ciclo3.projecto_barcos.model.Category;
import co.usa.ciclo3.projecto_barcos.repository.crud.CategoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author john0
 */
@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;
    
    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }
    
    public Optional<Category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    }
    
    public Category save(Category b){
        return categoryCrudRepository.save(b);
    }
    
    public void delete(Category category){
        categoryCrudRepository.delete(category);
    }
    
}
