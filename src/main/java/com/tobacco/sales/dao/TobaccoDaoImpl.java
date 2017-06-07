package com.tobacco.sales.dao;

import com.tobacco.sales.entity.Tobacco;
import com.tobacco.sales.entity.TobaccoQuantity;
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
public class TobaccoDaoImpl {

    @Autowired
    private JdbcTemplate template;

    public List<Tobacco> getList() throws DataAccessException {

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

    public Tobacco create(Tobacco tobacco) throws DataAccessException {
        template.update(
                "insert into tobacco (`id`, `name`, `mfrs`, `spec`, `price`, `description`) values (?, ?, ?, ?, ?, ?)",
                new Object[] {tobacco.getId(), tobacco.getName(), tobacco.getMfrs(), tobacco.getSpec(), tobacco.getPrice(), tobacco.getDescription()}
        );
        Tobacco created = findById(tobacco.getId());
        return created;
    }

    public Tobacco update(Tobacco tobacco) throws DataAccessException {
        int rows = template.update(
                "update tobacco set name = ?, mfrs = ?, spec = ?, price = ?, description = ? where id = ?",
                new Object[] {
                        tobacco.getName(),
                        tobacco.getMfrs(),
                        tobacco.getSpec(),
                        tobacco.getPrice(),
                        tobacco.getDescription(),
                        tobacco.getId()
                }
        );

        if (rows != 1) {
            throw new DataRetrievalFailureException("no data updated.");
        }

        Tobacco updated = findById(tobacco.getId());

        return updated;

    }

    public void delete(String id) throws DataAccessException {
        int rows = template.update(
                "delete from tobacco where id = ?",
                new Object[] {id}
        );
        if (rows != 1) {
            throw new DataRetrievalFailureException("no data deleted.");
        }

    }

    public Tobacco findById(String id) throws DataAccessException {
        Tobacco tobacco = template.query(
                "select * from tobacco where id = ?",
                new Object[]{id},
                new ResultSetExtractor<Tobacco>() {
                    @Override
                    public Tobacco extractData(ResultSet rs) throws SQLException, DataAccessException {
                        if (rs.next()) {
                            Tobacco entity = new Tobacco();
                            entity.setId(rs.getString("id"));
                            entity.setName(rs.getString("name"));
                            entity.setMfrs(rs.getString("mfrs"));
                            entity.setSpec(rs.getString("spec"));
                            entity.setPrice(rs.getFloat("price"));
                            entity.setDescription(rs.getString("description"));
                            entity.setUpdated(rs.getDate("updated").getTime());
                            return entity;
                        } else {
                            return null;
                        }
                    }
                }
        );
        return tobacco;
    }

    public TobaccoQuantity create(TobaccoQuantity quantity) throws DataAccessException {
        template.update(
                "insert into tobacco_quantity (`tobacco_id`, `quantity`, `status`) values (?, ?, ?)",
                new Object[] {
                        quantity.getTobaccoId(),
                        quantity.getQuantity(),
                        quantity.getStatus()
                }
        );

        TobaccoQuantity created = findByTobaccoId(quantity.getTobaccoId());
        return created;
    }

    public TobaccoQuantity update(TobaccoQuantity quantity) throws DataAccessException {
        int rows = template.update(
                "update tobacco_quantity set quantity = ?, status = ? where tobacco_id = ?",
                new Object[] {
                        quantity.getQuantity(),
                        quantity.getStatus(),
                        quantity.getTobaccoId()
                }
        );

        if (rows != 1) {
            throw new DataRetrievalFailureException("no data updated.");
        }

        TobaccoQuantity updated = findByTobaccoId(quantity.getTobaccoId());

        return updated;

    }

    public void deleteByTobaccoId(String tobaccoId) throws DataAccessException {
        int rows = template.update(
                "delete from tobacco_quantity where tobacco_id = ?",
                new Object[] {tobaccoId}
        );
        if (rows != 1) {
            throw new DataRetrievalFailureException("no data deleted.");
        }
    }

    public TobaccoQuantity findByTobaccoId(String id) throws DataAccessException {

        TobaccoQuantity quantity = template.query(
                "select * from tobacco_quantity where tobacco_id = ?",
                new Object[]{id},
                new ResultSetExtractor<TobaccoQuantity>() {
                    @Override
                    public TobaccoQuantity extractData(ResultSet rs) throws SQLException, DataAccessException {
                        if (rs.next()) {
                            TobaccoQuantity entity = new TobaccoQuantity();
                            entity.setId(rs.getLong("id"));
                            entity.setTobaccoId(rs.getString("tobacco_id"));
                            entity.setQuantity(rs.getInt("quantity"));
                            entity.setStatus(rs.getInt("status"));
                            entity.setUpdated(rs.getDate("updated").getTime());
                            return entity;
                        } else {
                            return null;
                        }

                    }
                }
        );

        return quantity;
    }

}
