package com.repository;

import com.entites.RapportJournalier;
import com.entites.Repas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface RapportRepository extends JpaRepository<RapportJournalier, LocalDate> {
}
