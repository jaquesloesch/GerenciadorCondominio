package com.enums;

/**
 * Enum referente  alguns erros.
 * 
 * @author Jaques Loesch
 * @author Vitor Vieira
 * 
 */
public enum EErros {

	FALHA_BANCO("Falha com banco de dados"), DADOS_INVALIDOS("Dados inválidos"), ERRO_GENERICO(
			"Ocorreu um erro no sistema"), FALHA_CRIAR_TABELAS(
			"Falha ao criar as tabelas do banco"), FALHA_RECUPERAR_DADOS(
					"Falha na recperacao de dados do banco");
	
	private String msgErro;

	EErros(String msgErro) {
		this.msgErro = msgErro;

	}

	public String getMsgErro() {
		return msgErro;
	}

}
