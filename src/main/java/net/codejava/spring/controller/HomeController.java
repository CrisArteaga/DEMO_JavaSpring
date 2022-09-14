package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.ServicioDAO;
import net.codejava.spring.dao.ClienteDAO;

import net.codejava.spring.model.Cliente;
import net.codejava.spring.model.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * This controller routes accesses to the application to the appropriate
 * hanlder methods. 
 * @author www.codejava.net
 *
 */
@Controller
public class HomeController {

	@Autowired
	private ClienteDAO clienteDAO;
	@Autowired
	private ServicioDAO servicioDAO;
	private int servicioId;
	private String name;

	@RequestMapping(value="/")
	public ModelAndView listCliente(ModelAndView model) throws IOException{
		List<Cliente> listCliente = clienteDAO.list();
		model.addObject("listCliente", listCliente);
		model.setViewName("home");

		return model;
	}
	@RequestMapping(value="clientes")
	public ModelAndView listClientes(ModelAndView model) throws IOException{
		List<Cliente> listCliente = clienteDAO.list();
		model.addObject("listCliente", listCliente);
		model.setViewName("home");

		return model;
	}
	@RequestMapping(value="/HomeServicio", method = RequestMethod.GET)
	public ModelAndView listServicio(ModelAndView model) throws IOException{
		List<Servicio> listServicio = servicioDAO.list(servicioId);
		model.addObject("listServicio", listServicio);
		model.setViewName("home_servicio");

		return model;
	}
	
	@RequestMapping(value = "/newCliente", method = RequestMethod.GET)
	public ModelAndView newCliente(ModelAndView model) {
		Cliente newCliente = new Cliente();
		model.addObject("cliente", newCliente);
		model.setViewName("ClienteForm");
		return model;
	}
	@RequestMapping(value = "/newServicio", method = RequestMethod.GET)
	public ModelAndView newServicio(HttpServletRequest request, ModelAndView model) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Servicio newServicio = new Servicio();
		model.addObject("servicio", newServicio);
		model.setViewName("ServicioForm");
		model.addObject("id", id);
		model.addObject("name", name);
		return model;
	}
	
	@RequestMapping(value = "/saveCliente", method = RequestMethod.POST)
	public ModelAndView saveCliente(@ModelAttribute Cliente cliente) {
		clienteDAO.saveOrUpdate(cliente);
		return new ModelAndView("redirect:/");
	}
	@RequestMapping(value = "/saveServicio", method = RequestMethod.GET)
	public ModelAndView saveServicio(HttpServletRequest request, @ModelAttribute Servicio servicio) {
		servicioDAO.saveOrUpdate(servicio);
		int id = Integer.parseInt(request.getParameter("id_cliente"));
		String name = request.getParameter("name");
		ModelAndView model = new ModelAndView("redirect:/HomeServicio");
		model.addObject("id", id);
		model.addObject("name", name);

		return model;
	}
	
	@RequestMapping(value = "/deleteCliente", method = RequestMethod.GET)
	public ModelAndView deleteCliente(HttpServletRequest request) {
		int clienteId = Integer.parseInt(request.getParameter("id"));
		clienteDAO.delete(clienteId);
		return new ModelAndView("redirect:/");
	}
	@RequestMapping(value = "/deleteServicio", method = RequestMethod.GET)
	public ModelAndView deleteServicio(HttpServletRequest request) {
		int servicioId = Integer.parseInt(request.getParameter("id1"));
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		servicioDAO.delete(servicioId);
		ModelAndView model = new ModelAndView("redirect:/HomeServicio");
		model.addObject("id", id);
		model.addObject("name", name);

		return model;
	}
	
	@RequestMapping(value = "/editCliente", method = RequestMethod.GET)
	public ModelAndView editCliente(HttpServletRequest request) {
		int clienteId = Integer.parseInt(request.getParameter("id"));
		Cliente cliente = clienteDAO.get(clienteId);
		ModelAndView model = new ModelAndView("ClienteForm");
		model.addObject("cliente", cliente);
		
		return model;
	}
	@RequestMapping(value = "/editServicio", method = RequestMethod.GET)
	public ModelAndView editServicio(HttpServletRequest request) {
		int servicioId = Integer.parseInt(request.getParameter("id1"));
		String id = request.getParameter("id");
		Servicio servicio = servicioDAO.get(servicioId);
		ModelAndView model = new ModelAndView("ServicioForm");
		model.addObject("servicio", servicio);

		return model;
	}

	@RequestMapping(value = "/Servicios", method = RequestMethod.GET)
	public ModelAndView Servicios(HttpServletRequest request) {
		servicioId = Integer.parseInt(request.getParameter("id"));
		name = request.getParameter("name");
		Servicio servicio = servicioDAO.get(servicioId);
		ModelAndView model = new ModelAndView("redirect:/HomeServicio");
		model.addObject("id", servicioId);
		model.addObject("name", name);
		model.addObject("servicio", servicio);

		return model;
	}
}
