package com.uem.loja.controllers;

import com.uem.loja.models.Cliente;
import com.uem.loja.models.Funcionario;
import com.uem.loja.models.Produto;
import com.uem.loja.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@RequestMapping(value = "/produtos/cadastrar", method = RequestMethod.GET)
	public String form() {

		return "produto/formProduto";
	}

	@RequestMapping(value = "/produtos/cadastrar", method = RequestMethod.POST)
	public String form(Produto produto) {

		produtoRepository.save(produto);

		return "redirect:/produtos";
	}

	@RequestMapping("/produtos")
	public ModelAndView listaProdutos() {
		ModelAndView mv = new ModelAndView("produto/indexProduto");
		Iterable<Produto> produtos = produtoRepository.findAll();
		mv.addObject("produtos", produtos);
		return mv;
	}

	@RequestMapping("/produtos/remover")
	public String removerProduto(long id) {
		Produto produto = produtoRepository.findById(id);
		produtoRepository.delete(produto);
		return "redirect:/produtos";
	}

	@GetMapping("/produtos/editar")
	public ModelAndView editarProduto(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("produto/editarProduto");
		Produto produto = produtoRepository.findById(id);
		mav.addObject("produtos", produto);
		return mav;
	}

}
