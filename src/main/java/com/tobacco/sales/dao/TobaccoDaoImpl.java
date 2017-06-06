package com.tobacco.sales.dao;

import com.tobacco.sales.entity.Tobacco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TobaccoDaoImpl {

    @Autowired
    private JdbcTemplate template;

    public List<Tobacco> getList() {

        List<Tobacco> list = template.query(
                "select * from tobacco",
                new RowMapper<Tobacco>() {
                    @Override
                    public Tobacco mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Tobacco entity = new Tobacco();
                        entity.setId(rs.getString("id"));
                        entity.setName(rs.getString("name"));
                        entity.setMfrs(rs.getString("mfrs"));
                        entity.setSpec(rs.getString("spec"));
                        entity.setPrice(rs.getFloat("price"));
                        entity.setDescription(rs.getString("description"));
                        entity.setUpdated(rs.getDate("updated").getTime());
                        return entity;
                    }
                }
        );

        return list;
    }

}
