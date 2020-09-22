package com.ccathala.matchamatesessionapi.model;

import lombok.Getter;
import lombok.Setter;

public class Address {
    private @Getter @Setter String buildingNumber;
    private @Getter @Setter String street;
    private @Getter @Setter String city;
    private @Getter @Setter String zipCode;
    private @Getter @Setter Departement departement;
    private @Getter @Setter Region region;
}