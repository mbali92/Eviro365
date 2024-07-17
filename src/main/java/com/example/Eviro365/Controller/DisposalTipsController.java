package com.example.Eviro365.Controller;
import com.example.Eviro365.Models.WasteDisposal;
import com.example.Eviro365.Services.ServiceInterface.DisposalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/disposalTips")
public class DisposalTipsController {
    @Autowired
    private DisposalServices disposalServices;

    @GetMapping("/showAllDisposalMethods")
    public ResponseEntity<?> viewAllDisposalMethods(){
        return disposalServices.viewAllDisposalMethods();
    }
    @PostMapping("/createDisposalMethod")
    public ResponseEntity<?> createDisposalMethod(@RequestBody WasteDisposal wasteDisposal){
        return  disposalServices.createDisposalMethod(wasteDisposal);
    }
    @DeleteMapping("deleteDisposalMethod/{disposalId}")
    public ResponseEntity<?> deleteDisposalMethod(@PathVariable int disposalId){
        return disposalServices.deleteDisposalMethod(disposalId);
    }
    @GetMapping("/searchTip/{searchSingleMethod}")
    public ResponseEntity<?> searchDisposalMethod(@PathVariable String searchSingleMethod){
        return disposalServices.searchDisposalMethod(searchSingleMethod);
    }
    @PutMapping("/updateDisposalTips")
    public ResponseEntity<?> updateDisposalMethods(@RequestBody WasteDisposal newDisposalMethod){
        return disposalServices.updateDisposalMethods(newDisposalMethod);
    }


}
