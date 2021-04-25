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
@RequestMapping("clients")
public class ClientController {

	private final ClientRepository clientRepository;
	
	@PostMapping
	public String save(Client client) {
		clientRepository.save(client);
		return "redirect:/registerClient";
	}	
	
	@RequestMapping()
	public ModelAndView listClients() {
		ModelAndView mv = new ModelAndView("client/clients");
		Iterable<Client> clients = clientRepository.findAll();
		mv.addObject("client", clients);
		return mv;
	}
}
