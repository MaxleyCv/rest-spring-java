package ua.lviv.iot.spring.rest.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.spring.rest.model.Student;

import java.util.List;

@Repository

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByFirstName(String firstName);

    List<Student> findAllByFirstNameAndLastName(String firstName, String lastName);

    Student findBestStudent();
}
