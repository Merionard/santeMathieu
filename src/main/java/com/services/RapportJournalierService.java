package com.services;

import com.entites.Plat;
import com.entites.RapportJournalier;
import com.repository.PlatRepository;
import com.repository.RapportJournalierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RapportJournalierService {

    private final PlatRepository platRepository;
    private final RapportJournalierRepository rapportJournalierRepository;

    public RapportJournalierService(PlatRepository platRepository, RapportJournalierRepository rapportJournalierRepository) {
        this.platRepository = platRepository;
        this.rapportJournalierRepository = rapportJournalierRepository;
    }

    public RapportJournalier saveRapportJournalier(RapportJournalier rapportJournalier) {

        rapportJournalier.getRelevesInfos().forEach(releveInformations -> {
            List<Plat> listPLats = releveInformations.getListPlats().stream()
                    .map(plat -> platRepository.getByNom(plat.getNom()))
                    .collect(Collectors.toList());
            releveInformations.clearListPlats();
            releveInformations.setListPlats(listPLats);
        });

        return rapportJournalierRepository.save(rapportJournalier);

    }
}
