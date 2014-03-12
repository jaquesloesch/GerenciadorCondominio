package com.enums;


/**
 * Enum referente  aos erros ocorridos relacionados ao menu.
 * 
 * @author Jaques Loesch
 * @author Vitor Vieira
 * 
 */
public enum EErroMenu {
	VALOR_INCORRETO("Valor Informado n�o � v�lido. Informe Outro");
	
	private final String descricaoErro;
	
	public String getDescricaoErro(){
		return descricaoErro;
	}
	
	private EErroMenu(String descricaoErro){
		this.descricaoErro = descricaoErro;
	}
}
