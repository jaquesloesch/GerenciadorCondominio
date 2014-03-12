package com.filter;

import java.io.IOException;

import javax.faces.FactoryFinder;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * @author Jaques Loesch (jaques.loesch@teclogica.com.br) Servlet Filter
 *         implementation class AuthenticateFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

	private static final Logger LOGGER = Logger.getLogger(LoginFilter.class);

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String url = req.getRequestURL().toString();
		HttpSession session = req.getSession();

		chainFilter(request, response, chain);

	}

	protected void chainFilter(ServletRequest request,
			ServletResponse response, FilterChain chain) {
		try {
			chain.doFilter(request, response);
		} catch (Throwable t) {

			LOGGER.error(t.getMessage(), t);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

	/**
	 * Retorna um contextFace
	 * 
	 * @author Jaques Loesch (jaques.loesch@teclogica.com.br)
	 * @created 26/06/2013 15:26:10
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public FacesContext getFacesContext(HttpServletRequest request,
			HttpServletResponse response) {
		FacesContextFactory contextFactory = (FacesContextFactory) FactoryFinder
				.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
		LifecycleFactory lifecycleFactory = (LifecycleFactory) FactoryFinder
				.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
		javax.faces.lifecycle.Lifecycle lifecycle = lifecycleFactory
				.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
		return contextFactory.getFacesContext(request.getSession()
				.getServletContext(), request, response, lifecycle);
	}

}
