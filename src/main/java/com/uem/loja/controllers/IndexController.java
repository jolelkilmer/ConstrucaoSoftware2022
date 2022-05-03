package com.uem.loja.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("Login");
        return mv;
    }

	@RequestMapping("/indexVendas")
	public String indexVendas() {
		
		return "redirect:/vendas";
	}
	
	@RequestMapping("/indexRelatorios")
	public String indexRelatorios() {
		
		return "redirect:/relatorios";
	}
	
}
