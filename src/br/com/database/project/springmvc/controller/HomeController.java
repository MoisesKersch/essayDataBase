package br.com.database.project.springmvc.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.database.project.model.Fornecedor;
import br.com.database.project.model.Fornecimento;
import br.com.database.project.model.Produto;
import br.com.database.project.model.VendaProduto;
import br.com.database.project.persistence.DaoFactory;
import br.com.database.project.persistence.dao.FornecedorDao;
import br.com.database.project.persistence.dao.FornecimentoDao;
import br.com.database.project.persistence.dao.ProdutoDao;
import br.com.database.project.persistence.dao.VendaProdutoDao;


@SuppressWarnings("serial")
@Controller
@Scope("request")
public class HomeController implements Serializable
{
	private FornecedorDao fornecedorDao = DaoFactory.getInstance().getFornecedorDao();
	private FornecimentoDao fornecimentoDao = DaoFactory.getInstance().getFornecimentoDao();
	private ProdutoDao produtoDao = DaoFactory.getInstance().getProdutoDao();
	private VendaProdutoDao vendaProdutoDao = DaoFactory.getInstance().getVendaProdutoDao();
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView index(HttpSession session) throws Exception
	{
		ModelAndView model = new ModelAndView("home");
		model.addObject("fornecedor", fornecedorDao.lista());
		model.addObject("produto", produtoDao.lista());

		return model;
	}
	
	@RequestMapping(value = "/getfornecimento", method = RequestMethod.GET)
	public @ResponseBody List<Fornecimento> getFornecimento(HttpSession session) throws Exception
	{
		return fornecimentoDao.lista();
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody Fornecimento save (@ModelAttribute("fornecimento") Fornecimento fornecimento, BindingResult result, @RequestParam(value = "dataFornecimento", required = true) String dataFornecimento,
			@RequestParam(value = "codFornecedor", required = true) BigDecimal codFornecedor, @RequestParam(value = "codProduto", required = true) BigDecimal codProduto) throws Exception 
	{ 
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse(dataFornecimento);
        
        fornecimento.setDataFornecimento(date);
        fornecimento.setCodFornecimento(new BigDecimal(fornecimentoDao.getUniqueId()));
        
        
        fornecimento.setCodFornecedor(fornecedorDao.carregaPorId(codFornecedor));
        fornecimento.setCodProduto(produtoDao.carregaPorId(codProduto));
        
		try
		{
			fornecimentoDao.salva(fornecimento);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return fornecimento;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public @ResponseBody Fornecimento edit(Fornecimento fornecimento, BindingResult result, String dataFornecimento) throws Exception 
	{ 
		Fornecimento tempt = fornecimentoDao.carregaPorId(fornecimento.getCodFornecimento());
		
		fornecimento.setCodFornecedor(tempt.getCodFornecedor());
		fornecimento.setCodFornecimento(tempt.getCodFornecimento());
		fornecimento.setCodProduto(tempt.getCodProduto());

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");
		
		Date date = formatter.parse(dataFornecimento);
	
		fornecimento.setDataFornecimento(date);
		
		try
		{
			fornecimentoDao.atualiza(fornecimento);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return fornecimento;
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public @ResponseBody List<Fornecimento> remove (@ModelAttribute("fornecimento") Fornecimento fornecimento, BindingResult result) throws Exception 
	{ 
			try
			{
				fornecimentoDao.exclui(fornecimento);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			
			return fornecimentoDao.lista();
	}
	
	@RequestMapping(value = "/totalreceber", method = RequestMethod.POST)
	public @ResponseBody BigDecimal totalReceber(HttpSession session, String dataInicial, String dataFinal) throws ParseException
	{
		String [] a = dataInicial.split("/");
		String [] b = dataFinal.split("/");
		
		String dataInicialf = new String();
		String dataFinalf = new String();
		
		dataInicialf+=a[2]+"-";
		dataInicialf+=a[1]+"-";
		dataInicialf+=a[0];
		
		dataFinalf+=b[2]+"-";
		dataFinalf+=b[1]+"-";
		dataFinalf+=b[0];
		
		try {
			return fornecimentoDao.valorTotalDatas(dataInicialf, dataFinalf);
		} catch (Exception e) {
			return null;
		}
	}
	
	@RequestMapping(value = "/orderbydatavenda", method = RequestMethod.POST)
	public @ResponseBody List<VendaProduto> getOrderByDataVenda() throws Exception 
	{
		try {
		
			List<VendaProduto>  lista = vendaProdutoDao.orderByDataVenda();
			System.out.println(lista);
			return vendaProdutoDao.orderByDataVenda();
		} catch (Exception e) {
			return  null;
		}
	}
	
	@RequestMapping(value = "/procedimentoproduto", method = RequestMethod.POST)
	public @ResponseBody List<Produto> procedimentoAtualizaProduto(String porcentagem) throws Exception 
	{
		try {
			if (porcentagem != null && porcentagem != "")
				produtoDao.procedimentoAtualizaProduto(new BigDecimal(porcentagem));
		} catch (Exception e) {
			return null;
		}
		return produtoDao.lista();
	}
	
	@RequestMapping(value = "/getproduto", method = RequestMethod.POST)
	public @ResponseBody List<Produto> getProduto() throws Exception 
	{
		return produtoDao.lista();
	}
}
	
	