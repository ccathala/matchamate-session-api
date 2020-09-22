package com.ccathala.matchamatesessionapi;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import com.ccathala.matchamatesessionapi.model.Session;
import com.ccathala.matchamatesessionapi.services.impl.BatchServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BatchServiceImplTest {

    
    @Autowired
    BatchServiceImpl classUnderTest;

    @Test
    public void given_dateNow_when_getSessionsByEndTimeAndIsDone_then_assertsIsDoneFalseForEachIteration()
            throws ParseException {

        // Given
        String pattern = "yyyy-MM-dd'T'HH";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dateString = simpleDateFormat.format(new Date());
        Date date = simpleDateFormat.parse(dateString);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, 2);
        date = calendar.getTime();

        // When 
        List<Session> sessions = classUnderTest.getSessionsByEndTimeAndIsDone(date);
        
        // Then
        // Check all iteration isDone field is false
        boolean isDoneFalseForAllIteration = true;
        for (Session session : sessions) {
            boolean isDone = session.getIsDone();
            if (isDone) {
                isDoneFalseForAllIteration = false;
            }
        }
        // Assertion
        assertThat(isDoneFalseForAllIteration).isTrue();
    }

    @Test
    public void given_dateNow_when_getSessionsByEndTimeAndIsDone_then_assertsEndTimeIsBeforeDateNowForEachIteration()
            throws ParseException {

        // Given
        String pattern = "yyyy-MM-dd'T'HH";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dateString = simpleDateFormat.format(new Date());
        Date date = simpleDateFormat.parse(dateString);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, 2);
        date = calendar.getTime();
        
        // When 
        List<Session> sessions = classUnderTest.getSessionsByEndTimeAndIsDone(date);
        
        // Then
        // Check all iteration isDone field is false
        boolean endTimeIsBeforeForAllIteration = true;
        for (Session session : sessions) {
            boolean isBefore = session.getEndTime().getDateTime().before(date);
            if (!isBefore) {
                endTimeIsBeforeForAllIteration = false;
            }
        }
        // Assertion
        assertThat(endTimeIsBeforeForAllIteration).isTrue();
    }

    @Test
    public void given_dateNowPlusOneHour_when_getSessionsByBeginTime_then_assertsBeginTimeEqualsGivenDate()
            throws ParseException {
        // Given
        String pattern = "yyyy-MM-dd'T'HH";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dateString = simpleDateFormat.format(new Date());
        Date date = simpleDateFormat.parse(dateString);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, 3);
        date = calendar.getTime();

        // When
        List<Session> sessions = classUnderTest.getSessionsByBeginTime(date);       
        // Then
        // Check all iteration beginTime is equal to given date
        boolean beginTimeEqualsGivenDate = true;
        for (Session session : sessions) {
            boolean isEqual = session.getBeginTime().getDateTime().equals(date);
            if (!isEqual) {
                beginTimeEqualsGivenDate = false;
            }
        }
        assertThat(beginTimeEqualsGivenDate).isTrue();
    }
}
