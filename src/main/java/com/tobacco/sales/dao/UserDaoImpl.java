package com.tobacco.sales.dao;

import com.tobacco.sales.entity.Role;
import com.tobacco.sales.entity.User;
import com.tobacco.sales.entity.UserAttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl {

    @Autowired
    private JdbcTemplate template;

    public List<User> getList() throws DataAccessException {
        List<User> list = template.query(
                "select * from users",
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        User entity = new User();
                        entity.setUsername(rs.getString("username"));
                        entity.setPassword(rs.getString("passwd"));
                        entity.setStatus(rs.getInt("status"));
                        entity.setUpdated(rs.getDate("updated").getTime());
                        return entity;
                    }
                }
        );

        return list;
    }

    public User findByName(String username) throws DataAccessException {
        User user = template.query(
                "select * from users where username = ?",
                new Object[]{username},
                new ResultSetExtractor<User>() {
                    @Override
                    public User extractData(ResultSet rs) throws SQLException, DataAccessException {
                        if (rs.next()) {
                            User entity = new User();
                            entity.setUsername(rs.getString("username"));
                            entity.setPassword(rs.getString("passwd"));
                            entity.setStatus(rs.getInt("status"));
                            entity.setUpdated(rs.getDate("updated").getTime());
                            return entity;
                        } else {
                            return null;
                        }
                    }
                }
        );
        return user;
    }

    public List<Role> findRolesWithUser(String username) throws DataAccessException {
        List<Role> list = template.query(
                "select * from user_roles where username = ?",
                new Object[]{username},
                new RowMapper<Role>() {
                    @Override
                    public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Role entity = new Role();
                        entity.setUsername(rs.getString("username"));
                        entity.setRolename(rs.getString("rolename"));
                        entity.setUpdated(rs.getDate("updated").getTime());
                        return entity;
                    }
                }
        );
        return list;
    }

    public List<UserAttr> findAttrsWithUser(String username) throws DataAccessException {
        List<UserAttr> list = template.query(
                "select * from user_attrs where username = ?",
                new Object[]{username},
                new RowMapper<UserAttr>() {
                    @Override
                    public UserAttr mapRow(ResultSet rs, int rowNum) throws SQLException {
                        UserAttr entity = new UserAttr();
                        entity.setUsername(rs.getString("username"));
                        entity.setName(rs.getString("name"));
                        entity.setValue(rs.getString("value"));
                        entity.setUpdated(rs.getDate("updated").getTime());
                        return entity;
                    }
                }
        );

        return list;
    }
}