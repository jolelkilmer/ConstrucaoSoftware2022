package com.uem.loja.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uem.loja.models.Cliente;
import com.uem.loja.repository.ClienteRepository;

@Controller
public class ClienteController {
	

	@Autowired
	private ClienteRepository clienteRepo;

	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.GET)
	public String form(Cliente cliente, Model model) {
		

		return "cliente/formCliente";
	}
	

	//Metodo para cadastrar novo cliente
	
	@RequestMapping(value = "/cadastrarCliente", method = RequestMethod.POST)
	public String form(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult resultado) {
		if(resultado.hasErrors()) {
			return "cliente/formCliente";
		}

		clienteRepo.save(cliente);

		return "redirect:/clientes";
	}
	
	@RequestMapping(value = "/editarCliente", method = RequestMethod.POST)
	public String editarCliente(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult resultado, RedirectAttributes redirect, long codigo, Model model) {
		if(resultado.hasErrors()) {
			redirect.addAttribute("codigo", codigo);
			return "redirect:/editarCliente?codigo={codigo}";
		}else {
			clienteRepo.save(cliente);

			return "redirect:/clientes";
		}
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