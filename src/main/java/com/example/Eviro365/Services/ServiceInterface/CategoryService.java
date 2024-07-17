package com.example.Eviro365.Services.ServiceInterface;
import com.example.Eviro365.Models.WasteCategory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    public ResponseEntity<?> viewAllCategories();
    public ResponseEntity<?> createCategory(WasteCategory categoryContent);
    public ResponseEntity<?> deleteCategory(int categoryId);
    public ResponseEntity<?> searchCategory(String singleCategory);
    public ResponseEntity<?> updateCategory(WasteCategory wasteCategoryContent);
}
