package com.interfaces.ejb;

import java.util.List;

import com.vo.SimpleVo;

/**
 * 
 * @author Jaques Loesch (jaques.loesch@teclogica.com.br)
 * 
 * @param <T>
 */
public interface BaseEJB<T extends SimpleVo> {

	/**
	 * Procura pelo id de um objeto
	 * 
	 * @param id
	 * @return
	 */
	T buscaPeloId(Long id);

	/**
	 * Retorna todos os bojetos de um determinado valor
	 * 
	 * @return
	 */
	List<T> getTodos();

	/**
	 * Insert a object in the database.
	 * 
	 * @author André Rezende
	 * 
	 * @param object
	 * @throws DAOException
	 */
	void insere(T object);

	/**
	 * Atualiza um detemrinado objeto
	 * 
	 * @param object
	 */
	void atualizar(T object);

	/**
	 * Delete um determinado objeto
	 * 
	 * @param object
	 */
	void deletar(T object);
}
