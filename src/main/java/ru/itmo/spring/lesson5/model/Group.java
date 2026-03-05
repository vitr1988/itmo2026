package ru.itmo.spring.lesson5.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Entity
@ToString(exclude = "students")
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groups_seq_generator")
    @SequenceGenerator(name = "groups_seq_generator", sequenceName = "groups_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String groupName;

    @OneToMany(mappedBy = "group")
    private List<Student> students;
}
