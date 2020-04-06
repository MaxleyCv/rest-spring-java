package ua.lviv.iot.spring.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Student_Subjects",
            joinColumns = {@JoinColumn(name = "subject_id", nullable = false)},
            inverseJoinColumns = @JoinColumn(name = "student_id", nullable = false))
    @JsonIgnoreProperties("subjects")
    private Set<Student> students;

    public Subject() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
