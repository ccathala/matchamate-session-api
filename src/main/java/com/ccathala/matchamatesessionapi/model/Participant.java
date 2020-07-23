package com.ccathala.matchamatesessionapi.model;

import lombok.Getter;
import lombok.Setter;

public class Participant extends User{

    private @Getter @Setter Boolean isReady;
}