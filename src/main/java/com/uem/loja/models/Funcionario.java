package com.uem.loja.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionario  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;

	private String funcionario_nome_completo;
	private String funcionario_telefone;
	private String funcionario_rua;
	private String funcionario_bairro;
	private String funcionario_numero_casa;
	private String funcionario_cpf;
	
	@Deprecated
	protected Funcionario() {
		
	}
	
	
	/*Nome e CPF são dados obrigatórios*/
	public Funcionario(String funcionario_nome_completo, String funcionario_cpf) {
		super();
		this.funcionario_nome_completo = funcionario_nome_completo;
		this.funcionario_cpf = funcionario_cpf;
	}



	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getFuncionario_nome_completo() {
		return funcionario_nome_completo;
	}
	public void setFuncionario_nome_completo(String funcionario_nome_completo) {
		this.funcionario_nome_completo = funcionario_nome_completo;
	}
	public String getFuncionario_telefone() {
		return funcionario_telefone;
	}
	public void setFuncionario_telefone(String funcionario_telefone) {
		this.funcionario_telefone = funcionario_telefone;
	}
	public String getFuncionario_rua() {
		return funcionario_rua;
	}
	public void setFuncionario_rua(String funcionario_rua) {
		this.funcionario_rua = funcionario_rua;
	}
	public String getFuncionario_bairro() {
		return funcionario_bairro;
	}
	public void setFuncionario_bairro(String funcionario_bairro) {
		this.funcionario_bairro = funcionario_bairro;
	}
	public String getFuncionario_numero_casa() {
		return funcionario_numero_casa;
	}
	public void setFuncionario_numero_casa(String funcionario_numero_casa) {
		this.funcionario_numero_casa = funcionario_numero_casa;
	}
	public String getFuncionario_cpf() {
		return funcionario_cpf;
	}
	public void setFuncionario_cpf(String funcionario_cpf) {
		this.funcionario_cpf = funcionario_cpf;
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
		Funcionario other = (Funcionario) obj;
		return codigo == other.codigo;
	}
	@Override
	public String toString() {
		return "Funcionario [funcionario_nome_completo=" + funcionario_nome_completo + "]";
	}
	
	
}
