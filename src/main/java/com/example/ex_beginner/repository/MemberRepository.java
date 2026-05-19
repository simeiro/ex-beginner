package com.example.ex_beginner.repository;

import com.example.ex_beginner.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MemberRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Member> MEMBER_ROW_MAPPER = new BeanPropertyRowMapper<>(Member.class);

    public List<Member> findByName(String name) {
        //language=sql
        String sql = """
                SELECT
                    id,
                    name,
                    age,
                    dep_id
                FROM
                    members
                WHERE
                    name LIKE :name
                ORDER BY
                    name
                """;
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("name", "%" + name + "%");

        return template.query(sql, param, MEMBER_ROW_MAPPER);
    }
}
