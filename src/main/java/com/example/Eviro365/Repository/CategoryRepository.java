package com.example.Eviro365.Repository;

import com.example.Eviro365.Models.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<WasteCategory,Integer> {
    @Query("SELECT u from WasteCategory u WHERE u.wasteCategory = :wasteCategory")
    Optional<WasteCategory> findByWasteCategory(@Param("wasteCategory") String wasteCategory);
}
