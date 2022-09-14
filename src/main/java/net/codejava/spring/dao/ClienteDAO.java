package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.Cliente;

/**
 * Defines DAO operations for the contact model.
 * @author www.codejava.net
 *
 */
public interface ClienteDAO {
	
	public void saveOrUpdate(Cliente clietne);
	
	public void delete(int clienteId);
	
	public Cliente get(int clienteId);
	
	public List<Cliente> list();
}
