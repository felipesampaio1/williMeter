package br.com.willi.williMeter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.willi.williMeter.models.Cliente;
import br.com.willi.williMeter.repository.ClienteRepository;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository cr; 
	
	@RequestMapping(value="/cadastrarCliente", method=RequestMethod.GET)
	public String form() {
		return "cliente/formCliente";
	}
	
	@RequestMapping(value="/cadastrarCliente", method=RequestMethod.POST)
	public String form(Cliente cliente) {
		cr.save(cliente);
		return "redirect:/cadastrarCliente ";
	}	
}