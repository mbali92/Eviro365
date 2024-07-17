package com.example.Eviro365.Controller;


import com.example.Eviro365.Models.WasteCategory;
import com.example.Eviro365.Services.ServiceInterface.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wasteCategory")
public class CategoryController {

    @Autowired
    private CategoryService categoryInterface;

    @GetMapping("/findAllCategories")
    public ResponseEntity<?>viewAllCategories(){
        return categoryInterface.viewAllCategories();
    }

    @PostMapping("/createCategory")
    public ResponseEntity<?> createCategory(@RequestBody WasteCategory categoryContent){
         return categoryInterface.createCategory(categoryContent);
    }

    @DeleteMapping("/deleteRecord/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable int categoryId){
        return categoryInterface.deleteCategory(categoryId);
    }

    @PostMapping("/searchCategory/{singleCategory}")
    public ResponseEntity<?>lookupCategory(@PathVariable String singleCategory){
        return  categoryInterface.searchCategory(singleCategory);
    }

    @PutMapping("/updateCategory")
    public ResponseEntity<?> updateCategory(@RequestBody WasteCategory wasteCategoryContent){
        return categoryInterface.updateCategory(wasteCategoryContent);
    }

}
