package com.example.Eviro365.Repository;



import com.example.Eviro365.Models.WasteCategory;
import com.example.Eviro365.Models.WasteDisposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DisposalRepository extends JpaRepository<WasteDisposal, Integer> {
    @Query("SELECT u from WasteDisposal u WHERE u.wasteType = :wasteType")
    Optional<WasteCategory> findByWasteCategory(@Param("wasteType") String wasteCategory);
}
