package com.ccathala.matchamatesessionapi.model;

import lombok.Getter;
import lombok.Setter;

public class OpenedHoursPerDay {
    
    private @Getter @Setter String dayName;
    private @Getter @Setter String openingTime;
    private @Getter @Setter String closingTime;
}