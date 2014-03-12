package com.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe representa um dominio do Historico de morador por apartamento.
 * 
 * @author Jaques Loesch
 * @author Vitor Vieira
 * 
 */
public class HistoricoMoradorVO extends SimpleVo {

	private Integer idPessoa;

	private Integer idApartamento;

	private Date competenciaInicial;

	private Date competenciaFinal;

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public Integer getIdApartamento() {
		return idApartamento;
	}

	public void setIdApartamento(Integer idApartamento) {
		this.idApartamento = idApartamento;
	}

	public Date getCompetenciaInicial() {
		return competenciaInicial;
	}

	public void setCompetenciaInicial(Date competenciaInicial) {
		this.competenciaInicial = competenciaInicial;
	}

	public Date getCompetenciaFinal() {
		return competenciaFinal;
	}

	public void setCompetenciaFinal(Date competenciaFinal) {
		this.competenciaFinal = competenciaFinal;
	}

	@Override
	public String toString() {
		return "HistoricoMoradorVO [idPessoa=" + idPessoa + ", idApartamento="
				+ idApartamento + ", competenciaInicial=" + competenciaInicial
				+ ", competenciaFinal=" + competenciaFinal + "]";
	}

	public String getCompetenciaInicialFormatada() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(getCompetenciaInicial());

	}
	
	public String getCompetenciaFinalFormatada() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(getCompetenciaFinal());

	}
	
}
