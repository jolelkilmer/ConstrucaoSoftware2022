package com.uem.loja.models;

import java.io.Serializable;
import java.util.Objects;
import org.springframework.util.Assert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;


@Entity
public class Fornecedor  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;

	@NotBlank(message="O nome não pode estar em branco!")
	private String fornecedor_nome_completo;
	
	private String fornecedor_telefone;
	private String fornecedor_rua;
	private String fornecedor_bairro;
	private String fornecedor_numero_comercial;

	@CNPJ(message="Insira um CNPJ válido!")
	private String fornecedor_cnpj;
	
	@Deprecated
	protected Fornecedor() {
		
	}
	
	/*Nome e CNPJ são dados obrigatórios*/
	public Fornecedor(String fornecedor_nome_completo, String fornecedor_cnpj) {
		super();
		this.fornecedor_nome_completo = fornecedor_nome_completo;
		this.fornecedor_cnpj = fornecedor_cnpj;
	}



	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getFornecedor_nome_completo() {
		return fornecedor_nome_completo;
	}
	public void setFornecedor_nome_completo(String fornecedor_nome_completo) {
		this.fornecedor_nome_completo = fornecedor_nome_completo;
	}
	public String getFornecedor_telefone() {
		return fornecedor_telefone;
	}
	public void setFornecedor_telefone(String fornecedor_telefone) {
		this.fornecedor_telefone = fornecedor_telefone;
	}
	public String getFornecedor_rua() {
		return fornecedor_rua;
	}
	public void setFornecedor_rua(String fornecedor_rua) {
		this.fornecedor_rua = fornecedor_rua;
	}
	public String getFornecedor_bairro() {
		return fornecedor_bairro;
	}
	public void setFornecedor_bairro(String fornecedor_bairro) {
		this.fornecedor_bairro = fornecedor_bairro;
	}
	public String getFornecedor_numero_comercial() {
		return fornecedor_numero_comercial;
	}
	public void setFornecedor_numero_comercial(String fornecedor_numero_comercial) {
		this.fornecedor_numero_comercial = fornecedor_numero_comercial;
	}
	public String getFornecedor_cnpj() {
		return fornecedor_cnpj;
	}
	public void setFornecedor_cnpj(String fornecedor_cnpj) {
		this.fornecedor_cnpj = fornecedor_cnpj;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		return codigo == other.codigo;
	}
	@Override
	public String toString() {
		return "Fornecedor [fornecedor_nome_completo=" + fornecedor_nome_completo + "]";
	}
	
	
}
