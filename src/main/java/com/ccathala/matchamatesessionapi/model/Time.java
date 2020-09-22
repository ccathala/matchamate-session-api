package com.ccathala.matchamatesessionapi.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class Time {
    private @Getter @Setter String display;
    private @Getter @Setter Integer value;
    private @Getter @Setter Date dateTime;

    

    public Time() {
    }

    public Time(String display, Integer value, Date dateTime) {
        this.display = display;
        this.value = value;
        this.dateTime = dateTime;
    }

    
    
}