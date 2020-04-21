package ua.lviv.iot.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.spring.rest.business.StudentService;
import ua.lviv.iot.spring.rest.model.Student;

import java.util.List;

@RequestMapping("/students")
@RestController
public class StudentsController {

    @Autowired
    private StudentService studentService;


    @GetMapping
    public List<Student> getStudents(final @RequestParam(value = "firstName", required = false) String firstName) {
        if (firstName == null) {
            return studentService.getAllStudents();
        }
        return studentService.getAllStudentsByFirstName(firstName);
    }

    @GetMapping(path = "/{id}")
    public Student getStudent(final @PathVariable("id") Integer studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Student createStudent(final @RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Student> deleteStudent(final @PathVariable("id") Integer studentId) {
        Student studentToCheck = studentService.getStudentById(studentId);
        if (studentToCheck != null) {
            studentService.deleteStudent(studentId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Student> updateStudent(final @PathVariable("id") Integer studentId, final @RequestBody Student student) {
        Student studentToCheck = studentService.getStudentById(studentId);
        if (studentToCheck != null) {
            studentService.updateStudent(studentId, student);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
