package com.example.Eviro365.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class WasteDisposal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int disposal_id;
    @NotBlank
    private String wasteType;
    @NotBlank
    @Size(min= 10, max = 1000, message = "Disposal methods cannot be less than 5 characters")
    private String disposalMethods;
}
