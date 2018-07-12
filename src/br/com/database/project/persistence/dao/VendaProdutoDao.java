package br.com.database.project.persistence.dao;

import java.util.List;

import br.com.database.project.model.VendaProduto;

public interface VendaProdutoDao extends Dao<VendaProduto>
{
	public List<VendaProduto> orderByDataVenda();
}
