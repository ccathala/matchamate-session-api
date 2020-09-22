package com.ccathala.matchamatesessionapi.model;

import lombok.Getter;
import lombok.Setter;

public class DaySchedule {
    
    private @Getter @Setter String dayName;
    private @Getter @Setter Integer dayIndex;
    private @Getter @Setter String openingTime;
    private @Getter @Setter String closingTime;
}