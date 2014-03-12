package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conexao.Conexao;
import com.enums.EErros;
import com.exceptions.ExcecaoInterna;
import com.vo.PredioVO;

public class PredioDAO extends UtilBaseDAO<PredioVO> {

	public PredioDAO() {
		super(PredioDAO.class);
	}

	/**
	 * @see {@link UtilBaseDAO insere()}
	 */
	@Override
	public boolean insere(PredioVO object) throws Exception {
		try {
			object.setId(getProximoId());
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO ").append(getTableName())
					.append(" (ID,NUM_ANDARES,ID_CONDOMINIO,NOME)")
					.append(" VALUES(?,?,?,?)");

			PreparedStatement pst = Conexao.getConexao().prepareStatement(
					sb.toString());
			pst.setInt(1, object.getId());
			pst.setInt(2, object.getNumAndares());
			pst.setInt(3, object.getIdCondominio());
			pst.setString(4, object.getNome());

			return executarComando(pst);
		} catch (ExcecaoInterna e) {
			throw e;
		}

	}

	/**
	 * @see {@link UtilBaseDAO atualiza()}
	 */
	@Override
	public boolean atualiza(PredioVO object) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE ").append(getTableName()).append("set a = b")
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
	public List<PredioVO> convertInObject(ResultSet rs) throws ExcecaoInterna {
		List<PredioVO> lista = new ArrayList<PredioVO>();
		try {

			while (rs.next()) {
				PredioVO predio = new PredioVO();
				predio.setId(new Integer(rs.getString("id") != null ? rs
						.getString("id") : "0"));

				predio.setId(new Integer(
						rs.getString("num_Andares") != null ? rs
								.getString("num_Andares") : "0"));
				predio.setId(new Integer(
						rs.getString("id_Condominio") != null ? rs
								.getString("id_Condominio") : "0"));
				predio.setNome(rs.getString("nome") != null ? rs
						.getString("nome") : "");

				lista.add(predio);
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
	public void criarTabela() throws ExcecaoInterna {
		StringBuilder sb = new StringBuilder("CREATE TABLE ");
		sb.append(getTableName()).append("(").append("ID int NOT NULL,")
				.append("NUM_ANDARES int,").append("ID_CONDOMINIO int,")
				.append("NOME text,").append("PRIMARY KEY (ID)").append(")");

		executarComando(sb.toString());
	}

}
