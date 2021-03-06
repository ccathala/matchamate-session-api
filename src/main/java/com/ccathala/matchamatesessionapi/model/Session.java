package com.ccathala.matchamatesessionapi.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

/**
 * Session
 */
@Document(collection = "sessions")
public class Session {

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