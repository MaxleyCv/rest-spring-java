package ua.lviv.iot.spring.rest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.rest.dataaccess.StudentRepository;
import ua.lviv.iot.spring.rest.model.Student;

import java.util.List;

@Service

public class StudentService {
    @Autowired
    private StudentRepository studentRepository;


    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Integer id, Student newStudent) {
        Student student = studentRepository.getOne(id);
        student = newStudent;
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getAllStudentsByFirstName(String firstName) {
        return studentRepository.findAllByFirstName(firstName);
    }

}

