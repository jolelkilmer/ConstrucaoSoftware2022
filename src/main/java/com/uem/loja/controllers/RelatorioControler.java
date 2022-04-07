package com.uem.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class RelatorioControler {
	@Controller
	public class RelatorioController {
		@RequestMapping("/cadastrarRelatorio")
		public String form(){
			return "formRelatorio";
		}

	}
}