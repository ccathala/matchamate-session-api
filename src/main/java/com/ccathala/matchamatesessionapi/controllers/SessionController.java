package com.ccathala.matchamatesessionapi.controllers;

import java.util.Optional;

import com.ccathala.matchamatesessionapi.dao.SessionDao;
import com.ccathala.matchamatesessionapi.model.Session;
import com.ccathala.matchamatesessionapi.services.impl.EmailServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    @Autowired
    private SessionDao sessionDao;

    @Autowired
    private EmailServiceImpl emailServiceImpl;
    
    @DeleteMapping("/reservation-cancel/{id}")
    public ResponseEntity<String> reservationCancel(@PathVariable("id") String id, @Param("motif") String motif) {
        if (sessionDao.existsById(id)) {
            Optional<Session> session = sessionDao.findById(id);
            if (session.isPresent()) {
                emailServiceImpl.sendMail(session.get(), "cancel", motif);
            }
            sessionDao.deleteById(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("There is no session in database for this session id: " + id, HttpStatus.BAD_REQUEST);
        }
    }

    // @GetMapping("/filtersessions")
    // public ResponseEntity<?> filterSessions(@Param("regionCode") String regionCode, @Param("departementCode") String departementCode, ) {
        
        
    //     return null;
        
    // }
}
