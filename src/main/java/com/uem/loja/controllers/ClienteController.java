package com.uem.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uem.loja.models.Cliente;
import com.uem.loja.repository.ClienteRepository;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepo;

	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.GET)
	public String form() {

		return "cliente/formCliente";
	}
	

	//Metodo para cadastrar novo cliente e salvar edição
	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.POST)
	public String form(Cliente cliente) {

		clienteRepo.save(cliente);

		return "redirect:/clientes";
	}

	@RequestMapping("/clientes")
	public ModelAndView listaCliente() {
		ModelAndView mv = new ModelAndView("cliente/indexCliente");
		Iterable<Cliente> clientes = clienteRepo.findAll();
		mv.addObject("clientes", clientes);
		return mv;
	}

	@RequestMapping("/removerCliente")
	public String removerCliente(long codigo) {
		Cliente cliente = clienteRepo.findByCodigo(codigo);
		clienteRepo.delete(cliente);
		return "redirect:/indexCliente";
	}
	
	@GetMapping("/editarCliente")
	public ModelAndView editarCliente(@RequestParam long codigo) {
		ModelAndView mav = new ModelAndView("cliente/editarCliente");
		Cliente cliente = clienteRepo.findByCodigo(codigo);
		mav.addObject("cliente", cliente);
		return mav;
	}

}