package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conexao.Conexao;
import com.enums.EErros;
import com.exceptions.ExcecaoInterna;
import com.vo.CondominioVO;

public class CondominioDAO extends UtilBaseDAO<CondominioVO> {

	public CondominioDAO() {
		super(CondominioDAO.class);
	}

	/**
	 * @see {@link UtilBaseDAO insere()}
	 */
	@Override
	public boolean insere(CondominioVO object) throws Exception {

		try {
			object.setId(getProximoId());
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO ").append(getTableName())

			.append(" (ID,NOME,DESCRICAO) VALUES(?,?,?);");

			PreparedStatement pst = Conexao.getConexao().prepareStatement(
					sb.toString());
			pst.setInt(1, object.getId());
			pst.setString(2, object.getNome());
			pst.setString(3, object.getDescricao());

			return executarComando(pst);
		} catch (ExcecaoInterna e) {
			throw e;
		}

	}

	/**
	 * @see {@link UtilBaseDAO atualiza()}
	 */
	@Override
	public boolean atualiza(CondominioVO object) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE").append(getTableName()).append(" set a = b ")
				.append(" WHERE ID = ").append(object.getId());

		try {
			executarComando(sb.toString());
		} catch (ExcecaoInterna e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return true;
	}

	/**
	 * @see {@link UtilBaseDAO convertInObject()}
	 */
	@Override
	public List<CondominioVO> convertInObject(ResultSet rs)
			throws ExcecaoInterna {
		List<CondominioVO> lista = new ArrayList<CondominioVO>();
		try {

			while (rs.next()) {

				CondominioVO cond = new CondominioVO();
				cond.setId(new Integer(rs.getString("id") != null ? rs
						.getString("id") : "0"));
				cond.setNome(rs.getString("nome") != null ? rs
						.getString("nome") : "");
				cond.setDescricao(rs.getString("descricao") != null ? rs
						.getString("descricao") : "");

				lista.add(cond);
			}
			return lista;
		} catch (SQLException e) {
			throw new ExcecaoInterna(e, EErros.FALHA_RECUPERAR_DADOS);
		}

	}

	/**
	 * @see {@link UtilBaseDAO criarTabela()}
	 */
	@Override
	public void criarTabela() throws Exception {

		StringBuilder sb = new StringBuilder("CREATE TABLE ");
		sb.append(getTableName()).append("(").append("ID int NOT NULL,")
				.append("NOME text,").append("DESCRICAO text,")
				.append("PRIMARY KEY (ID)").append(")");
		executarComando(sb.toString());
	}

}
