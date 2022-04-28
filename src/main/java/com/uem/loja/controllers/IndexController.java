package com.uem.loja.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/indexCliente")
	public String index() {
		
		return "redirect:/clientes";
	}

	@RequestMapping("/indexFornecedor")
	public String indexFornecedor() {
		
		return "redirect:/fornecedores";
	}

	@RequestMapping("/indexFuncionario")
	public String indexFuncionario() {
		
		return "redirect:/funcionarios";
	}
	
}
