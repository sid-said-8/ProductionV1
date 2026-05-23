package com.Production.repository;

import com.Production.entity.Production;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionRepository extends JpaRepository<Production,Long> {
}
