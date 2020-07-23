package com.ccathala.matchamatesessionapi.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * Session
 */
public class Session {

    @Id
    private @Getter @Setter String id;
    private @Getter @Setter User practicePlace;    
    private @Getter @Setter LocalDate date;
    private @Getter @Setter String beginTime;
    private @Getter @Setter String endTime;
    private @Getter @Setter Integer maxPlayersNumber;
    private @Getter @Setter List<Participant> participants;
    private @Getter @Setter String requiredLevel;
    private @Getter @Setter Integer readyParticipantsCount;
    private @Getter @Setter Boolean isReserved;
    private @Getter @Setter Boolean isLocked;
}