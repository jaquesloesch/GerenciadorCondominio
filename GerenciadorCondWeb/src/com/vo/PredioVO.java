package com.vo;


/**
 * Classe representa um dominio do tipo Predio.
 * 
 * @author Jaques Loesch
 * @author Vitor Vieira
 * 
 */
public class PredioVO extends SimpleVo {

	private Integer numAndares;

	private Integer idCondominio;

	private String nome;

	public Integer getNumAndares() {
		return numAndares;
	}

	public void setNumAndares(Integer numAndares) {
		this.numAndares = numAndares;
	}

	public Integer getIdCondominio() {
		return idCondominio;
	}

	public void setIdCondominio(Integer idCondominio) {
		this.idCondominio = idCondominio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "ID-Predio.......:" + getId() + "\nID-Condominio.:"
				+ getIdCondominio() + "\nPredio........:" + getNome()
				+ "\nQtd Andares...:" + getNumAndares();
	}
}
