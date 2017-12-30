package com.egen.solutions.service;

import com.egen.solutions.dataobject.Reading;

import java.util.List;

public interface ReadingService {

    List<Reading> listAll();

    Reading getById(String readingId);

    Reading create(Reading readingObj);

    Reading update(String readingId, Reading readingObj);

    void delete(String readingId);
}
