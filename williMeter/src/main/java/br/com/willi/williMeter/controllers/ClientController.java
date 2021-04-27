package br.com.willi.williMeter.controllers;

import br.com.willi.williMeter.models.Client;
import br.com.willi.williMeter.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private final ClientRepository clientRepository;

	@PostMapping("/save")
	public String save(Client client) {
		clientRepository.save(client);
		return "redirect:/listClient";
	}

	@GetMapping("/")
	public ModelAndView listClients() {
		Iterable<Client> clients = clientRepository.findAll();
		return new ModelAndView("client/listClients", "clients", clients);
	}

	@GetMapping("/{id}")
	public ModelAndView findById(@PathVariable long id) {
		Client client = clientRepository.findById(id);
		return new ModelAndView("client/listClient", "client", client);
	}

	@GetMapping("/register")
	public String registerClient() {
		return "client/registerClient";
	}



}
