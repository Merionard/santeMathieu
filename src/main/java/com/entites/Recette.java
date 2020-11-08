package com.entites;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Accessors(chain = true)
public class Recette {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<LigneRecette> lignes = new ArrayList<>();

    public Recette addLigne(LigneRecette ligneRecette){
        lignes.add(ligneRecette);
        return this;
    }
}
