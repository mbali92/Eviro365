package com.example.Eviro365.Services;
import com.example.Eviro365.Models.WasteCategory;
import com.example.Eviro365.Models.WasteDisposal;
import com.example.Eviro365.Repository.DisposalRepository;
import com.example.Eviro365.Services.ServiceInterface.DisposalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DisposalServiceImpl implements DisposalServices {

    @Autowired
    private DisposalRepository disposalRepository;

    @Override
    public ResponseEntity<?> viewAllDisposalMethods() {
        try{
            return ResponseEntity.ok(disposalRepository.findAll());
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<?> createDisposalMethod(WasteDisposal wasteDisposal) {
        try{
            return ResponseEntity.ok(disposalRepository.save(wasteDisposal));
        }catch(Exception e) {
            return ResponseEntity.badRequest().body("Error while saving data" + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> deleteDisposalMethod(int disposalId) {
        try{
            disposalRepository.deleteById(disposalId);
            return ResponseEntity.ok("Waste category deleted successfully");

        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error occured while deleting:" + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> searchDisposalMethod(String singleMethod) {
        try{
            return ResponseEntity.ok(disposalRepository.findByWasteCategory(singleMethod).get());
        }catch(Exception error){
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<?> updateDisposalMethods(WasteDisposal newDisposalMethod) {
        WasteDisposal foundWasteDisposal = disposalRepository.findById(newDisposalMethod.getDisposal_id()).get();
        try{
            foundWasteDisposal.setDisposalMethods(newDisposalMethod.getDisposalMethods());
            foundWasteDisposal.setWasteType(newDisposalMethod.getWasteType());
            return ResponseEntity.ok().body(disposalRepository.save(foundWasteDisposal));
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("Error while updating data" + e.getMessage());
        }
    }
}
