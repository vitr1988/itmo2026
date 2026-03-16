package ru.itmo.spring.lesson4.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itmo.spring.lesson4.dao.StudentDao;
import ru.itmo.spring.lesson4.model.Group;
import ru.itmo.spring.lesson4.model.Student;

import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StudentDaoJdbcImpl implements StudentDao {

    public static final RowMapper<Student> STUDENT_ROW_MAPPER = (rs, rowNum) -> {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setFirstName(rs.getString("first_name"));
        student.setLastName(rs.getString("last_name"));

        int groupId = rs.getInt("group_id");
        if (!rs.wasNull()) {
            Group group = new Group();
            group.setId(groupId);
            group.setName(rs.getString("group_name"));
            student.setGroup(group);
        }

        return student;
    };

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Optional<Student> findById(Long id) {
        return jdbcTemplate.query("""
                select st.id, st.first_name, st.last_name, g.id group_id, g.name group_name from students st
                left join groups g on st.group_id = g.id
                where st.id = :id
                """, Map.of("id", id), STUDENT_ROW_MAPPER)
                .stream().findFirst();
    }

    @Override
    public void insert(String firstName, String lastName) {
        jdbcTemplate.update("""
                insert into students(first_name, last_name)
                values (:firstName, :lastName)
                """, Map.of("firstName", firstName, "lastName", lastName));
        // "firstName" -> firstName
        // "lastName" -> lastName
    }

    @Override
    public void assignToGroup(Long id, Long groupId) {
        jdbcTemplate.update("""
                update students set group_id = :groupId
                where id = :id
                """, Map.of("id", id, "groupId", groupId));
    }
}
