package br.com.database.project.persistence.dao;
import java.math.BigDecimal;

import br.com.database.project.model.Produto;

public interface ProdutoDao extends Dao<Produto>
{
	public Produto getProduto(BigDecimal codProduto) throws Exception;
	public boolean procedimentoAtualizaProduto(BigDecimal porcentagem) throws Exception;
}
