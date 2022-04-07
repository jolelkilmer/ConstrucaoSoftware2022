package com.uem.loja.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/indexCliente")
	public String index() {
		
		return "redirect:/clientes";
	}
}
