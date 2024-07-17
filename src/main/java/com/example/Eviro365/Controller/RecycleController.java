package com.example.Eviro365.Controller;

import com.example.Eviro365.Models.RecyclingTips;
import com.example.Eviro365.Services.ServiceInterface.RecyclingTipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("recycling")
public class RecycleController {

    @Autowired
    private RecyclingTipsService recyclingTipsService;

    @GetMapping("/allRecyclingTips")
    public ResponseEntity<?> viewAllRecyclingTips(){
        return  recyclingTipsService.viewAllRecyclingTips();
    };

    @PostMapping("/createRecyclingTip")
    public ResponseEntity<?> createRecyclingTips(@RequestBody  RecyclingTips recyclingTip){
        return  recyclingTipsService.createRecyclingTips(recyclingTip);
    }
    @DeleteMapping("/removeTip/{tipId}")
    public ResponseEntity<?> deleteRecyclingTips(@PathVariable int tipId){
        return  recyclingTipsService.deleteRecyclingTips(tipId);
    }
    @GetMapping("/showTip/{materialTypeTip}")
    public ResponseEntity<?> searchRecyclingTips(@PathVariable String materialTypeTip){
        return recyclingTipsService.searchRecyclingTips(materialTypeTip);
    }
    @PutMapping("/updateTips")
    public ResponseEntity<?> updateRecyclingTips(@RequestBody RecyclingTips recyclingTips){
       return recyclingTipsService.updateRecyclingTips(recyclingTips);
    }
}
