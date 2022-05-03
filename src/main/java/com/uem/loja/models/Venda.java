package com.uem.loja.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
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

	//@OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
	//private List<ItemVenda> itens = new ArrayList<>();
}
