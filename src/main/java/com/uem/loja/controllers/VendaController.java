package com.uem.loja.controllers;

import com.uem.loja.models.Cliente;
import com.uem.loja.models.Funcionario;
import com.uem.loja.models.Produto;
import com.uem.loja.models.Venda;
import com.uem.loja.repository.ClienteRepository;
import com.uem.loja.repository.FuncionarioRepository;
import com.uem.loja.repository.ProdutoRepository;
import com.uem.loja.repository.VendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private ClienteRepository clienteRepository;

    @RequestMapping("/vendas")
	public ModelAndView listaVendas(Model model) {
		Cliente cliente = new Cliente("", "");
		ModelAndView mv = new ModelAndView("vendas/indexVendas");
		model.addAttribute("funcionario", new Funcionario());
		model.addAttribute("cliente", cliente);
		mv.addObject("cliente");
		return mv;
	}

	@RequestMapping(value = "/buscarDados")
	@ResponseBody
	public ModelAndView buscarCliente(@RequestParam(value = "codigoFuncionario", required = false, defaultValue = "0") long codigoFuncionario, @RequestParam(value = "codigoCliente", required = false, defaultValue = "0") long codigoCliente, Model model, @ModelAttribute("funcionario") Funcionario funcionarios, @ModelAttribute("cliente") Cliente clientes) {
		ModelAndView modelAndView = new ModelAndView("vendas/indexVendas");

		if(codigoFuncionario != 0){
			Funcionario funcionario = funcionarioRepository.findByCpf(Long.toString(codigoFuncionario));
			//Funcionario funcionario = funcionarioRepository.findByCodigo(codigoFuncionario);
			if(funcionario != null){
				modelAndView.addObject("funcionario", funcionario);
			}
		}
		
		if(codigoCliente != 0){
			Cliente cliente = clienteRepository.findByCodigo(codigoCliente);
			if(cliente != null){
				modelAndView.addObject("cliente", cliente);
			}
		}
		
		return modelAndView;
	}

}
