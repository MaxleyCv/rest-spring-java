package ua.lviv.iot.spring.rest.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.spring.rest.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}