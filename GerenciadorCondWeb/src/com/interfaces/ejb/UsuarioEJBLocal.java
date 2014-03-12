package com.interfaces.ejb;

import com.vo.Usuario;


/**
 * Interface Local para o EJB usuario
 * @author Jaques Loesch (jaques.loesch@teclogica.com.br)
 *
 */
public interface UsuarioEJBLocal extends BaseEJB<Usuario> {

	Usuario buscaUsuarioPeloLogin(Usuario object);

}
