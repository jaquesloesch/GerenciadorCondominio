package com.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

import com.util.Constants;

/**
 * 
 * @author Jaques Loesch (jaques.loesch@teclogica.com.br)
 * 
 */
@ManagedBean(name = "menuBean")
@SessionScoped
public class MenuBean extends BaseBean {
	private static final Logger LOGGER = Logger.getLogger(MenuBean.class);

	private MenuModel model;

	// /**
	// * Retorna o usuário Lodado para controle de acesso aos menus
	// */
	// private Usuario usuario;

	public MenuBean() {
	}

	/**
	 * 
	 * @author Jaques Loesch (jaques.loesch@teclogica.com.br)
	 * @created 21/06/2013 11:09:43
	 * 
	 */
	@PostConstruct
	public void init() {

	}

	private void populateMenu() {

		try {

			model = new DefaultMenuModel();

			for (int i = 0; i < 5; i++) {

				Submenu submenu = new Submenu();

				submenu.setLabel("TESTE");

				model.addSubmenu(submenu);
			}

			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().put(Constants.MENU, model);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);

		}
	}

	public MenuModel getModel() {
		populateMenu();
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

}
