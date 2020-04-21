package ua.lviv.iot.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.spring.rest.business.SubjectService;
import ua.lviv.iot.spring.rest.model.Subject;

import java.util.List;

@RequestMapping("/subjects")
@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public List<Subject> getAllGroups() {
        return subjectService.getAllSubjects();
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Subject createSubject(final @RequestBody Subject subject) {
        return subjectService.createSubject(subject);
    }

}
