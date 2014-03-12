package com.helpers;

import java.io.Serializable;

/**
 * 
 * @author Jaques Loesch (jaques.loesch@teclogica.com.br)
 * 
 * @param <T>
 */
public abstract class BaseHelper<T> implements Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = 7690912786208129359L;

	/**
	 * Instancia do EJB
	 */
	protected T ejbWorker;

	/**
	 * @author Jaques Loesch (jaques.loesch@teclogica.com.br)
	 * @param ejbWorker
	 */
	public BaseHelper(T ejbWorker) {
		this.ejbWorker = ejbWorker;
	}
}
