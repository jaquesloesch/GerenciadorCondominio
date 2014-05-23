package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conexao.Conexao;
import com.vo.CardapioProduto;

public class CardapioProdutoDAO {

	public CardapioProdutoDAO() {
	}

	/**
	 * @see {@link UtilBaseDAO insere()}
	 */
	public boolean insere(CardapioProduto object) throws Exception {

		try {

			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO ").append(getTableName())
					.append("(ID_CARDAPIO,ID_PRODUTO) VALUES(?,?);");

			PreparedStatement pst = Conexao.getConexao().prepareStatement(
					sb.toString());

			pst.setInt(1, object.getIdCardapio());
			pst.setInt(2, object.getIdProduto());

			return executarComando(pst);
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * @see {@link UtilBaseDAO atualiza()}
	 */
	public boolean atualiza(CardapioProduto object) throws Exception {

		try {

			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE  ").append(getTableName())
					.append(" set  IMAGEM_BITS =  ? WHERE ID = ?");
			PreparedStatement pst = Conexao.getConexao().prepareStatement(
					sb.toString());
			// pst.setBytes(1, object.getFileItem().get());
			// pst.setInt(2, object.getId());
			return executarComando(pst);
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * @see {@link UtilBaseDAO convertInObject()}
	 */
	public List<CardapioProduto> convertInObject(ResultSet rs) throws Exception {
		List<CardapioProduto> lista = new ArrayList<CardapioProduto>();
		try {

			while (rs.next()) {

				CardapioProduto user = new CardapioProduto();
				user.setIdCardapio((new Integer(
						rs.getString("ID_CARDAPIO") != null ? rs
								.getString("id") : "0")));
				user.setIdProduto((new Integer(
						rs.getString("ID_PRODUTO") != null ? rs.getString("id")
								: "0")));

				lista.add(user);
			}
			return lista;
		} catch (SQLException e) {
			throw e;
		}
	}

	/**
	 * @see {@link UtilBaseDAO criarTabela()}
	 */
	public void criarTabela() throws Exception {

		StringBuilder sb = new StringBuilder("CREATE TABLE ");
		sb.append(getTableName()).append("(")
				.append("ID_CARDAPIO int NOT NULL ,")
				.append("ID_PRODUTO int NOT NULL")
				.append(");");
		
		executarComando(sb.toString());

	}

	/**
	 * @see {@link UtilBaseDAO criarTabela()}
	 */
	public void deletarTabela() throws Exception {

		StringBuilder sb = new StringBuilder("DROP TABLE ");
		sb.append(getTableName()).append(";");

		executarComando(sb.toString());

	}

	/**
	 * @author Jaques Loesch
	 * @author Vitor Vieira
	 * @return Deleta um objeto de uma determinada tabela.
	 * @throws Exception
	 */
	public boolean deleta(CardapioProduto object) throws Exception {

		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM ").append(getTableName())
				.append(" WHERE ID_CARDAPIO = ").append(object.getIdCardapio())
				.append(" AND ID_PRODUTO = ").append(object.getIdProduto());

		return executarComando(sb.toString());
	}

	/**
	 * @author Jaques Loesch
	 * @author Vitor Vieira
	 * @return Retorna todos os registros de um determinado tipo.
	 * @throws Exception
	 */
	public List<CardapioProduto> getTodos() throws Exception {

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM ").append(getTableName());
		return executaSelect(sb.toString());

	}

	/**
	 * @author Jaques Loesch
	 * @author Vitor Vieira
	 * @return Procura um objeto pelo id
	 * @throws Exception
	 */
	public CardapioProduto procuraPeloId(Integer id) throws Exception {

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM ").append(getTableName())
				.append(" WHERE ID = ? ");

		PreparedStatement pst = Conexao.getConexao().prepareStatement(
				sb.toString());
		pst.setInt(1, id);

		return executarComandoSelect(pst);

	}

	/**
	 * @author Jaques Loesch
	 * @author Vitor Vieira (Update/Delete)Executa um determinado comando e
	 *         retorna true se tudo certo, ou false se o alguma coisa der
	 *         errado.
	 * @return
	 */
	public boolean executarComando(String comando) throws Exception {

		Connection conexao = null;
		try {
			conexao = Conexao.getConexao();
			System.out.println(comando);
			conexao.createStatement().execute(comando);

			return true;
		} catch (Exception e) {
			throw e;
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
	public boolean executarComando(PreparedStatement ps) throws Exception {

		try {
			return ps.execute();
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
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
	public CardapioProduto executarComandoSelect(PreparedStatement ps)
			throws Exception {

		try {
			return convertInObject(ps.executeQuery()).get(0);
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
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
	public List<CardapioProduto> executaSelect(String comando) throws Exception {

		PreparedStatement ps;
		try {
			ps = Conexao.getConexao().prepareStatement(comando);

			return convertInObject(ps.executeQuery());
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
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
			throws Exception {

		PreparedStatement ps;
		try {
			ps = Conexao.getConexao().prepareStatement(comando);
			ResultSet rs = ps.executeQuery();
			rs.next();

			return new Integer(rs.getString(alias) == null ? "0"
					: rs.getString(alias));
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
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
	public Integer getProximoId() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT max(id) as ID FROM ").append(getTableName());
		return executaIntegerSelect(sb.toString(), "ID") + 1;

	}

	/**
	 * @author Jaques Loesch
	 * 
	 * @author Vitor Vieira
	 * @return Retorna o nome da tabela em maiusculo. (a tabela deve ter o mesmo
	 *         nome da classe)
	 */
	public String getTableName() {
		return "CARDAPIO_PRODUTO";
	}

}
