package com.vo;

/**
 * Classe representa um dominio do Gasto  por Apartamento.
 * 
 * @author Jaques Loesch
 * @author Vitor Vieira
 * 
 */
public class GastoApartamentoVO extends SimpleVo {

	private Integer idApartamento;

	private Integer gastoAgua;

	private Integer gastoGas;

	private Double gastoCondominio;

	public Integer getIdApartamento() {
		return idApartamento;
	}

	public void setIdApartamento(Integer idApartamento) {
		this.idApartamento = idApartamento;
	}

	public Integer getGastoAgua() {
		return gastoAgua;
	}

	public void setGastoAgua(Integer gastoAgua) {
		this.gastoAgua = gastoAgua;
	}

	public Integer getGastoGas() {
		return gastoGas;
	}

	public void setGastoGas(Integer gastoGas) {
		this.gastoGas = gastoGas;
	}

	public Double getGastoCondominio() {
		return gastoCondominio;
	}

	public void setGastoCondominio(Double gastoCondominio) {
		this.gastoCondominio = gastoCondominio;
	}

	@Override
	public String toString() {
		return "GastoApartamentoVO [idApartamento=" + idApartamento
				+ ", gastoAgua=" + gastoAgua + ", gastoGas=" + gastoGas + "]";
	}

}
