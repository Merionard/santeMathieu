package com.entites;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class RapportJournalier {

    @Id
    private LocalDate date;

    @OneToMany
    private Set<ReleveInformations> rapportJournaliers = new HashSet<>();
}
