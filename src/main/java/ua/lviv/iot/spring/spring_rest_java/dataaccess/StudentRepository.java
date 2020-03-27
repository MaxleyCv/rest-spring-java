package ua.lviv.iot.spring.spring_rest_java.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.spring.spring_rest_java.rest.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
