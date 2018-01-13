package com.egen.solutions.controllers;

import com.egen.solutions.dataobject.Reading;
import com.egen.solutions.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/readings")
@CrossOrigin
public class ReadingApiController {

    @Autowired
    ReadingService readingService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Reading> listAll() {
        return readingService.listAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Reading getById(@PathVariable("id") String readingId) {
        return readingService.getById(readingId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Reading create(@RequestBody Reading readingObj) {
        return readingService.create(readingObj);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Reading update(@PathVariable("id") String readingId, @RequestBody Reading readingObj) {
        return readingService.update(readingId, readingObj);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") String readingId) {
        readingService.delete(readingId);
    }
}
