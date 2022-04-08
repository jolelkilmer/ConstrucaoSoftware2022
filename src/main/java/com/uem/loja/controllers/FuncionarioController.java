package com.uem.loja.controllers;

import com.uem.loja.models.Funcionario;
import com.uem.loja.repository.FuncionarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@RequestMapping(value = "/cadastrarFuncionario", method = RequestMethod.GET)
	public String form() {

		return "funcionario/formFuncionario";
	}
	

	//Metodo para cadastrar novo funcionario e salvar edição
	@RequestMapping(value = "/cadastrarFuncionario", method = RequestMethod.POST)
	public String form(Funcionario funcionario) {

		funcionarioRepository.save(funcionario);

		return "redirect:/funcionarios";
	}

	@RequestMapping("/funcionarios")
	public ModelAndView listaFuncionario() {
		ModelAndView mv = new ModelAndView("funcionario/indexFuncionario");
		Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
		mv.addObject("funcionarios", funcionarios);
		return mv;
	}

	@RequestMapping("/removerFuncionario")
	public String removerFuncionario(long codigo) {
		Funcionario funcionario = funcionarioRepository.findByCodigo(codigo);
		funcionarioRepository.delete(funcionario);
		return "redirect:/indexFuncionario";
	}

	@GetMapping("/editarFuncionario")
	public ModelAndView editarFuncionario(@RequestParam long codigo) {
		ModelAndView mav = new ModelAndView("funcionario/editarFuncionario");
		Funcionario funcionario = funcionarioRepository.findByCodigo(codigo);
		mav.addObject("funcionario", funcionario);
		return mav;
	}	
	
}

	
