package com.helpers;

import org.apache.log4j.Logger;

import com.interfaces.ejb.UsuarioEJBLocal;
import com.vo.Usuario;

/**
 * 
 * @author Jaques Loesch (jaques.loesch@teclogica.com.br)
 * 
 */
public class LoginHelper extends BaseHelper<UsuarioEJBLocal> {

	/**
     * 
     */
	private static final long serialVersionUID = 8661463871470394668L;

	private static final Logger LOGGER = Logger.getLogger(LoginHelper.class);

	public LoginHelper(UsuarioEJBLocal ejbWorker) {
		super(ejbWorker);

	}

	public boolean insere(Usuario usuario) throws Exception {
		ejbWorker.insere(usuario);
		return true;
	}

	/**
	 * Método responsavel por auteticar o usuário.
	 * 
	 * @param usuario
	 * @return
	 */
	public Usuario autenticar(Usuario usuario) {

		Usuario usuarioFind = new Usuario();

		try {
			usuarioFind = ejbWorker.buscaUsuarioPeloLogin(usuario);
		} catch (Exception e) {
			   LOGGER.error(e.getMessage(), e);
			usuarioFind = null;
		}
		return usuarioFind;

	}

	
}
