package com.uem.loja.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "venda")
public class Venda implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private LocalDateTime dataCriacao;
	private BigDecimal valorDesconto;
	private BigDecimal valorTotal = BigDecimal.ZERO;

	//@ManyToOne
	//@JoinColumn(name = "codigo_cliente")
	private Cliente cliente;

	//@ManyToOne
	//@JoinColumn(name = "codigo_funcionario")
	private Funcionario funcionario;

}
