package br.com.database.project.persistence.dao;

import java.math.BigDecimal;

import br.com.database.project.model.Fornecedor;

public interface FornecedorDao extends Dao<Fornecedor>
{
	public Fornecedor getFornecedor(BigDecimal codFornecedor) throws Exception;
}
