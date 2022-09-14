package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import net.codejava.spring.model.Servicio;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ClienteDAO interface.
 * @author www.codejava.net
 *
 */
public class ServicioDAOImpl implements ServicioDAO {

    private JdbcTemplate jdbcTemplate;

    public ServicioDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(Servicio servicio) {
        if (servicio.getId() > 0) {
            // update
            String sql = "UPDATE servicios SET id_cliente=?, Servicio=?, Fecha=?, "
                    + "Mecanico=?, Importe=? WHERE id=?";
            jdbcTemplate.update(sql, servicio.getId_cliente(), servicio.getServicio(),
                    servicio.getFecha(), servicio.getMecanico(), servicio.getImporte(), servicio.getId());
        } else {
            // insert
            String sql = "INSERT INTO servicios (id_cliente, Servicio, Fecha, Mecanico, Importe)"
                    + " VALUES (?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql,  servicio.getId_cliente(), servicio.getServicio(),
                    servicio.getFecha(), servicio.getMecanico(), servicio.getImporte());
        }

    }

    @Override
    public void delete(int servicioId) {
        String sql = "DELETE FROM servicios WHERE id=?";
        jdbcTemplate.update(sql, servicioId);
    }

    @Override
    public List<Servicio> list(int servicioId) {
        String sql = "SELECT * FROM servicios WHERE id_cliente=" + servicioId;
        List<Servicio> listServicio = jdbcTemplate.query(sql, new RowMapper<Servicio>() {

            @Override
            public Servicio mapRow(ResultSet rs, int rowNum) throws SQLException {
                Servicio aServicio = new Servicio();

                aServicio.setId(rs.getInt("id"));
                aServicio.setId_cliente(rs.getInt("id_cliente"));
                aServicio.setServicio(rs.getString("Servicio"));
                aServicio.setFecha(rs.getString("Fecha"));
                aServicio.setMecanico(rs.getString("Mecanico"));
                aServicio.setImporte(rs.getInt("Importe"));

                return aServicio;
            }

        });

        return listServicio;
    }

    @Override
    public Servicio get(int servicioId) {
        String sql = "SELECT * FROM servicios WHERE id=" + servicioId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Servicio>() {

            @Override
            public Servicio extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Servicio servicio = new Servicio();
                    servicio.setId(rs.getInt("id"));
                    servicio.setId_cliente(rs.getInt("id_cliente"));
                    servicio.setServicio(rs.getString("Servicio"));
                    servicio.setFecha(rs.getString("Fecha"));
                    servicio.setMecanico(rs.getString("Mecanico"));
                    servicio.setImporte(rs.getInt("Importe"));
                    return servicio;
                }

                return null;
            }

        });
    }

}