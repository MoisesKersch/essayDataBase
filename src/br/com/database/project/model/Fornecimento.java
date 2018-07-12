package br.com.database.project.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.internal.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name = "fornecimento")
public class Fornecimento implements Serializable
{
	@Id
	@Column(name = "cod_fornecimento")
	private BigDecimal codFornecimento;
	
	@NotNull
	@Column(name = "valor_fornecimento")
	private BigDecimal ValorFornecimento;
	
	@NotNull
	@Column(name = "qtd_fornecimento")
	private BigDecimal qtdFornecimento;
	
	@NotNull
	@Column(name = "data_fornecimento")
	private Date dataFornecimento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name = "cod_fornecedor")
	private Fornecedor codFornecedor;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="cod_produto")
	private Produto codProduto;
	
	public BigDecimal getCodFornecimento()
	{
		return codFornecimento;
	}

	public void setCodFornecimento(BigDecimal codFornecimento)
	{
		this.codFornecimento = codFornecimento;
	}

	public BigDecimal getValorFornecimento()
	{
		return ValorFornecimento;
	}

	public void setValorFornecimento(BigDecimal valorFornecimento)
	{
		ValorFornecimento = valorFornecimento;
	}

	public BigDecimal getQtdFornecimento()
	{
		return qtdFornecimento;
	}

	public void setQtdFornecimento(BigDecimal qtdFornecimento)
	{
		this.qtdFornecimento = qtdFornecimento;
	}

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	public Date getDataFornecimento()
	{
		return dataFornecimento;
	}

	public void setDataFornecimento(Date dataFornecimento)
	{
		this.dataFornecimento = dataFornecimento;
	}

	public Produto getCodProduto()
	{
		return codProduto;
	}

	public void setCodProduto(Produto codProduto)
	{
		this.codProduto = codProduto;
	}

	public void setCodFornecedor(Fornecedor codFornecedor)
	{
		this.codFornecedor = codFornecedor;
	}

	public Fornecedor getCodFornecedor()
	{
		return codFornecedor;
	}
}