package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conexao.Conexao;
import com.vo.PedidoCardapio;

public class PedidoCardapioDAO {

	public PedidoCardapioDAO() {
	}

	/**
	 * @see {@link UtilBaseDAO insere()}
	 */
	public boolean insere(PedidoCardapio object) throws Exception {

		try {
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO ").append(getTableName())
					.append("(ID_CARDAPIO,ID_PEDIDO) VALUES(?,?);");

			PreparedStatement pst = Conexao.getConexao().prepareStatement(
					sb.toString());

			pst.setInt(1, object.getIdCardapio());
			pst.setInt(2, object.getIdPedido());
			
			return executarComando(pst);
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * @see {@link UtilBaseDAO atualiza()}
	 */
	public boolean atualiza(PedidoCardapio object) throws Exception {

		try {

			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE  ").append(getTableName())
					.append(" set  IMAGEM_BITS =  ? WHERE ID = ?");
			PreparedStatement pst = Conexao.getConexao().prepareStatement(
					sb.toString());
			// pst.setBytes(1, object.getFileItem().get());
//			pst.setInt(2, object.getId());
			return executarComando(pst);
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * @see {@link UtilBaseDAO convertInObject()}
	 */
	public List<PedidoCardapio> convertInObject(ResultSet rs) throws Exception {
		List<PedidoCardapio> lista = new ArrayList<PedidoCardapio>();
		try {

			while (rs.next()) {

				PedidoCardapio user = new PedidoCardapio();
				user.setIdCardapio(new Integer(rs.getString("ID_CARDAPIO") != null ? rs
						.getString("id") : "0"));
				user.setIdPedido(new Integer(rs.getString("ID_PEDIDO") != null ? rs
						.getString("id") : "0"));
				
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
				.append("ID_PEDIDO int NOT NULL ,")
				.append("ID_CARDAPIO int NOT NULL")
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
	public boolean deleta(PedidoCardapio object) throws Exception {

		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM ").append(getTableName()).append(" WHERE ID_CARDAPIO = ")
				.append(object.getIdCardapio()).append(" AND ID_PEDIDO = ").append(object.getIdPedido());

		return executarComando(sb.toString());
	}

	/**
	 * @author Jaques Loesch
	 * @author Vitor Vieira
	 * @return Retorna todos os registros de um determinado tipo.
	 * @throws Exception
	 */
	public List<PedidoCardapio> getTodos() throws Exception {

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
	public PedidoCardapio procuraPeloId(Integer id) throws Exception {

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
	public PedidoCardapio executarComandoSelect(PreparedStatement ps) throws Exception {

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
	public List<PedidoCardapio> executaSelect(String comando) throws Exception {

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
		return "PEDIDO_CARDAPIO";
	}

}
