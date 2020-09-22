package com.ccathala.matchamatesessionapi.model;

import lombok.Getter;
import lombok.Setter;

public class Departement {
    private @Getter @Setter String nom;
    private @Getter @Setter String code;
    private @Getter @Setter String codeRegion;

    public Departement(String nom, String code, String codeRegion) {
        this.nom = nom;
        this.code = code;
        this.codeRegion = codeRegion;
    }

    
}