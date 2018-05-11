package com.example.office.repository;

import com.example.office.domain.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office,Long> {
}
