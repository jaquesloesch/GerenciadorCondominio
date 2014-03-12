package com.dao;

import java.sql.ResultSet;
import java.util.List;

import com.vo.SimpleVo;

/**
 * Interface que representa comportamento padrões para as demais classes de
 * banco de dados;
 * 
 * @author Jaques Loesch
 * @author Vitor Vieira
 * 
 * @param <T>
 */
public interface IBaseDAO<T extends SimpleVo> {

	boolean insere(T object) throws Exception;

	boolean atualiza(T object) throws Exception;

	boolean deleta(T object) throws Exception;

	List<T> getTodos() throws Exception;

	List<T> convertInObject(ResultSet rs) throws Exception;

	void criarTabela() throws Exception;

}
