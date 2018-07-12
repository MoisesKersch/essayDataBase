//package br.com.adaptaconsultoria.amr.persistence.jpa;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.persistence.Query;
//
//import br.com.adaptaconsultoria.amr.model.RedeLinear;
//import br.com.adaptaconsultoria.amr.persistence.dao.RedeLinearDao;
//
///**
// *
// * @author Will Zaniol
// * @author www.adaptaconsultoria.com.br
// * @version 1.0.0
// *
// */
//public class HRedeLinearDao extends HDao<RedeLinear> implements RedeLinearDao
//{
//
//	@Override
//	public synchronized List<RedeLinear> carregaPorUsuario(String adUserId) throws Exception
//	{
//		String query = "SELECT obj FROM RedeLinear obj WHERE obj.adUserId = :adUserId";
//
//		Map<String, Object> parametros = new HashMap<String, Object>();
//		parametros.put("adUserId", adUserId);
//
//		return pesquisa(query, parametros);
//	}
//
//	@Override
//	public Boolean descente(String cBPartnerRaizId, String cBPartnerId) throws Exception
//	{
//		Query q = getEntityManager()
//				.createNativeQuery("SELECT amr_descendentelinear('" + cBPartnerRaizId + "', '" + cBPartnerId + "')");
//		String resultado = (String) q.getSingleResult();
//		return resultado.equalsIgnoreCase("Y");
//	}
//}