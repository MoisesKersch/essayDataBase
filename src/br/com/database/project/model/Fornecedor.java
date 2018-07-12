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
@Table(name = "fornecedor")
public class Fornecedor implements Serializable
{
	@Id
	@Column(name = "cod_fornecedor")
	private BigDecimal codFornecedor;
	
	@NotNull
	@Column(name = "nome_fantasia")
	private String nomeFantasia;
	
	@NotNull
	@Column(name = "conta_bancaria")
	private BigDecimal contaBancaria;
	
	@NotNull
	@Column(name = "uf_fornecedor")
	private String ufFornecedor;
	
	@NotNull
	@Column(name = "agencia")
	private BigDecimal agencia;
	
	@NotNull
	@Column(name = "insc_estadual")
	private BigDecimal inscEstadual;
	
	@NotNull
	@Column(name = "endereco_fornecedor")
	private String enderecoFornecedor;
	
	@NotNull
	@Column(name = "cidade_fornecedor")
	private String cidadeFornecedor;
	
	@NotNull
	@Column(name = "razao_social")
	private String razaoSocial;
	
	@NotNull
	@Column(name = "cnpj")
	private String cnpj;
	
	@NotNull
	@Column(name = "telefone")
	private BigDecimal telefone;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "codFornecedor")
    @JsonManagedReference
    private List<Fornecimento> fornecimento;

	public List<Fornecimento> getFornecimento()
	{
		return fornecimento;
	}

	public void setFornecimento(List<Fornecimento> fornecimento)
	{
		this.fornecimento = fornecimento;
	}

	public BigDecimal getCodFornecedor()
	{
		return codFornecedor;
	}

	public void setCodFornecedor(BigDecimal codFornecedor)
	{
		this.codFornecedor = codFornecedor;
	}

	public String getNomeFantasia()
	{
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia)
	{
		this.nomeFantasia = nomeFantasia;
	}

	public BigDecimal getContaBancaria()
	{
		return contaBancaria;
	}

	public void setContaBancaria(BigDecimal contaBancaria)
	{
		this.contaBancaria = contaBancaria;
	}

	public String getUfFornecedor()
	{
		return ufFornecedor;
	}

	public void setUfFornecedor(String ufFornecedor)
	{
		this.ufFornecedor = ufFornecedor;
	}

	public BigDecimal getAgencia()
	{
		return agencia;
	}

	public void setAgencia(BigDecimal agencia)
	{
		this.agencia = agencia;
	}

	public BigDecimal getInscEstadual()
	{
		return inscEstadual;
	}

	public void setInscEstadual(BigDecimal inscEstadual)
	{
		this.inscEstadual = inscEstadual;
	}

	public String getEnderecoFornecedor()
	{
		return enderecoFornecedor;
	}

	public void setEnderecoFornecedor(String enderecoFornecedor)
	{
		this.enderecoFornecedor = enderecoFornecedor;
	}

	public String getCidadeFornecedor()
	{
		return cidadeFornecedor;
	}

	public void setCidadeFornecedor(String cidadeFornecedor)
	{
		this.cidadeFornecedor = cidadeFornecedor;
	}

	public String getRazaoSocial()
	{
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial)
	{
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj()
	{
		return cnpj;
	}

	public void setCnpj(String cnpj)
	{
		this.cnpj = cnpj;
	}

	public BigDecimal getTelefone()
	{
		return telefone;
	}

	public void setTelefone(BigDecimal telefone)
	{
		this.telefone = telefone;
	}
}