package com.uem.loja.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uem.loja.models.Fornecedor;
import com.uem.loja.repository.FornecedorRepository;

@Controller
public class FornecedorController {

	@Autowired
	private FornecedorRepository fornecedorRepo;

	@RequestMapping(value = "/cadastrarFornecedor", method = RequestMethod.GET)
	public String form(Fornecedor fornecedor, Model model) {

		return "fornecedor/formFornecedor";
	}

	@RequestMapping(value = "/cadastrarFornecedor", method = RequestMethod.POST)
	public String form(Fornecedor fornecedor) {

		fornecedorRepo.save(fornecedor);

		return "redirect:/fornecedors";
	}

	@RequestMapping(value = "/editarFornecedor", method = RequestMethod.POST)
	public String editarFornecedor(@Valid @ModelAttribute("fornecedor") Fornecedor fornecedor, BindingResult resultado, RedirectAttributes redirect, long codigo, Model model) {
		if(resultado.hasErrors()) {
			redirect.addAttribute("codigo", codigo);
			return "redirect:/editarFornecedor?codigo={codigo}";
		}else {
			fornecedorRepo.save(fornecedor);

			return "redirect:/fornecedores";
		}
	}

	@RequestMapping("/fornecedores")
	public ModelAndView listaFornecedor() {
		ModelAndView mv = new ModelAndView("fornecedor/indexFornecedor");
		Iterable<Fornecedor> fornecedores = fornecedorRepo.findAll();
		mv.addObject("fornecedores", fornecedores);
		return mv;
	}

	@RequestMapping("/removerFornecedor")
	public String removerFornecedor(long codigo) {
		Fornecedor fornecedor = fornecedorRepo.findByCodigo(codigo);
		fornecedorRepo.delete(fornecedor);
		return "redirect:/indexFornecedor";
	}
	
	@GetMapping("/editarFornecedor")
	public ModelAndView editarFornecedor(@RequestParam long codigo) {
		ModelAndView mav = new ModelAndView("fornecedor/editarFornecedor");
		Fornecedor fornecedor = fornecedorRepo.findByCodigo(codigo);
		mav.addObject("fornecedor", fornecedor);
		return mav;
	}

}