package com.jota.services;

import com.jota.request.RequestLogin;
import com.jota.response.ResponseLogin;

public class UsuarioService {
	
	public ResponseLogin buscarUsuario(RequestLogin request) {
		return new ResponseLogin("token");
	}
 
}
