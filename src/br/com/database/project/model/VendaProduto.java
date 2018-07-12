package br.com.database.project.model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name = "venda_produto")
public class VendaProduto implements Serializable
{
	@Id
	@Column(name = "cod_venda")
	private BigDecimal codVenda;
	
	@NotNull
	@Column(name = "data_venda")
	private Date dataVenda;
	
	@NotNull
	@Column(name = "qtd_consumido")
	private String qtdConsumido;
	
	@NotNull
	@Column(name = "data_pagamento")
	private Date dataPagamento;
	
	@NotNull
	@Column(name = "cod_produto")
	private Fornecedor codProduto;
	
	@NotNull
	@Column(name = "cod_pessoa")
	private Fornecedor codPessoa;

	public BigDecimal getCodVenda() {
		return codVenda;
	}

	public void setCodVenda(BigDecimal codVenda) {
		this.codVenda = codVenda;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getQtdConsumido() {
		return qtdConsumido;
	}

	public void setQtdConsumido(String qtdConsumido) {
		this.qtdConsumido = qtdConsumido;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Fornecedor getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Fornecedor codProduto) {
		this.codProduto = codProduto;
	}

	public Fornecedor getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(Fornecedor codPessoa) {
		this.codPessoa = codPessoa;
	}
}