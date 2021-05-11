package com.jota.response;

import java.io.Serializable;

public class ResponseLogin implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String respuesta;

	public ResponseLogin(String respuesta) {
		super();
		this.respuesta = respuesta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
}
