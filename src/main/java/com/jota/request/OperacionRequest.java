package com.jota.request;

import java.io.Serializable;

public class OperacionRequest implements Serializable{

	private static final long serialVersionUID = 1L;

	private String token;
	private String operacion;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

}
