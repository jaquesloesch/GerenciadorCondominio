package com.exceptions;

import com.enums.EErros;

/**
 * Classe para controle de Exceções.
 * 
 * @author Jaques Loesch
 * @author Vitor Vieira
 * 
 */
public class ExcecaoInterna extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2404716755287619907L;
	private Exception e;

	private EErros erro;

	public ExcecaoInterna(Exception e, EErros erro) {
		this.e = e;
		this.erro = erro;
	}

	public Exception getE() {
		return e;
	}

	public void setE(Exception e) {
		this.e = e;
	}

	public String getMessage() {
		return e.getMessage();
	}

	public EErros getErro() {
		return erro;
	}

	public void setErro(EErros erro) {
		this.erro = erro;
	}

}
