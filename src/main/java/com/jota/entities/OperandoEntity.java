package com.jota.entities;

public class OperandoEntity {
	private String token;
	private Number operando;
	private Integer orden;
	private String aplicado;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Number getOperando() {
		return operando;
	}

	public void setOperando(Number operando) {
		this.operando = operando;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getAplicado() {
		return aplicado;
	}

	public void setAplicado(String aplicado) {
		this.aplicado = aplicado;
	}

}
