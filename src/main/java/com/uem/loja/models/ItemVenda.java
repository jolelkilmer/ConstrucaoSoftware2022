package com.uem.loja.models;

import java.io.Serializable;
import java.math.BigDecimal;

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
public class ItemVenda implements Serializable{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

    private Integer quantidade;

	//@Column(name = "valor_unitario")
	private BigDecimal valorUnitario;

	//@ManyToOne
	//@JoinColumn(name = "codigo_cerveja")
	private Produto produto;

	//@ManyToOne
	//@JoinColumn(name = "codigo_venda")
	private Venda venda;
    
}
