package br.com.database.project.persistence.jpa;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import br.com.database.project.model.Fornecimento;
import br.com.database.project.persistence.dao.FornecimentoDao;

public class HFornecimentoDao extends HDao<Fornecimento> implements FornecimentoDao
{
	@Override
	public List<Fornecimento> listaFornecimento(BigDecimal codFornecimento) 
	{
		String query = "SELECT obj FROM Fornecimento obj WHERE obj.codFornecimento = :codFornecimento";

		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("codFornecimento", codFornecimento);

		return pesquisa(query, parametros);
	}
	
	@Override
	public Fornecimento getFornecimento(BigDecimal codFornecimento) 
	{
		String query = "SELECT obj FROM Fornecimento obj WHERE obj.codFornecimento = :codFornecimento";

		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("codFornecimento", codFornecimento);

		return carrega(query, parametros);
	}
	
	public BigDecimal valorTotalDatas(String dInicial, String dFinal) 
	{	
		
		Query q = getEntityManager().createNativeQuery("SELECT valor_total_datas('"+ dInicial +"','"+ dFinal +"')");
		
		BigDecimal resultado = (BigDecimal) q.getSingleResult();
		try {
			return resultado;
		} catch (Exception e) {
			return null;
		}
	}
}


