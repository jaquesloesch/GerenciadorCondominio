package com.vo;


/**
 * Classe representa um dominio do tipo Apartamento
 * 
 * @author Jaques Loesch
 * @author Vitor Vieira
 * 
 */
public class ApartamentoVO extends SimpleVo {

	private Integer espacoM2;
	private Integer qtdeQuartos;
	private Integer qtdeBanheiros;
	private Integer idPredio;

	public Integer getEspacoM2() {
		return espacoM2;
	}

	public void setEspacoM2(Integer espacoM2) {
		this.espacoM2 = espacoM2;
	}

	public Integer getQtdeQuartos() {
		return qtdeQuartos;
	}

	public void setQtdeQuartos(Integer qtdeQuartos) {
		this.qtdeQuartos = qtdeQuartos;
	}

	public Integer getQtdeBanheiros() {
		return qtdeBanheiros;
	}

	public void setQtdeBanheiros(Integer qtdeBanheiros) {
		this.qtdeBanheiros = qtdeBanheiros;
	}

	public Integer getIdPredio() {
		return idPredio;
	}

	public void setIdPredio(Integer idPredio) {
		this.idPredio = idPredio;
	}

	@Override
	public String toString() {
		return "ID-Apartamento....:" + getId() + "ID-Predio.........:"
				+ getIdPredio() + "Apartamento M²....:" + getEspacoM2()
				+ "Qtd Banheiros.....:" + getQtdeBanheiros()
				+ "Qtd Quartos.......:" + getQtdeQuartos();

	}

}
