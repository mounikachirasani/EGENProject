package com.egen.solutions.repository.impl;

import com.egen.solutions.dataobject.Reading;
import com.egen.solutions.dataobject.Vehicle;
import com.egen.solutions.repository.ReadingRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ReadingRepositoryImpl implements ReadingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Reading> listAll() {

        TypedQuery<Reading> query = entityManager.createNamedQuery( "Reading.listAllReading", Reading.class);
        return query.getResultList();
    }

    public Reading getById(String readingId) {

        return entityManager.find(Reading.class, readingId);
    }

    public Reading create(Reading readingObj) {
        entityManager.persist(readingObj);
        return readingObj;
    }

    public Reading update(Reading readingObj) {
        entityManager.merge(readingObj);
        return readingObj;
    }

    public void delete(Reading readingObj) {
        entityManager.remove(readingObj);

    }
}
