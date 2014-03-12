package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.conexao.Conexao;
import com.enums.EErros;
import com.exceptions.ExcecaoInterna;
import com.vo.PessoaVO;

public class PessoaDAO extends UtilBaseDAO<PessoaVO> {

	public PessoaDAO() {
		super(PessoaDAO.class);
	}

	/**
	 * @see {@link UtilBaseDAO insere()}
	 */
	@Override
	public boolean insere(PessoaVO object) throws Exception {

		try {
			object.setId(getProximoId());
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO ").append(getTableName())
					.append(" (ID,NOME,TELEFONE,CPF) VALUES(?,?,?,?)");

			PreparedStatement pst = Conexao. getConexao().prepareStatement(
					sb.toString());
			pst.setInt(1, object.getId());
			pst.setString(2, object.getNome());
			pst.setLong(3, object.getTelefone());
			pst.setLong(4, object.getCpf());

			return executarComando(pst);
		} catch (ExcecaoInterna e) {
			throw e;
		}

	}

	/**
	 * @see {@link UtilBaseDAO atualiza()}
	 */
	@Override
	public boolean atualiza(PessoaVO object) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE ").append(getTableName()).append(" set a = b ")
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
	public List<PessoaVO> convertInObject(ResultSet rs) throws ExcecaoInterna {
		List<PessoaVO> lista = new ArrayList<PessoaVO>();
		try {

			while (rs.next()) {

				PessoaVO pessoa = new PessoaVO();
				pessoa.setId(new Integer(rs.getString("id") != null ? rs
						.getString("id") : "0"));
				pessoa.setNome(rs.getString("nome") != null ? rs
						.getString("nome") : "");
				pessoa.setTelefone(new Long(
						rs.getString("telefone") != null ? rs
								.getString("telefone") : "0"));
				pessoa.setCpf(new Long(rs.getString("cpf") != null ? rs
						.getString("cpf") : "0"));

				lista.add(pessoa);
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
				.append("NOME text ,").append("TELEFONE double,")
				.append("CPF double,").append("PRIMARY KEY (ID)").append(")");

		executarComando(sb.toString());
	}

}
