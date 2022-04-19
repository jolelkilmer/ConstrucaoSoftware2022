package com.uem.loja.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Cliente  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;

	@NotBlank(message="O nome não pode estar em branco!")
	private String cliente_nome_completo;
	
	private String cliente_telefone;
	private String cliente_rua;
	private String cliente_bairro;
	private String cliente_numero_casa;
	

	@CPF(message="Insira um CPF válido!")
	private String cliente_cpf;
	
	@Deprecated
	protected Cliente() {
		
	}
	
	
	/*Nome e CPF são dados obrigatórios*/
	public Cliente(String cliente_nome_completo, String cliente_cpf) {
		super();
		this.cliente_nome_completo = cliente_nome_completo;
		this.cliente_cpf = cliente_cpf;
	}



	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getCliente_nome_completo() {
		return cliente_nome_completo;
	}
	public void setCliente_nome_completo(String cliente_nome_completo) {
		this.cliente_nome_completo = cliente_nome_completo;
	}
	public String getCliente_telefone() {
		return cliente_telefone;
	}
	public void setCliente_telefone(String cliente_telefone) {
		this.cliente_telefone = cliente_telefone;
	}
	public String getCliente_rua() {
		return cliente_rua;
	}
	public void setCliente_rua(String cliente_rua) {
		this.cliente_rua = cliente_rua;
	}
	public String getCliente_bairro() {
		return cliente_bairro;
	}
	public void setCliente_bairro(String cliente_bairro) {
		this.cliente_bairro = cliente_bairro;
	}
	public String getCliente_numero_casa() {
		return cliente_numero_casa;
	}
	public void setCliente_numero_casa(String cliente_numero_casa) {
		this.cliente_numero_casa = cliente_numero_casa;
	}
	public String getCliente_cpf() {
		return cliente_cpf;
	}
	public void setCliente_cpf(String cliente_cpf) {
		this.cliente_cpf = cliente_cpf;
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
		Cliente other = (Cliente) obj;
		return codigo == other.codigo;
	}
	@Override
	public String toString() {
		return "Cliente [cliente_nome_completo=" + cliente_nome_completo + "]";
	}
	
	
}
