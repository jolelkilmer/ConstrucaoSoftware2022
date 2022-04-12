package com.uem.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uem.loja.models.Fornecedor;
import com.uem.loja.repository.FornecedorRepository;

@Controller
public class FornecedorController {

	@Autowired
	private FornecedorRepository fornecedorRepo;

	@RequestMapping(value = "/cadastrarFornecedor", method = RequestMethod.GET)
	public String form() {

		return "fornecedor/formFornecedor";
	}

	@RequestMapping(value = "/cadastrarFornecedor", method = RequestMethod.POST)
	public String form(Fornecedor fornecedor) {

		fornecedorRepo.save(fornecedor);

		return "redirect:/fornecedors";
	}

	@RequestMapping("/fornecedores")
	public ModelAndView listaFornecedor() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Fornecedor> fornecedores = fornecedorRepo.findAll();
		mv.addObject("fornecedores", fornecedores);
		return mv;
	}

	@RequestMapping("/removerFornecedor")
	public String removerFornecedor(long codigo) {
		Fornecedor fornecedor = fornecedorRepo.findByCodigo(codigo);
		fornecedorRepo.delete(fornecedor);
		return "redirect:/fornecedores";
	}
		
	@GetMapping("/editarFornecedor")
	public ModelAndView editarFornecedor(@RequestParam long codigo) {
		ModelAndView mav = new ModelAndView("fornecedor/editarFornecedor");
		Fornecedor fornecedor = fornecedorRepo.findByCodigo(codigo);
		mav.addObject("fornecedor", fornecedor);
		return mav;
	}
}
