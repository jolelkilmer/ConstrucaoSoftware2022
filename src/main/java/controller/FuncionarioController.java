package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FuncionarioController {
	@ReqestMapping("/cadastrarFuncionario")
	public String form(){
		return "formFuncionario";
	}
}
