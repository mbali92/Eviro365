package com.example.Eviro365.Services.ServiceInterface;

import com.example.Eviro365.Models.WasteDisposal;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface DisposalServices {
    public ResponseEntity<?> viewAllDisposalMethods();
    public ResponseEntity<?> createDisposalMethod(WasteDisposal wasteDisposal);
    public ResponseEntity<?> deleteDisposalMethod(int disposalId);
    public ResponseEntity<?> searchDisposalMethod(String singleMethod);
    public ResponseEntity<?> updateDisposalMethods(WasteDisposal newDisposalMethod);
}
