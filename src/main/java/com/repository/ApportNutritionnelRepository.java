package com.repository;

import com.entites.ApportNutritionnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApportNutritionnelRepository extends JpaRepository<ApportNutritionnel,Long> {
}
