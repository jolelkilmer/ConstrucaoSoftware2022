package com.uem.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FuncionarioController {
	@RequestMapping("/cadastrarFuncionario")
	public String form(){
		return "formFuncionario";
	}
}
