package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import net.codejava.spring.model.Cliente;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ClienteDAO interface.
 * @author www.codejava.net
 *
 */
public class ClienteDAOImpl implements ClienteDAO {

	private JdbcTemplate jdbcTemplate;
	
	public ClienteDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Cliente cliente) {
		if (cliente.getId() > 0) {
			// update
			String sql = "UPDATE clientes SET Nombre=?, ModCoche=?, Placa=?, "
						+ "Consideraciones=?, Telefono=? WHERE id=?";
			jdbcTemplate.update(sql, cliente.getNombre(), cliente.getModCoche(),
					cliente.getPlaca(), cliente.getConsideraciones(), cliente.getTelefono(), cliente.getId());
		} else {
			// insert
			String sql = "INSERT INTO clientes (Nombre, ModCoche, Placa, Consideraciones, Telefono)"
						+ " VALUES (?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql,  cliente.getNombre(), cliente.getModCoche(),
					cliente.getPlaca(), cliente.getConsideraciones(), cliente.getTelefono());
		}
		
	}

	@Override
	public void delete(int clienteId) {
		String sql = "DELETE FROM clientes WHERE id=?";
		jdbcTemplate.update(sql, clienteId);
	}

	@Override
	public List<Cliente> list() {
		String sql = "SELECT * FROM clientes";
		List<Cliente> listCliente = jdbcTemplate.query(sql, new RowMapper<Cliente>() {

			@Override
			public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
				Cliente aCliente = new Cliente();
	
				aCliente.setId(rs.getInt("id"));
				aCliente.setNombre(rs.getString("Nombre"));
				aCliente.setModCoche(rs.getString("ModCoche"));
				aCliente.setPlaca(rs.getString("Placa"));
				aCliente.setConsideraciones(rs.getString("Consideraciones"));
				aCliente.setTelefono(rs.getString("Telefono"));
				
				return aCliente;
			}
			
		});
		
		return listCliente;
	}

	@Override
	public Cliente get(int clienteId) {
		String sql = "SELECT * FROM clientes WHERE id=" + clienteId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Cliente>() {

			@Override
			public Cliente extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Cliente cliente = new Cliente();
					cliente.setId(rs.getInt("id"));
					cliente.setNombre(rs.getString("Nombre"));
					cliente.setModCoche(rs.getString("ModCoche"));
					cliente.setPlaca(rs.getString("Placa"));
					cliente.setConsideraciones(rs.getString("Consideraciones"));
					cliente.setTelefono(rs.getString("Telefono"));
					return cliente;
				}
				
				return null;
			}
			
		});
	}

}
