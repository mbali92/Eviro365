package com.example.Eviro365.Services;
import com.example.Eviro365.Models.WasteCategory;
import com.example.Eviro365.Repository.CategoryRepository;
import com.example.Eviro365.Services.ServiceInterface.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    //access all the waste categories
    @Override
    public ResponseEntity<?> viewAllCategories(){
        try{
           return ResponseEntity.ok(categoryRepository.findAll());
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    //saving new Waste category
    @Override
    public ResponseEntity<?>createCategory(@Valid WasteCategory categoryContent){
        try{
            return ResponseEntity.ok(categoryRepository.save(categoryContent));
            
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Error while saving data" + e.getMessage());
        }
    }

    //delete waste category record
    @Override
    public ResponseEntity<?> deleteCategory(int categoryId){
        try{
            categoryRepository.deleteById(categoryId);
            return ResponseEntity.ok("Waste category deleted successfully");

        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error occured while deleting:" + e.getMessage());
        }       
    }

    //search for a particular category
    @Override
    public ResponseEntity<?> searchCategory(String singleCategory){
        try{
            return ResponseEntity.ok(categoryRepository.findByWasteCategory(singleCategory).get());
        }catch(Exception error){
            return ResponseEntity.notFound().build();
        }
    }

    //update waste category
    @Override
    public ResponseEntity<?> updateCategory(WasteCategory wasteCategoryContent){
        WasteCategory singleWasteCategory = categoryRepository.findById(wasteCategoryContent.getCategory_id()).get();
       try{
          singleWasteCategory.setWasteCategory(wasteCategoryContent.getWasteCategory());
          singleWasteCategory.setDescription(wasteCategoryContent.getDescription());
          return ResponseEntity.ok().body(categoryRepository.save(singleWasteCategory));
       }
       catch(Exception e){
        return ResponseEntity.badRequest().body("Error while updating data" + e.getMessage());
       }
    }

}
