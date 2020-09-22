package com.ccathala.matchamatesessionapi.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ccathala.matchamatesessionapi.dao.SessionDao;
import com.ccathala.matchamatesessionapi.model.Session;
import com.ccathala.matchamatesessionapi.services.BatchService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class BatchServiceImpl implements BatchService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SessionDao sessionDao;

    @Autowired
    private EmailServiceImpl emailServiceImpl;

    @Override
    @Scheduled(cron = "${batch.time.event.setsessionsdone}")
    public void scheduledSetSessionsDone() {
        logger.info("Update done sessions");

        Date currentDate = setDate();
        Date currentDatePlusOneHour = addHoursToJavaUtilDate(currentDate, 1);

        setSessionsDone(currentDate);
        setSessionsLocked(currentDatePlusOneHour);
    }

    public void setSessionsDone(Date date) {
        // Get sessions
        List<Session> sessions = getSessionsByEndTimeAndIsDone(date);
        // Set session attribute isDone=true
        for (int i = 0; i < sessions.size(); i++) {
            boolean isDone = sessions.get(i).getIsDone();
            if (!isDone) {
                sessions.get(i).setIsDone(true);
            }
        }
        // Update sessions
        sessionDao.saveAll(sessions);
    }

    public void setSessionsLocked(Date date) {
        // Get sessions
        List<Session> sessions = getSessionsByBeginTime(date);
        List<Session> sessionsToDelete = new ArrayList<>();

        // Set session attribute isLocked=true
        for (int i = 0; i < sessions.size(); i++) {
            boolean isFull = sessions.get(i).getIsFull();
            if (isFull) {
                sessions.get(i).setIsLocked(true);
                emailServiceImpl.sendMail(sessions.get(i), "lock", "");
            } else {
                emailServiceImpl.sendMail(sessions.get(i), "cancel", "La session de jeu n'est pas remplie");
                sessionsToDelete.add(sessions.get(i));
                sessions.remove(i);
            }
        }
        // Remove sessions which are not full
        sessionDao.deleteAll(sessionsToDelete);
        // Update full sessions
        sessionDao.saveAll(sessions);
    }

    public List<Session> getSessionsByEndTimeAndIsDone(Date date) {
        return sessionDao.findByEndTimeDateTimeAndIsDone(date);
    }

    public List<Session> getSessionsByBeginTime(Date date) {
        return sessionDao.findByBeginTime(date);
    }

    public Date setDate() {

        // Set current date
        String pattern = "yyyy-MM-dd'T'HH";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = addHoursToJavaUtilDate(new Date(), 2);
        String dateString = simpleDateFormat.format(date);
        Date currentDate = null;
        try {
            currentDate = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return currentDate;
    }

    public Date addHoursToJavaUtilDate(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }
}