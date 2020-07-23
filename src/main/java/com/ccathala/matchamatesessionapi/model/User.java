package com.ccathala.matchamatesessionapi.model;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

public class User {
    
    @Id    
    private String id;
    private @Getter @Setter String email;
    private @Getter @Setter String role;
    private @Getter @Setter String avatarPicture;
    private @Getter @Setter PlayerDetails playerDetails;
    private @Getter @Setter CompanyDetails companyDetails;
}