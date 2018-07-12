package br.com.database.project.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.internal.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name = "produto")
public class Produto implements Serializable
{
	@Id
	@Column(name = "cod_produto")
	private BigDecimal codProduto;
	
	@NotNull
	@Column(name = "valor_venda")
	private BigDecimal valorVenda;
	
	@NotNull
	@Column(name = "desc_produto")
	private String descProduto;
	
	@NotNull
	@Column(name = "qtd_estoque")
	private BigDecimal qtdEstoque;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "codProduto")
    @JsonManagedReference
	private List<Fornecimento> fornecimento;

	public BigDecimal getCodProduto()
	{
		return codProduto;
	}

	public void setCodProduto(BigDecimal codProduto)
	{
		this.codProduto = codProduto;
	}

	public BigDecimal getValorVenda()
	{
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda)
	{
		this.valorVenda = valorVenda;
	}

	public String getDescProduto()
	{
		return descProduto;
	}

	public void setDescProduto(String descProduto)
	{
		this.descProduto = descProduto;
	}

	public BigDecimal getQtdEstoque()
	{
		return qtdEstoque;
	}

	public void setQtdEstoque(BigDecimal qtdEstoque)
	{
		this.qtdEstoque = qtdEstoque;
	}

	public List<Fornecimento> getFornecimento()
	{
		return fornecimento;
	}

	public void setFornecimento(List<Fornecimento> fornecimento)
	{
		this.fornecimento = fornecimento;
	}
	
}