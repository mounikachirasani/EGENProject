package com.egen.solutions.repository;

import com.egen.solutions.dataobject.Reading;

import java.util.List;

public interface ReadingRepository {

    public List<Reading> listAll();

    public Reading getById(String readingId);

    public Reading create(Reading readingObj);

    public Reading update(Reading readingObj);

    public void delete(Reading readingObj);
}
