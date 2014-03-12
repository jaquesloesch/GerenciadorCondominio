package com.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.conexao.Conexao;
import com.enums.EErros;
import com.exceptions.ExcecaoInterna;
import com.vo.HistoricoMoradorVO;

public class HistoricoMoradorDAO extends UtilBaseDAO<HistoricoMoradorVO> {

	public HistoricoMoradorDAO() {
		super(HistoricoMoradorDAO.class);
	}

	/**
	 * @see {@link UtilBaseDAO insere()}
	 */
	@Override
	public boolean insere(HistoricoMoradorVO object) throws Exception {

		try {
			object.setId(getProximoId());
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO ")
					.append(getTableName())
					.append(" (ID,ID_PESSOA,ID_APARTAMENTO,COMPETENCIA_INICIAL,COMPETENCIA_FINAL) VALUES(?,?,?,?,?)");
			PreparedStatement pst = Conexao.getConexao().prepareStatement(
					sb.toString());
			pst.setInt(1, object.getId());
			pst.setInt(2, object.getIdPessoa());
			pst.setInt(3, object.getIdApartamento());
			pst.setDate(4, new Date(object.getCompetenciaInicial().getTime()));
			pst.setDate(5, new Date(object.getCompetenciaFinal().getTime()));

			return executarComando(pst);
		} catch (ExcecaoInterna e) {
			throw e;
		}

	}

	/**
	 * @see {@link UtilBaseDAO atualiza()}
	 */
	@Override
	public boolean atualiza(HistoricoMoradorVO object) throws Exception {
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
	public List<HistoricoMoradorVO> convertInObject(ResultSet rs)
			throws ExcecaoInterna {
		List<HistoricoMoradorVO> lista = new ArrayList<HistoricoMoradorVO>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			while (rs.next()) {

				HistoricoMoradorVO hm = new HistoricoMoradorVO();
				hm.setId(new Integer(rs.getString("id") != null ? rs
						.getString("id") : "0"));
				hm.setIdApartamento(new Integer(
						rs.getString("id_Apartamento") != null ? rs
								.getString("id_Apartamento") : "0"));

				hm.setCompetenciaInicial(sdf.parse(rs
						.getString("competencia_Inicial") != null ? rs
						.getString("competencia_Inicial") : ""));

				hm.setCompetenciaInicial(sdf.parse(rs
						.getString("competencia_Final") != null ? rs
						.getString("competencia_Final") : ""));

				lista.add(hm);
			}
			return lista;
		} catch (Exception e) {
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
				.append("ID_PESSOA int,").append("ID_APARTAMENTO int,")
				.append("COMPETENCIA_INICIAL DATE,")
				.append("COMPETENCIA_FINAL DATE,").append("PRIMARY KEY (ID)")
				.append(")");

		executarComando(sb.toString());

	}

}
