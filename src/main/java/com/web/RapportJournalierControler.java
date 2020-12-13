package com.web;

import com.PeriodeEnum;
import com.entites.ApportNutritionnel;
import com.entites.RapportJournalier;
import com.entites.ReleveInformations;
import com.entites.Tension;
import com.repository.PlatRepository;
import com.repository.RapportJournalierRepository;
import com.services.RapportJournalierService;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("rapportJournalier")
@Accessors(chain = true)
@CrossOrigin(origins = "*")
public class RapportJournalierControler {

    @Autowired
    private RapportJournalierRepository rapportJournalierRepository;
    @Autowired
    private PlatRepository platRepository;
    @Autowired
    private RapportJournalierService rapportJournalierService;


    @GetMapping("/list")
    public List<RapportJournalier> getAll() {

        return rapportJournalierRepository.findAll();
    }


    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public RapportJournalier addRapportJournalier(@RequestBody RapportJournalier rapportJournalier) {
        return rapportJournalierService.saveRapportJournalier(rapportJournalier);
    }


    @GetMapping("/findByDate/{startDate}")
    public ResponseEntity<RapportJournalier> getByDate(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        RapportJournalier rapportJournalier = rapportJournalierRepository.findByDateEquals(startDate);
        return rapportJournalier != null ? new ResponseEntity<>(rapportJournalier, headers, HttpStatus.OK) : new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{startDate}/{endDate}")
    public List<RapportJournalier> getAllByDate(@PathVariable(value = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                                @PathVariable(value = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return rapportJournalierRepository.findAllByDateBetween(startDate, endDate);
    }

    @GetMapping("/test")
    public RapportJournalier test(){
        RapportJournalier rapportJournalier = new RapportJournalier()
                .setDate(LocalDate.now())
                .addReleve(new ReleveInformations()
                .setTension(new Tension().setT_descendante(5).setT_descendante(11))
                .setApportNutritionnel(new ApportNutritionnel().setMagnesium(5).setPhosphore(2))
                .addPlat(platRepository.findAll().get(0))
                .setPeriode(PeriodeEnum.MATIN)
                .setRemarque("Rapport de test"));

        return rapportJournalierRepository.save(rapportJournalier);
    }


}
