package com.vo;


/**
 * Representa a entidade de domínio do Usuário
 * 
 * @author Jaques Loesch
 * @since 13/06/2013 11:00:00
 * 
 */
public class Usuario extends SimpleVo {

	private String login;

	private String senha;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
