package com.entites;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Accessors(chain = true)
public class RapportJournalier {

/*    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;*/

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Id
    private LocalDate date;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ReleveInformations> relevesInfos = new HashSet<>();


    public RapportJournalier addReleve(ReleveInformations releveInformations){
        relevesInfos.add(releveInformations);
        return this;
    }
}
