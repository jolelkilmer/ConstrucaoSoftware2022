package com.uem.loja.models;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
//@Table(name="produtos", uniqueConstraints = @UniqueConstraint(columnNames = {"id", "fornecedor"}))
@Table(name="produtos")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String COD_BARRAS_OBRIGATORIO = "Você deve informar o código de barras do produto.";
	public static final String COR_OBRIGATORIA = "Você deve informar a cor do produto.";
	public static final String TAMANHO_OBRIGATORIO = "Você deve informar o tamanho do produto.";
	public static final String VALOR_INVALIDO = "O valor informado é inválido.";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "cod_barras", nullable = false, unique = true)
	private String cod_barras;

	@Column(name = "cor", nullable = false)
	private String cor;

	@Column(name = "valor", nullable = false)
	private double valor;

	@Column(name = "tamanho", nullable = false)
	private String tamanho;

	//@Column(name = "fornecedor", nullable = false)
	//private Fornecedor fornecedor;

	protected Produto() {}

	public Produto(String cod_barras, String cor, double valor, String tamanho) {
		super();
		validarProdutos(cod_barras, cor, valor, tamanho);
		this.cod_barras = cod_barras;
		this.cor = cor;
		this.valor = valor;
		this.tamanho = tamanho;
		//this.fornecedor = fornecedor;
	}

	public void alterarProduto(String cod_barras, String cor, double valor, String tamanho) {
		validarProdutos(cod_barras, cor, valor, tamanho);
		this.cod_barras = cod_barras;
		this.cor = cor;
		this.valor = valor;
		this.tamanho = tamanho;
		//this.fornecedor = fornecedor;
	}

	public void validarProdutos(String cod_barras, String cor, double valor, String tamanho) {
		Assert.hasText(cod_barras, COD_BARRAS_OBRIGATORIO);
		Assert.hasText(cor, COR_OBRIGATORIA);
		Assert.hasText(tamanho, TAMANHO_OBRIGATORIO);
		Assert.isTrue(valor > 0, VALOR_INVALIDO);
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public long getId() {
		return id;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getCod_barras() {
		return cod_barras;
	}

	public void setCod_barras(String cod_barras) {
		this.cod_barras = cod_barras;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public void setId(long id) {
		this.id = id;
	}

	/*public Fornecedor getFornecedor() {
		return fornecedor;
	}*/

	/*public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}*/

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Produto produtos = (Produto) o;
		return id == produtos.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Produtos{" +
				"id=" + id +
				", cod_barras='" + cod_barras + '\'' +
				", cor='" + cor + '\'' +
				", valor=" + valor +
				", tamanho='" + tamanho + '\'' +
				'}';
	}
}
