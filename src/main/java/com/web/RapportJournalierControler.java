package com.web;

import com.entites.RapportJournalier;
import com.repository.RapportJournalierRepository;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("rapportJournalier")
@Accessors(chain = true)
@CrossOrigin("*")
public class RapportJournalierControler {

    @Autowired
    private RapportJournalierRepository rapportJournalierRepository;


    @GetMapping("/list")
    public List<RapportJournalier> getAll() {

        return rapportJournalierRepository.findAll();
    }


    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public RapportJournalier addRapportJournalier(@RequestBody RapportJournalier rapportJournalier) {
        return rapportJournalierRepository.save(rapportJournalier);
    }


    @GetMapping("/{startDate}/{endDate}")
    public List<RapportJournalier> getAllByDate(@PathVariable(value = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                                @PathVariable(value = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return rapportJournalierRepository.findAllByDateBetween(startDate, endDate);
    }


}
