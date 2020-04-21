package ua.lviv.iot.spring.rest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.rest.dataaccess.SubjectRepository;
import ua.lviv.iot.spring.rest.model.Subject;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }


    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }
}
