package com.uem.loja.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.uem.loja.models.Cliente;
import com.uem.loja.models.Produto;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import com.uem.loja.repository.ClienteRepository;
import com.uem.loja.repository.ProdutoRepository;

@Controller
public class RelatoriosController {
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private ProdutoRepository produtoRepo;
	
	@RequestMapping("/relatorios")
	public ModelAndView relatorios() {
		ModelAndView mv = new ModelAndView("relatorio/relatoriosIndex");
		return mv;
	}

	@GetMapping(value = "/relatorioClientes", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<byte[]> downloadClientes() throws JRException, IOException {

		Iterable<Cliente> clientes = clienteRepo.findAll();

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource((Collection<?>) clientes);

		JasperReport compileReport = JasperCompileManager
				.compileReport(new FileInputStream("clientesRelatorio.jrxml"));

		JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, null, dataSource);

		byte data[] = JasperExportManager.exportReportToPdf(jasperPrint);

		System.err.println(data);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=relatorioClientes.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
	}
	
	@GetMapping(value = "/relatorioEstoque", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<byte[]> downloadProdutos() throws JRException, IOException {

		Iterable<Produto> produtos = produtoRepo.findAll();

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource((Collection<?>) produtos);

		JasperReport compileReport = JasperCompileManager
				.compileReport(new FileInputStream("produtosRelatorio.jrxml"));

		JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, null, dataSource);

		byte data[] = JasperExportManager.exportReportToPdf(jasperPrint);

		System.err.println(data);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=relatorioClientes.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
	}

}
