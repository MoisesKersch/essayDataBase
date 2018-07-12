package br.com.database.project.persistence.jpa;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import br.com.database.project.model.Fornecedor;
import br.com.database.project.persistence.dao.FornecedorDao;

public class HFornecedorDao extends HDao<Fornecedor> implements FornecedorDao
{
	@Override
	public Fornecedor  getFornecedor(BigDecimal codFornecedor) throws Exception 
	{
		String query = "SELECT obj FROM Fornecedor obj WHERE obj.codFornecedor = :codFornecedor";

		Map<String, Object> parametros = new HashMap<String, Object>();
		
		parametros.put("codFornecedor", codFornecedor);

		return carrega(query, parametros);
	}
}


