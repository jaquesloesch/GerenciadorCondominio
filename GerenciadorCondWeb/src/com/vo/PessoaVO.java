package com.vo;

import com.dao.PessoaDAO;
import com.exceptions.ExcecaoInterna;

/**
 * Classe representa um dominio do tipo Pessoa
 * 
 * @author Jaques Loesch
 * @author Vitor Vieira
 * 
 */
public class PessoaVO extends SimpleVo {

	private String nome;

	private Long telefone;

	private Long cpf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "ID-Pessoa.....:" + getId() + "Nome..........:" + getNome()
				+ "CPF...........:" + getCpf() + "Telefone......:"
				+ getTelefone();
	}

	/**
	 * @author Jaques Loesch
	 * @author Vitor Vieira
	 * 
	 *         Rotina Utilizada para Consulta de Predios
	 * 
	 * @throws Exception
	 */
	public static void consultaPredio(int idPessoa) {
		PessoaDAO pessoaDAO = new PessoaDAO();
		try {
			for (PessoaVO pessoa : pessoaDAO.executaSelect("SELECT * FROM"
					+ pessoaDAO.getTableName() + "WHERE id_pessoa = "
					+ idPessoa)) {
				System.out.println(pessoa);
			}
		} catch (ExcecaoInterna e) {
			// TODO LOG4J

		}
	}

}
