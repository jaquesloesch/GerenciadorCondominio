package com.util;

import javax.faces.context.FacesContext;

/**
 * Usado para simplificar os valores dos parâmetros da sessão.
 * 
 * @author Jaques Loesch
 * @created 12/02/2013 09:49:37
 * 
 */
public class SessionMapUtil {

	public static Object getValue(String name) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get(name);
	}

	public static void putValue(String key, Object object) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.put(key, object);

	}
	
	public static Object getAppValue(String name) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getApplicationMap().get(name);
	}

	public static void putAppValue(String key, Object object) {
		FacesContext.getCurrentInstance().getExternalContext().getApplicationMap()
				.put(key, object);

	}

	public static void clear() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.clear();
	}
	
	public static void clearAppValues() {
		FacesContext.getCurrentInstance().getExternalContext().getApplicationMap()
				.clear();
	}

}
