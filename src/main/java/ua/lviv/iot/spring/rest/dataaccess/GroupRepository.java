package ua.lviv.iot.spring.rest.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.spring.rest.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

}
