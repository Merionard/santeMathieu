package com.entites;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TypeComptabilisation {

    UNITAIRE(1, "unité"),
    POIDS(100, "/100 gramme");

    private final int value;
    private final String label;

}
