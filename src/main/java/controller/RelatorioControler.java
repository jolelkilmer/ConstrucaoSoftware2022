package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class RelatorioControler {
	@Controller
	public class RelatorioController {
		@ReqestMapping("/cadastrarRelatorio")
		public String form(){
			return "formRelatorio";
		}

	}
}