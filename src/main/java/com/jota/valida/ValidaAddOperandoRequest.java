package com.jota.valida;

import java.util.ArrayList;
import java.util.List;

import com.jota.request.AddOperandoRequest;
import com.jota.response.AddOperandoResponse;
import com.jota.services.UsuarioService;


public class ValidaAddOperandoRequest {
	public static boolean valida(AddOperandoRequest request,AddOperandoResponse response) {
		
		boolean valido=true;
		List<String> messages=new ArrayList<String>();
		
		if(request.getToken()==null || request.getToken().isEmpty()) {
			valido=false;
			messages.add("Debe especificar el atributo Token");
		}else {
			UsuarioService service = new UsuarioService();
			if(!service.buscarToken(request.getToken())) {
				valido=false;
				messages.add("Token no valido");
			}
		}
		
		if(request.getOperando()==null) {
			valido=false;
			messages.add("Debe especificar el atributo operando");
		}
		
		if(!valido) {
			response.setMessages(messages);
		}
		
		return valido;
	}
}
