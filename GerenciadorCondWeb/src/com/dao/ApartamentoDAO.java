package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conexao.Conexao;
import com.enums.EErros;
import com.exceptions.ExcecaoInterna;
import com.vo.ApartamentoVO;

public class ApartamentoDAO extends UtilBaseDAO<ApartamentoVO> {

	public ApartamentoDAO() {
		super(ApartamentoDAO.class);
	}

	/**
	 * @see {@link UtilBaseDAO insere()}
	 */
	@Override
	public boolean insere(ApartamentoVO object) throws Exception {

		try {
			object.setId(getProximoId());
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO ")
					.append(getTableName())
					.append("(ID,ESPACO_M2,QTDE_QUARTOS,QTDE_BANHEIROS,ID_PREDIO) VALUES(?,?,?,?,?);");

			PreparedStatement pst = Conexao.getConexao().prepareStatement(
					sb.toString());
			pst.setInt(1, object.getId());
			pst.setInt(2, object.getEspacoM2());
			pst.setInt(3, object.getQtdeQuartos());
			pst.setInt(4, object.getQtdeBanheiros());
			pst.setInt(5, object.getIdPredio());

			return executarComando(pst);
		} catch (ExcecaoInterna e) {
			throw e;
		}

	}

	/**
	 * @see {@link UtilBaseDAO atualiza()}
	 */
	@Override
	public boolean atualiza(ApartamentoVO object) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE ").append(getTableName()).append(" set a = b ")
				.append(" WHERE ID = ").append(object.getId());

		try {
			executarComando(sb.toString());
		} catch (ExcecaoInterna e) {
			throw e;
		}
		return true;
	}

	/**
	 * @see {@link UtilBaseDAO convertInObject()}
	 */
	@Override
	public List<ApartamentoVO> convertInObject(ResultSet rs)
			throws ExcecaoInterna {
		List<ApartamentoVO> lista = new ArrayList<ApartamentoVO>();
		try {

			while (rs.next()) {

				ApartamentoVO ap = new ApartamentoVO();
				ap.setId(new Integer(rs.getString("id") != null ? rs
						.getString("id") : "0"));
				ap.setEspacoM2(new Integer(
						rs.getString("ESPACO_M2") != null ? rs
								.getString("ESPACO_M2") : "0"));
				ap.setQtdeQuartos(new Integer(
						rs.getString("QTDE_QUARTOS") != null ? rs
								.getString("QTDE_QUARTOS") : "0"));
				ap.setQtdeBanheiros(new Integer(
						rs.getString("qtde_Banheiros") != null ? rs
								.getString("qtde_Banheiros") : "0"));
				ap.setIdPredio(new Integer(
						rs.getString("id_Predio") != null ? rs
								.getString("id_Predio") : "0"));

				lista.add(ap);
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
				.append("ESPACO_M2 int,").append("QTDE_QUARTOS int,")
				.append("QTDE_BANHEIROS int,").append("ID_PREDIO int,")
				.append("PRIMARY KEY (ID)").append(")");

		executarComando(sb.toString());

	}

}
