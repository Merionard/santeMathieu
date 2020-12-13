package com.entites;

import com.PeriodeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Accessors(chain = true)
@Data
public class ReleveInformations {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToOne(cascade = CascadeType.ALL)
    private Tension tension;

    @Enumerated(EnumType.STRING)
    private PeriodeEnum periode;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Plat> listPlats = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private ApportNutritionnel apportNutritionnel;

    private String remarque;

    public ReleveInformations addPlat(Plat plat){
        listPlats.add(plat);
        return this;
    }

    public ReleveInformations clearListPlats(){
        listPlats.clear();
        return this;
    }

}
