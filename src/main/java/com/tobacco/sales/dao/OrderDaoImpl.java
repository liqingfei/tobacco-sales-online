package com.tobacco.sales.dao;

import com.tobacco.sales.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderDaoImpl {

    @Autowired
    private JdbcTemplate template;

    public Order findById(String id) throws DataAccessException {
        Order order = template.query(
                "select * from orders where id = ?",
                new Object[]{id},
                new ResultSetExtractor<Order>() {
                    @Override
                    public Order extractData(ResultSet rs) throws SQLException, DataAccessException {
                        if (rs.next()) {
                            Order entity = new Order();
                            entity.setId(rs.getString("id"));
                            entity.setUsername(rs.getString("username"));
                            entity.setTobaccoId(rs.getString("tobacco_id"));
                            entity.setQuantity(rs.getInt("order_quantity"));
                            entity.setMoney(rs.getFloat("order_money"));
                            entity.setStatus(rs.getInt("status"));
                            entity.setUpdated(rs.getDate("order_time").getTime());
                            return entity;
                        } else {
                            return null;
                        }
                    }
                }
        );
        return order;
    }

    public List<Order> list(String username) throws DataAccessException {
        List<Order> list = template.query(
                "select * from orders where username = ?",
                new Object[] {
                        username
                },
                new RowMapper<Order>() {
                    @Override
                    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Order entity = new Order();
                        entity.setId(rs.getString("id"));
                        entity.setUsername(rs.getString("username"));
                        entity.setTobaccoId(rs.getString("tobacco_id"));
                        entity.setQuantity(rs.getInt("order_quantity"));
                        entity.setMoney(rs.getFloat("order_money"));
                        entity.setStatus(rs.getInt("status"));
                        entity.setUpdated(rs.getDate("order_time").getTime());
                        return entity;
                    }
                }
        );
        return list;
    }

    public List<Order> findByStatus(String username, int status) throws DataAccessException {
        List<Order> list = template.query(
                "select * from orders where username=? and status = ?",
                new Object[]{
                        username,
                        status
                },
                new RowMapper<Order>() {
                    @Override
                    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Order entity = new Order();
                        entity.setId(rs.getString("id"));
                        entity.setUsername(rs.getString("username"));
                        entity.setTobaccoId(rs.getString("tobacco_id"));
                        entity.setQuantity(rs.getInt("order_quantity"));
                        entity.setMoney(rs.getFloat("order_money"));
                        entity.setStatus(rs.getInt("status"));
                        entity.setUpdated(rs.getDate("order_time").getTime());
                        return entity;
                    }
                }
        );
        return list;
    }

    public Order create(Order order) throws DataAccessException {
        int rows = template.update(
                "insert into orders (`id`, `username`, `tobacco_id`, `order_quantity`, `order_money`, `status`, `order_time`) values (?, ?, ?, ?, ?, ?, now())",
                new Object[] {
                        order.getId(),
                        order.getUsername(),
                        order.getTobaccoId(),
                        order.getQuantity(),
                        order.getMoney(),
                        order.getStatus()
                }
        );

        if (rows != 1) {
            throw new DataRetrievalFailureException("no data created.");
        }

        Order created = findById(order.getId());

        return created;
    }

    public Order updateStatus(String id, int status) throws DataAccessException {
        int rows = template.update(
                "update orders set status = ? where id = ?",
                new Object[]{
                        status,
                        id
                }
        );

        if (rows != 1) {
            throw new DataRetrievalFailureException("no data created.");
        }

        Order updated = findById(id);

        return updated;

    }

}
