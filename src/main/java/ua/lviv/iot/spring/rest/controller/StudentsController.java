package ua.lviv.iot.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.spring.rest.business.StudentService;
import ua.lviv.iot.spring.rest.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RequestMapping("/students")
@RestController
public class StudentsController {

    private Map<Integer, Student> students = new HashMap<>();
    private AtomicInteger IdCounter = new AtomicInteger();

    @Autowired
    private StudentService studentService;


    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Student getStudent(final @PathVariable("id") Integer studentId) {
        return students.get(studentId);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Student createStudent(final @RequestBody Student student) {
        student.setId(IdCounter.incrementAndGet());
        students.put(student.getId(), student);
        studentService.createStudent(student);
        return student;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Student> deleteStudent(final @PathVariable("id") Integer studentId) {
        HttpStatus status = students.remove(studentId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        studentService.deleteStudent(studentId);
        return ResponseEntity.status(status).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Student> updateStudent(final @PathVariable("id") Integer studentId, final @RequestBody Student student) {
        HttpStatus status = students.put(studentId, student) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        studentService.updateStudent(studentId, student);
        return ResponseEntity.status(status).build();
    }

}
