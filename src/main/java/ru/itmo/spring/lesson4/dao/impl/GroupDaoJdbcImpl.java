package ru.itmo.spring.lesson4.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itmo.spring.lesson4.dao.GroupDao;
import ru.itmo.spring.lesson4.model.Group;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GroupDaoJdbcImpl implements GroupDao {

    private static final RowMapper<Group> GROUP_ROW_MAPPER =
            (rs, rowNum) -> new Group(rs.getInt("id"), rs.getString("name"));

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Group> findAll() {
        return jdbcTemplate.query("""
                select * from groups
                order by id
                """, GROUP_ROW_MAPPER);
    }

    @Override
    public Optional<Group> findById(Integer id) {
        return jdbcTemplate.query("""
                select * from groups
                where id = :id
                """, Map.of("id", id), GROUP_ROW_MAPPER)
                .stream().findFirst();
    }

    @Override
    public void insert(String name) {
        jdbcTemplate.update("""
                insert into groups(name)
                values(:name)
                """, Map.of("name", name));
    }

    @Override
    public void update(Integer id, String name) {
        jdbcTemplate.update("""
                update groups set name = :name
                where id = :id
                """, Map.of("id", id, "name", name));
    }

    @Override
    public void deleteById(Integer id) {
        jdbcTemplate.update("""
                delete from groups
                where id = :id
                """, Map.of("id", id));
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("""
                delete from groups
                where name = :name
                """, Map.of("name", name));
    }
}
