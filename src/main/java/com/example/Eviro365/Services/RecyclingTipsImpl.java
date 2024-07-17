package com.example.Eviro365.Services;

import com.example.Eviro365.Models.RecyclingTips;
import com.example.Eviro365.Models.WasteCategory;
import com.example.Eviro365.Repository.RecyclingRepository;
import com.example.Eviro365.Services.ServiceInterface.RecyclingTipsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RecyclingTipsImpl implements RecyclingTipsService {
    @Autowired
    RecyclingRepository recyclingRepository;

    @Override
    public ResponseEntity<?> viewAllRecyclingTips() {
        try{
            return ResponseEntity.ok(recyclingRepository.findAll());
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<?> createRecyclingTips(@Valid RecyclingTips recyclingTips) {
        try{
            return ResponseEntity.ok(recyclingRepository.save(recyclingTips));

        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Error while saving data" + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> deleteRecyclingTips(int tipId) {
        try{
            recyclingRepository.deleteById(tipId);
            return ResponseEntity.ok("Waste category deleted successfully");

        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error occured while deleting:" + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> searchRecyclingTips(String materialTypeTip) {
        try{
            return ResponseEntity.ok(recyclingRepository.findByRecycleTip(materialTypeTip).get());
        }catch(Exception error){
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<?> updateRecyclingTips(RecyclingTips recyclingTip) {
        RecyclingTips recyclingTipFound  = recyclingRepository.findById(recyclingTip.getRecycle_id()).get();
        try{
            recyclingTipFound.setMaterialType(recyclingTip.getMaterialType());
            recyclingTipFound.setRecyclingTips(recyclingTip.getRecyclingTips());
            return ResponseEntity.ok().body(recyclingRepository.save(recyclingTipFound));
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("Error while updating data" + e.getMessage());
        }
    }
}
