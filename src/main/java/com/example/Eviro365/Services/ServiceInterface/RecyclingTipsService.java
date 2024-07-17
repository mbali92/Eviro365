package com.example.Eviro365.Services.ServiceInterface;


import com.example.Eviro365.Models.RecyclingTips;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface RecyclingTipsService {
    public ResponseEntity<?> viewAllRecyclingTips();
    public ResponseEntity<?> createRecyclingTips(RecyclingTips recyclingTips);
    public ResponseEntity<?> deleteRecyclingTips(int tipId);
    public ResponseEntity<?> searchRecyclingTips(String materialTypeTip);
    public ResponseEntity<?> updateRecyclingTips( RecyclingTips recyclingTips);
}
