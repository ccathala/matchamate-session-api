package com.ccathala.matchamatesessionapi.model.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.ccathala.matchamatesessionapi.model.Company;
import com.ccathala.matchamatesessionapi.model.Participant;
import com.ccathala.matchamatesessionapi.model.Time;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * Session
 */
public class SessionDTO {

    @Id
    private @Getter @Setter String id;
    @NotNull
    private @Getter @Setter Company company;
    @NotEmpty
    private @Getter @Setter Date date;
    @NotEmpty
    private @Getter @Setter Time beginTime;
    @NotEmpty
    private @Getter @Setter Time endTime;
    @NotNull
    private @Getter @Setter Integer maxPlayersNumber;
    @NotNull
    private @Getter @Setter List<Participant> participants;
    @NotEmpty
    private @Getter @Setter String badmintonRequiredLevel;
    @NotNull
    private @Getter @Setter Integer readyParticipantsCount;
    @NotNull
    private @Getter @Setter Boolean isReserved;
    @NotNull
    private @Getter @Setter Boolean isLocked;
    @NotNull
    private @Getter @Setter Boolean isFull;
    @NotNull
    private @Getter @Setter Boolean isDone;
    @NotNull
    private @Getter @Setter Boolean isPlayed;
}