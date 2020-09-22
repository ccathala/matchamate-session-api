package com.ccathala.matchamatesessionapi.services.impl;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.ccathala.matchamatesessionapi.model.Session;
import com.ccathala.matchamatesessionapi.services.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendMail(Session session, String reason, String motif) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        Integer maxPlayersNumber = session.getMaxPlayersNumber();

        String participant1 = session.getParticipants().get(0).getEmail();
        String participant2 = session.getParticipants().get(1).getEmail();
        String participant3;
        String participant4;

        if (maxPlayersNumber == 4) {
            participant3 = session.getParticipants().get(2).getEmail();
            participant4 = session.getParticipants().get(3).getEmail();

            simpleMailMessage.setTo(participant1, participant2, participant3, participant4);
        } else {
            simpleMailMessage.setTo(participant1, participant2);
        }

        Map<String, String> mailContent = new HashMap<>();

        if (reason.equals("lock")) {
            mailContent = generateLockedSessionMail(session);
        } else if (reason.equals("cancel")) {
            mailContent = generatedCancelledSessionMail(session, motif);
        }

        simpleMailMessage.setSubject(mailContent.get("objet"));
        simpleMailMessage.setText(mailContent.get("text"));   

        javaMailSender.send(simpleMailMessage);

    }

    private Map<String, String> generateLockedSessionMail(Session session) {

        HashMap<String, String> mailContent = new HashMap<>();

        // Init SimpleDateFormat with pattern yyyy-MM-dd
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        // Get date in String
        String dateString = simpleDateFormat.format(session.getDate());

        // Set new line
        String newline = System.getProperty("line.separator");

        // Set Subject
        String objet = "Confirmation de la session de badminton du " + dateString;

        // Add subject to mail content
        mailContent.put("objet", objet);

        // Set line date
        String lineDate = "La session de badminton du " + dateString + " est confirmée.";

        // Set line hours
        String lineHours = "Début: " + session.getBeginTime().getDisplay() + " Fin:  "
                + session.getEndTime().getDisplay() + ".";

        // Set line place
        String linePlace = "Lieu: " + session.getCompany().getName() + " - "
                + session.getCompany().getAddress().getBuildingNumber() + " "
                + session.getCompany().getAddress().getStreet() + " " + session.getCompany().getAddress().getCity()
                + " " + session.getCompany().getAddress().getZipCode() + ".";

        // Init StringBuilder
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < session.getParticipants().size(); i++) {
            stringBuilder.append(session.getParticipants().get(i).getFirstName() + " "
                    + session.getParticipants().get(i).getLastName());
            if (i == session.getParticipants().size() - 1) {
                stringBuilder.append(".");
            } else {
                stringBuilder.append(", ");
            }
        }

        // Set line player
        String linePlayers = "Les participants: " + stringBuilder;

        // Set text
        String text = lineDate + newline + lineHours + newline + linePlace + newline + linePlayers;

        // Add text to mail content
        mailContent.put("text", text);

        return mailContent;
    }

    private Map<String, String> generatedCancelledSessionMail(Session session, String motif) {

        HashMap<String, String> mailContent = new HashMap<>();

        // Init SimpleDateFormat with pattern yyyy-MM-dd
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        // Get date in String
        String dateString = simpleDateFormat.format(session.getDate());

        // Set Subject
        String objet = "Annulation de la session de badminton du " + dateString;

        // Add subject to mail content
        mailContent.put("objet", objet);
        

        // Set line date
        String text = "La session de badminton à laquelle vous étiez inscrit et qui devait avoir lieu à "
                + session.getCompany().getName() + " le " + dateString + " de " + session.getBeginTime().getDisplay()
                + " à " + session.getEndTime().getDisplay() + "  est annulée pour le motif suivant: " + motif + ".";

        // Add text to mail content
        mailContent.put("text", text);

        return mailContent;
    }

}
