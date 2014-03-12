package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.conexao.Conexao;
import com.enums.EErros;
import com.exceptions.ExcecaoInterna;
import com.vo.SimpleVo;

/**
 * Classe Abstrata que representa comportamento padrões entre as classes.
 * 
 * @author Jaques Loesch
 * @author Vitor Vieira
 * 
 * @param <T> recebe um parametro do tipo classe que precisa extender da classe BaseVO
 */
public abstract class UtilBaseDAO<T extends SimpleVo> implements IBaseDAO<T> {

	private Class<?> type;

	public UtilBaseDAO(Class<?> type) {
		this.type = type;
	}

	/**
	 * @author Jaques Loesch
	 * @author Vitor Vieira
	 * @return Deleta um objeto de uma determinada tabela.
	 * @throws ExcecaoInterna
	 */
	@Override
	public boolean deleta(T object) throws ExcecaoInterna {

		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM ").append(getTableName()).append(" WHERE ID = ")
				.append(object.getId());

		return executarComando(sb.toString());
	}

	/**
	 * @author Jaques Loesch
	 * @author Vitor Vieira
	 * @return Retorna todos os registros de um determinado tipo.
	 * @throws ExcecaoInterna
	 */
	@Override
	public List<T> getTodos() throws ExcecaoInterna {

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM ").append(getTableName());
		return executaSelect(sb.toString());

	}

	/**
	 * @author Jaques Loesch
	 * @author Vitor Vieira (Update/Delete)Executa um determinado comando e
	 *         retorna true se tudo certo, ou false se o alguma coisa der
	 *         errado.
	 * @return
	 */
	public boolean executarComando(String comando) throws ExcecaoInterna {

		Connection conexao = null;
		try {
			conexao = Conexao.getConexao();
			System.out.println(comando);
			conexao.createStatement().execute(comando);

			return true;
		} catch (SQLException e) {
			throw new ExcecaoInterna(e, EErros.FALHA_BANCO);
		} catch (Exception e) {
			throw new ExcecaoInterna(e, EErros.ERRO_GENERICO);
		} finally {
			Conexao.closeConexao();
		}
	}

	/**
	 * @author Jaques Loesch
	 * @author Vitor Vieira (Update/Delete)Executa um determinado comando e
	 *         retorna true se tudo certo, ou false se o alguma coisa der
	 *         errado.
	 * @return
	 */
	public boolean executarComando(PreparedStatement ps) throws ExcecaoInterna {

		try {
			return ps.execute();
		} catch (SQLException e) {
			throw new ExcecaoInterna(e, EErros.FALHA_BANCO);
		} catch (Exception e) {
			throw new ExcecaoInterna(e, EErros.ERRO_GENERICO);
		} finally {
			Conexao.closeConexao();
		}
	}

	/**
	 * @author Jaques Loesch
	 * @author Vitor Vieira Executa e retorna os dados do select em forma de
	 *         array.
	 * @return
	 */
	public List<T> executaSelect(String comando) throws ExcecaoInterna {

		PreparedStatement ps;
		try {
			System.out.println(comando);
			ps = Conexao.getConexao().prepareStatement(comando);

			return convertInObject(ps.executeQuery());
		} catch (SQLException e) {
			throw new ExcecaoInterna(e, EErros.FALHA_BANCO);
		} catch (Exception e) {
			throw new ExcecaoInterna(e, EErros.ERRO_GENERICO);
		} finally {
			Conexao.closeConexao();
		}

	}

	/**
	 * @author Jaques Loesch
	 * @author Vitor Vieira Executa e retorna os dados do select em forma de
	 *         array.
	 * @return
	 */
	public Integer executaIntegerSelect(String comando, String alias)
			throws ExcecaoInterna {

		PreparedStatement ps;
		try {
			ps = Conexao.getConexao().prepareStatement(comando);
			ResultSet rs = ps.executeQuery();
			rs.next();

			return new Integer(rs.getString(alias) == null ? "0"
					: rs.getString(alias));
		} catch (SQLException e) {
			throw new ExcecaoInterna(e, EErros.FALHA_BANCO);
		} catch (Exception e) {
			throw new ExcecaoInterna(e, EErros.ERRO_GENERICO);
		} finally {
			Conexao.closeConexao();
		}

	}

	/**
	 * @author Jaques Loesch
	 * @author Vitor Vieira Executa e retorna os dados do select em forma de
	 *         array.
	 * @return Retorna o próximo id válido
	 */
	public Integer getProximoId() throws ExcecaoInterna {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT max(id) as ID FROM ").append(getTableName());
		return executaIntegerSelect(sb.toString(), "ID") + 1;

	}

	/**
	 * @author Jaques Loesch
	 * @author Vitor Vieira Executa e retorna os dados do select em forma de
	 *         array.
	 * @return Deleta a tabela
	 */
	public boolean deletaTabela() throws ExcecaoInterna {
		StringBuilder sb = new StringBuilder();
		sb.append("DROP TABLE ").append(getTableName());
		return executarComando(sb.toString());

	}

	/**
	 * @author Jaques Loesch
	 * 
	 * @author Vitor Vieira
	 * @return Retorna o nome da tabela em maiusculo. (a tabela deve ter o mesmo
	 *         nome da classe)
	 */
	public String getTableName() {
		return type.getSimpleName().toUpperCase();
	}

}
