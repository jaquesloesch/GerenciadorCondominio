package com.vo;

/**
 * Classe representa um dominio do tipo Condominio
 * 
 * @author Jaques Loesch
 * @author Vitor Vieira
 * 
 */
public class CondominioVO extends SimpleVo {

	private String nome;

	private String descricao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "ID-Condominio....:" + getId() + "\nCondominio.....:"
				+ getNome() + "\nDescrição......:" + getDescricao();
	}

}
