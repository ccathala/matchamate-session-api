package com.ccathala.matchamatesessionapi.model;

import lombok.Getter;
import lombok.Setter;

public class Region {
    private @Getter @Setter String nom;
    private @Getter @Setter String code;

    public Region(String nom, String code) {
        this.nom = nom;
        this.code = code;
    }

    
}