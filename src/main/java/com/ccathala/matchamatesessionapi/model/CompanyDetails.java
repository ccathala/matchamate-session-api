package com.ccathala.matchamatesessionapi.model;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class CompanyDetails {
    private @Getter @Setter String companyName;
    private @Getter @Setter Address address;
    private @Getter @Setter String phone;
    private @Getter @Setter CompanyOpeningHours companyOpeningHours;
    private @Getter @Setter List<LocalDate> closedDays;
}