package com.ccathala.matchamatesessionapi.services;

import com.ccathala.matchamatesessionapi.model.Session;

public interface EmailService {
    
    void sendMail(Session session, String reason, String motif);
}
