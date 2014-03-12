package com.exceptions;

import com.enums.EErroMenu;

public class MenuException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8714899306957162002L;

	public MenuException(EErroMenu erro) {
		super(erro.getDescricaoErro());
	}

}
