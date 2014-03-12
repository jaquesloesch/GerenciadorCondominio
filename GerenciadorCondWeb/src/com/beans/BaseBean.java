package com.beans;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

import com.util.Constants;
import com.util.SessionMapUtil;
import com.vo.Usuario;

/**
 * 
 * @author Jaques Loesch (jaques.loesch@teclogica.com.br)
 * 
 */
public abstract class BaseBean {
	private static final Logger LOGGER = Logger.getLogger(BaseBean.class);

	@PostConstruct
	public void init() {

	}

	/**
	 * Coloca a mensagem na sessão para ser exibida na tela!
	 * 
	 * @author Jaques Loesch (jaques.loesch@teclogica.com.br)
	 * @created 20/06/2013 10:21:48
	 * 
	 * @param event
	 */
	public void showMessage(ComponentSystemEvent event) {
		String facesMessage = (String) SessionMapUtil
				.getValue(Constants.MENSAGEM);
		Severity severity = (Severity) SessionMapUtil
				.getValue(Constants.SEVERIDADE);
		if (facesMessage != null) {
			addMessage(severity, facesMessage);
			SessionMapUtil.putValue(Constants.MENSAGEM, null);
			SessionMapUtil.putValue(Constants.SEVERIDADE, null);
		}
	}

	/**
	 * Retorna o usuario lgoado no sistema
	 * 
	 * @return
	 */
	public Usuario getUsuarioLogado() {

		try {
			Usuario usuario = (Usuario) FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap()
					.get(Constants.USER_LOGGED);
			return usuario;
		} catch (Exception e) {
//			LOGGER.error(e.getMessage(), e);
		}
		return null;

	}

	/**
	 * Redireciona para a página informada no parametro (ex.: pagina.xhtml)
	 * 
	 * @param pageXhtml
	 */
	public void redirect(String pageXhtml) {
		try {

			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(pageXhtml);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * Adiciona uma mensagem para ser mostrada na tela
	 * 
	 * @param severity
	 * @param messageStr
	 */
	protected void addMessage(Severity severity, String messageStr) {
		FacesMessage message = new FacesMessage();
		message.setSeverity(severity);
		message.setSummary(messageStr);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	/**
	 * Adiciona as mensagens na sessão
	 * 
	 * @author Jaques Loesch (jaques.loesch@teclogica.com.br)
	 * @created 02/07/2013 15:35:00
	 * 
	 * @param severity
	 * @param messageStr
	 */
	protected void addMessageOnSession(Severity severity, String messageStr) {
		FacesMessage message = new FacesMessage();
		message.setSeverity(severity);
		message.setSummary(messageStr);
		SessionMapUtil.putValue(Constants.MENSAGEM, messageStr);
		SessionMapUtil.putValue(Constants.SEVERIDADE, severity);
	}

	/**
	 * Executa um determinado javascript
	 * 
	 * @param metodScript
	 */
	public void executeJS(String metodScript) {

		RequestContext.getCurrentInstance().execute(metodScript);
	}

}
