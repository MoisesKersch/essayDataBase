package br.com.database.project.persistence.jpa;

import java.util.List;

import javax.persistence.Query;

import br.com.database.project.model.VendaProduto;
import br.com.database.project.persistence.dao.VendaProdutoDao;

public class HVendaProdutoDao extends HDao<VendaProduto> implements VendaProdutoDao 
{
	@SuppressWarnings("unchecked")
	public List<VendaProduto> orderByDataVenda() 
	{	
		Query q = getEntityManager().createNativeQuery("SELECT * FROM venda_produto ORDER BY data_venda;");
		
		List<VendaProduto> dataVenda = q.getResultList();
		
		try {
			return dataVenda;
		} catch (Exception e) {
			return null;
		}
	}
}	



