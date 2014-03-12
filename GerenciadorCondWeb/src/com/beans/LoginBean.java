package com.beans;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.event.CloseEvent;

import com.helpers.LoginHelper;
import com.interfaces.ejb.UsuarioEJBLocal;
import com.util.Constants;
import com.util.SessionMapUtil;
import com.vo.Usuario;

/**
 * @author Jaques Loesch (jaques.loesch@teclogica.com.br)
 * 
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean extends BaseBean {

	private static final Logger LOGGER = Logger.getLogger(LoginBean.class);

	/*
	 * EJB's
	 */
//	@EJB
	private UsuarioEJBLocal usuarioEJB;

	/*
	 * Helper's
	 */
	private LoginHelper loginHelper;

	/*
	 * Variable's
	 */
	private Usuario usuario;

	public LoginBean() {
	}

	@PostConstruct
	public void init() {
		loginHelper = new LoginHelper(usuarioEJB);

		usuario = new Usuario();

	}

	Boolean exibePDF = false;

	public void login() {
		try {
			if (usuario.getSenha() == null || "".equals(usuario.getSenha())) {
				addMessage(FacesMessage.SEVERITY_WARN, "Senha é necessária");
				return;
			}

			usuario = loginHelper.autenticar(usuario);
			if (usuario != null) {

				SessionMapUtil.putValue(Constants.USER_LOGGED, usuario);

				redirect("home.xhtml");

			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * Faz o logout da aplicação
	 * 
	 * @author Jaques Loesch (jaques.loesch@teclogica.com.br)
	 * @created 26/06/2013 14:28:03
	 * 
	 * @return
	 */
	public void logout() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externaContext = facesContext.getExternalContext();
		externaContext.getSessionMap().clear();
		externaContext.invalidateSession();

		try {
			redirect("index.xhtml");
		} catch (Exception e) {

		}
	}

	public void handleClose(CloseEvent event) {
		logout();
		usuario = new Usuario();
	}

	/**
	 * Determina se o usuáio está logado
	 * 
	 * @author Jaques Loesch (jaques.loesch@teclogica.com.br)
	 * @created 27/06/2013 11:03:23
	 * 
	 * @return
	 */
	public boolean getIsUserLogged() {
		try {
			if (getUsuarioLogado() != null) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
