package com.uem.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class NotaController {
	@Controller
	public class RelatorioController {
		@RequestMapping("/gerarNota")
		public String gerarNota(){
			return "gerarNota";
		}

	}
}
