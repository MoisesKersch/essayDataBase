package br.com.database.project.persistence.jpa;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Query;

import br.com.database.project.model.Produto;
import br.com.database.project.persistence.dao.ProdutoDao;

public class HProdutoDao extends HDao<Produto> implements ProdutoDao {
	
	public Produto getProduto(BigDecimal codProduto) throws Exception {
		String query = "SELECT obj FROM Produto obj WHERE obj.codProduto = :codProduto";

		Map<String, Object> parametros = new HashMap<String, Object>();

		parametros.put("codProduto", codProduto);

		return carrega(query, parametros);
	}

	@Override
	public boolean procedimentoAtualizaProduto(BigDecimal porcentagem) throws Exception 
	{
		Query q = getEntityManager().createNativeQuery("SELECT count(*) FROM procedimento_produto_atualiza("+ porcentagem +")");
		
		try {
			return (Boolean) q.getSingleResult();
		} catch (Exception e) {
			return false;
		}
	}
}
