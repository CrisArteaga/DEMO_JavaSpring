package net.codejava.spring.dao;

import net.codejava.spring.model.Servicio;

import java.util.List;

/**
 * Defines DAO operations for the contact model.
 * @author www.codejava.net
 *
 */
public interface ServicioDAO {

    public void saveOrUpdate(Servicio servicio);

    public void delete(int servicioId);

    public Servicio get(int servicioId);

    public List<Servicio> list(int servicioId);
}