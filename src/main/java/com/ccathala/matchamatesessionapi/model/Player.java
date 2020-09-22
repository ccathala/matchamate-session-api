package com.ccathala.matchamatesessionapi.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Document(collection = "players")
public class Player {

    @Id
    private String id;
    @Indexed(unique = true)
    @NotBlank
    @Email
    private @Getter @Setter String email;
    @NotBlank
    private @Getter @Setter String avatarPicture;
    @NotBlank
    private @Getter @Setter String firstName;
    @NotBlank
    private @Getter @Setter String lastName;
    @NotBlank
    private @Getter @Setter String gender;
    @NotBlank
    private @Getter @Setter String badmintonLevel;
    private @Getter @Setter Integer subscribedSessionCount;
    private @Getter @Setter Integer leavedSessionCount;

    public Player(String email, String avatarPicture, String firstName, String lastName, String gender,
            String badmintonLevel, int subscribedSessionCount, int leavedSessionCount) {
        this.email = email;
        this.avatarPicture = avatarPicture;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.badmintonLevel = badmintonLevel;
        this.subscribedSessionCount = subscribedSessionCount;
        this.leavedSessionCount = leavedSessionCount;
    }
}