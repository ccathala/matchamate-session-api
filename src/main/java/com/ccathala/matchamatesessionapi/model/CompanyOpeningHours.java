package com.ccathala.matchamatesessionapi.model;

import lombok.Getter;
import lombok.Setter;

public class CompanyOpeningHours {
    
    private @Getter @Setter OpenedHoursPerDay monday;
    private @Getter @Setter OpenedHoursPerDay tuesday;
    private @Getter @Setter OpenedHoursPerDay wednesday;
    private @Getter @Setter OpenedHoursPerDay thursday;
    private @Getter @Setter OpenedHoursPerDay friday;
    private @Getter @Setter OpenedHoursPerDay saturday;
    private @Getter @Setter OpenedHoursPerDay sunday;
    
}