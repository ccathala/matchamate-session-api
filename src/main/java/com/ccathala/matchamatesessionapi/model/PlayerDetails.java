package com.ccathala.matchamatesessionapi.model;

import lombok.Getter;
import lombok.Setter;

public class PlayerDetails {
    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
    private @Getter @Setter String badmintonLevel;
    private @Getter @Setter int subscribedSessionCount;
    private @Getter @Setter int leavedSessionCount;
}