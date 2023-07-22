package com.example.repository;

import com.example.entity.ChiTietSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChiTietSPRepository extends JpaRepository<ChiTietSP, UUID> {

    @Query("SELECT c FROM ChiTietSP c WHERE c.idSP.id = :idSP" )
    List<ChiTietSP> findBySanPamId(@Param("idSP") UUID idSP);
    
}
