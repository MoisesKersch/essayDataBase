//package br.com.adaptaconsultoria.amr.springmvc.controller;
//
//import static org.springframework.web.bind.annotation.RequestMethod.GET;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import br.com.adaptaconsultoria.amr.model.Usuario;
//import br.com.adaptaconsultoria.amr.persistence.DaoFactory;
//import br.com.adaptaconsultoria.amr.persistence.dao.RedeLinearDao;
//import br.com.adaptaconsultoria.amr.persistence.dao.UsuarioDao;
//import br.com.adaptaconsultoria.amr.service.RedeLinearService;
//import br.com.adaptaconsultoria.amr.springmvc.util.SessionUtil;
//
///**
// *
// * @author Will Zaniol
// * @author www.adaptaconsultoria.com.br
// * @version 1.0.0
// *
// */
//@SuppressWarnings("serial")
//@Controller
//@Scope("request")
//public class RedeLinearController implements Serializable {
////
////	private UsuarioDao usuarioDao = DaoFactory.getInstance().getUsuarioDao();
//	private RedeLinearDao redeLinearDao = DaoFactory.getInstance().getRedeLinearDao();
//	private RedeLinearService redeLinearService = new RedeLinearService();
//
//	@RequestMapping(value = "/redelinear", method = GET)
//	public String inicio(HttpSession session) {
//		SessionUtil.setMenuAtivo(session, "redelinear");
//		SessionUtil.setSubMenuAtivo(session, "redelinear");
//		return "redelinear";
//	}
//
//	@RequestMapping(value = "/desenharedelinear", method = RequestMethod.GET)
//	public @ResponseBody List<String> desenhaArvoreLinear(@RequestParam("id") String id, HttpSession session, String selecionado) throws Exception {
//		List<String> lista = new ArrayList<String>();
//
//		String usuarioId = SessionUtil.getUsuarioId(session);
//
//		if (id == null) {
//			id = usuarioId;
//		}
//
//		if (SessionUtil.getReadOnly(session).equalsIgnoreCase("Y")) {
//			if (id.equals(usuarioId)) {
//				id = selecionado;
//			}
//		}
//
//		String adUserAnteriorId = null;
//		if (id.startsWith("ANTERIOR")) {
//			id = SessionUtil.getAttribute(session, "rede");
//			if (!id.equals(usuarioId)) {
//				if (SessionUtil.getReadOnly(session).equalsIgnoreCase("Y")) {
//					if (!id.equals(selecionado)) {
//						adUserAnteriorId = usuarioDao.carregaIDDoUsuarioPatrocinador(id);
//					}
//				}
//
//				else {
//					adUserAnteriorId = usuarioDao.carregaIDDoUsuarioPatrocinador(id);
//				}
//			}
//		}
//
//		if (adUserAnteriorId != null)
//			id = adUserAnteriorId;
//
//		lista = redeLinearService.montaRedeLinearHTML5(id);
//		SessionUtil.setAttribute(session, "rede", id);
//		return lista;
//	}
//
//	@RequestMapping(value = "/buscaredelinear", method = RequestMethod.GET)
//	public @ResponseBody List<String> buscaRedeLinear(@RequestParam("login") String login, HttpSession session, String selecionado) throws Exception {
//		List<String> lista = new ArrayList<String>();
//
//		Usuario usuario = usuarioDao.carregaPorCodigoDoParceiroDeNegocios(login);
//
//		if (usuario == null)
//			usuario = usuarioDao.carregaPorLogin(login);
//
//		if (usuario != null) {
//			Usuario logado = null;
//			if (SessionUtil.getReadOnly(session).equalsIgnoreCase("Y"))
//				logado = usuarioDao.carregaPorId(selecionado);
//			else
//				logado = usuarioDao.carregaPorId(SessionUtil.getUsuarioId(session));
//
//			boolean permite = redeLinearDao.descente(logado.getParceiroNegocios().getId(), usuario.getParceiroNegocios().getId());
//
//			if (permite) {
//				lista = redeLinearService.montaRedeLinearHTML5(usuario.getId());
//				SessionUtil.setAttribute(session, "rede", usuario.getId());
//			}
//		}
//
//		return lista;
//	}
//
//}