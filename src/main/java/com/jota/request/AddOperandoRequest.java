package com.jota.request;

import java.io.Serializable;

public class AddOperandoRequest implements Serializable{

	private static final long serialVersionUID = 1L;

	private String token;
	private Number operando;

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

}
