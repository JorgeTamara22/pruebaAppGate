package com.jota.prueba;

import com.jota.request.RequestLogin;
import com.jota.response.ResponseLogin;
import com.jota.services.UsuarioService;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      UsuarioService service = new UsuarioService();
      RequestLogin request = new RequestLogin();
      request.setUserName("PRUEBA");
      request.setPassword("+++");
      ResponseLogin respuesta = service.buscarUsuario(request);
      System.out.println("Respuesta: "+respuesta.getRespuesta());
	}

}
