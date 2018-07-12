package br.com.database.project.persistence.dao;
import java.math.BigDecimal;
import java.util.List;

import br.com.database.project.model.Fornecimento;

public interface FornecimentoDao extends Dao<Fornecimento>
{
	public List<Fornecimento> listaFornecimento(BigDecimal codFornecimento);
	public Fornecimento getFornecimento(BigDecimal codFornecimento);
	public BigDecimal valorTotalDatas(String dInicial, String dFinal);
}
