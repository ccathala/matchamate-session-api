package com.ccathala.matchamatesessionapi.model;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "companies")
public class Company {
    
    @Id
    private String id;

    @Email
    @NotBlank
    @Indexed(unique = true)
    private @Getter @Setter String email;

    @NotBlank
    private @Getter @Setter String avatarPicture;

    @NotBlank
    private @Getter @Setter String name;
    private @Getter @Setter String phone;
    private @Getter @Setter String web;
    private @Getter @Setter Address address;
    private @Getter @Setter  List<DaySchedule> weekSchedule;
    private @Getter @Setter List<LocalDate> closedDays;
    private @Getter @Setter Boolean companyDataIsSet;
    
}