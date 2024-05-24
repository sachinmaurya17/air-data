package com.example.airodata.repository;

import com.example.airodata.dto.AirportData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirDataRepository extends JpaRepository<AirportData,String> {
}
