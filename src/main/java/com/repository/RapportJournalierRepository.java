package com.repository;

import com.entites.RapportJournalier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RapportJournalierRepository extends JpaRepository<RapportJournalier, LocalDate> {


    List<RapportJournalier> findAllByDateBetween(LocalDate date1, LocalDate date2);

    RapportJournalier findByDateEquals(LocalDate date);
}
