package com.vo;

import java.util.Date;

public class Pedido {
	private Integer id;
	private Integer mesa;
	private Integer usuario;
	private Integer comandaPaga;
	private Date data;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMesa() {
		return mesa;
	}

	public void setMesa(Integer mesa) {
		this.mesa = mesa;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Integer getComandaPaga() {
		return comandaPaga;
	}

	public void setComandaPaga(Integer comandaPaga) {
		this.comandaPaga = comandaPaga;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
