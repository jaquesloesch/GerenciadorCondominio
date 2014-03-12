package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conexao.Conexao;
import com.enums.EErros;
import com.exceptions.ExcecaoInterna;
import com.vo.GastoApartamentoVO;

public class GastoApartamentoDAO extends UtilBaseDAO<GastoApartamentoVO> {

	public GastoApartamentoDAO() {
		super(GastoApartamentoDAO.class);
	}

	/**
	 * @see {@link UtilBaseDAO insere()}
	 */
	@Override
	public boolean insere(GastoApartamentoVO object) throws Exception {

		try {
			object.setId(getProximoId());
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO ")
					.append(getTableName())
					.append(" (ID,ID_APARTAMENTO,GASTO_AGUA,GASTO_GAS,GASTO_CONDOMINIO) VALUES(?,?,?,?,?)");
			PreparedStatement pst = Conexao.getConexao().prepareStatement(
					sb.toString());
			pst.setInt(1, object.getId());
			pst.setInt(2, object.getIdApartamento());
			pst.setInt(3, object.getGastoAgua());
			pst.setInt(4, object.getGastoGas());
			pst.setDouble(5, object.getGastoCondominio());

			return executarComando(pst);
		} catch (ExcecaoInterna e) {
			throw e;
		}

	}

	/**
	 * @see {@link UtilBaseDAO atualiza()}
	 */
	@Override
	public boolean atualiza(GastoApartamentoVO object) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE").append(getTableName()).append(" set a = b ")
				.append(" WHERE ID = ").append(object.getId());

		try {
			executarComando(sb.toString());
		} catch (ExcecaoInterna e) {

			throw new Exception(e.getMessage());
		}
		return true;
	}

	/**
	 * @see {@link UtilBaseDAO convertInObject()}
	 */
	@Override
	public List<GastoApartamentoVO> convertInObject(ResultSet rs)
			throws ExcecaoInterna {
		List<GastoApartamentoVO> lista = new ArrayList<GastoApartamentoVO>();
		try {

			while (rs.next()) {

				GastoApartamentoVO ga = new GastoApartamentoVO();
				ga.setId(new Integer(rs.getString("id") != null ? rs
						.getString("id") : "0"));
				ga.setIdApartamento(new Integer(
						rs.getString("id_Apartamento") != null ? rs
								.getString("id_Apartamento") : "0"));
				ga.setGastoAgua(new Integer(
						rs.getString("gasto_Agua") != null ? rs
								.getString("gasto_Agua") : "0"));
				ga.setGastoGas(new Integer(
						rs.getString("gasto_Gas") != null ? rs
								.getString("gasto_Gas") : "0"));

				ga.setGastoCondominio(new Double(rs
						.getString("gasto_condominio") != null ? rs
						.getString("gasto_condominio") : "0"));

				lista.add(ga);
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
				.append("GASTO_AGUA int,").append("GASTO_GAS int,")
				.append("ID_APARTAMENTO int,GASTO_CONDOMINIO DOUBLE, ")
				.append("PRIMARY KEY (ID)").append(")");

		executarComando(sb.toString());

	}

}
