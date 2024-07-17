package com.example.Eviro365.Repository;

import com.example.Eviro365.Models.RecyclingTips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecyclingRepository extends JpaRepository<RecyclingTips,Integer> {
    @Query("SELECT u from RecyclingTips u WHERE u.materialType = : materialTypeTip")
    Optional<RecyclingTips> findByRecycleTip(@Param("materialTypeTip") String wasteCategory);
}
