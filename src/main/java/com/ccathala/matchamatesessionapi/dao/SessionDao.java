package com.ccathala.matchamatesessionapi.dao;

import java.util.Date;
import java.util.List;

import com.ccathala.matchamatesessionapi.model.Session;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "sessions", path = "sessions")
public interface SessionDao extends MongoRepository<Session, String> {
    @Query("{'company.email': ?0, 'date': {'$date': {'$numberLong': ?1} } }")
    List<Session> findByCompany_EmailAndDate(@Param("email") String email, @Param("date") String date);

    @Query("{'participants.email': ?0, 'date': {'$date': {'$numberLong': ?1} } }")
    List<Session> findByUser_EmailAndDate(@Param("email") String email, @Param("date") String date);

    List<Session> findByCompany_Email(@Param("email") String email);

    List<Session> findByParticipants_Email(@Param("email") String email);

    //@Query("{'company.address.region.code': ?0, 'company.address.departement.code': ?1, 'company.name': ?2, 'badmintonRequiredLevel': ?3, 'isFull': false, 'isDone': false}")
    //@Query("{'company.address.region.code': ?0,'isFull': false, 'isDone': false}")
    List<Session> findByCompany_Address_Region_CodeContainsAndCompany_Address_Departement_CodeContainsAndCompany_NameContainsAndBadmintonRequiredLevelContainsAndIsFullFalseAndIsDoneFalseAndCompany_CompanyDataIsSetTrue(
            @Param("regionCode") String regionCode, @Param("departementCode") String departementCode,
            @Param("companyName") String companyName, @Param("badmintonRequiredLevel") String badmintonRequiredLevel);

    @Query("{'endTime.dateTime': {$lte: ?0}, 'isDone': false}")
    List<Session> findByEndTimeDateTimeAndIsDone(Date date);

    @Query("{'beginTime.dateTime': ?0 }")
    List<Session> findByBeginTime(Date date);
}