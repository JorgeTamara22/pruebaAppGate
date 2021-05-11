package com.jota.valida;

import java.util.ArrayList;
import java.util.List;

import com.jota.request.OperacionRequest;
import com.jota.response.OperacionResponse;
import com.jota.services.UsuarioService;



public class ValidaOperacionRequest {
	
public static boolean valida(OperacionRequest request,OperacionResponse response) {
		
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
		if(request.getOperacion()==null || request.getOperacion().trim().isEmpty()) {
			valido=false;
			messages.add("Debe especificar el atributo operacion");
		}else if(!"+".equals(request.getOperacion()) && 
				 !"-".equals(request.getOperacion()) && 
				 !"*".equals(request.getOperacion()) &&
				 !"x".equalsIgnoreCase(request.getOperacion()) &&
				 !"/".equals(request.getOperacion()) &&
				 !"÷".equals(request.getOperacion()) &&
				 !"^".equals(request.getOperacion())) {
			valido=false;
			messages.add("Caracter de operacion no valido");
		}
		
		if(!valido) {
			response.setMessages(messages);
		}
		
		return valido;
	}
}

