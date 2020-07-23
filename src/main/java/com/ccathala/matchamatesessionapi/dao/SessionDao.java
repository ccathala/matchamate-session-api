package com.ccathala.matchamatesessionapi.dao;

import com.ccathala.matchamatesessionapi.model.Session;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "sessions", path = "sessions")
public interface SessionDao extends MongoRepository<Session, String> {
    
}