package ua.lviv.iot.spring.spring_rest_java.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.spring_rest_java.dataaccess.StudentRepository;
import ua.lviv.iot.spring.spring_rest_java.rest.model.Student;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

}
