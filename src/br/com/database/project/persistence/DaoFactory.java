package br.com.database.project.persistence;



import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import br.com.database.project.persistence.dao.FornecedorDao;
import br.com.database.project.persistence.dao.FornecimentoDao;
import br.com.database.project.persistence.dao.ProdutoDao;
import br.com.database.project.persistence.dao.VendaProdutoDao;

@SuppressWarnings("deprecation")
public class DaoFactory
{

	private static DaoFactory instance = null;

	public static DaoFactory getInstance()
	{
		if (instance == null)
			instance = new DaoFactory();
		return instance;
	}

	private DaoFactory()
	{
		super();
	}

	private BeanFactory factory;
	private static FornecedorDao FORNECEDOR_DAO = null;
	private static FornecimentoDao FORNECIMENTO_DAO = null;
	private static ProdutoDao PRODUTO_DAO = null;
	private static VendaProdutoDao VENDA_PRODUTO = null;
	
	public BeanFactory getFactory()
	{
		if (factory == null)
		{
			Resource configuration = new ClassPathResource("applicationContext.xml");
			factory = new XmlBeanFactory(configuration);
		}
		return factory;
	}

	public FornecedorDao getFornecedorDao()
	{
		if (FORNECEDOR_DAO == null)
			FORNECEDOR_DAO = (FornecedorDao) getFactory().getBean("FornecedorDao");
		return FORNECEDOR_DAO;
	}
	
	public FornecimentoDao getFornecimentoDao()
	{
		if (FORNECIMENTO_DAO == null)
			FORNECIMENTO_DAO = (FornecimentoDao) getFactory().getBean("FornecimentoDao");
		return FORNECIMENTO_DAO;
	}
	
	public ProdutoDao getProdutoDao()
	{
		if (PRODUTO_DAO == null)
			PRODUTO_DAO = (ProdutoDao) getFactory().getBean("ProdutoDao");
		return PRODUTO_DAO;
	}
	
	public VendaProdutoDao getVendaProdutoDao()
	{
		if (VENDA_PRODUTO == null)
			VENDA_PRODUTO = (VendaProdutoDao) getFactory().getBean("VendaProdutoDao");
		return VENDA_PRODUTO;
	}
}