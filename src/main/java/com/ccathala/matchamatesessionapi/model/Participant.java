package com.ccathala.matchamatesessionapi.model;

import lombok.Getter;
import lombok.Setter;

public class Participant extends Player{

    
    private @Getter @Setter Boolean isReady;

    public Participant(String email, String avatarPicture, String firstName, String lastName, String gender,
            String badmintonLevel, int subscribedSessionCount, int leavedSessionCount, Boolean isReady) {
        super(email, avatarPicture, firstName, lastName, gender, badmintonLevel, subscribedSessionCount,
                leavedSessionCount);
        this.isReady = isReady;
    }
}