package com.jota.prueba;


import com.jota.entities.OperandoEntity;
import com.jota.request.AddOperandoRequest;
import com.jota.request.RequestLogin;
import com.jota.response.AddOperandoResponse;
import com.jota.response.ResponseLogin;
import com.jota.services.AddOperandoService;
import com.jota.services.UsuarioService;
import com.jota.valida.ValidaAddOperandoRequest;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      UsuarioService service = new UsuarioService();
      RequestLogin request = new RequestLogin();
      request.setUserName("PRUEBA");
      request.setPassword("PRUEBA");
      ResponseLogin respuesta = service.buscarUsuario(request);
      System.out.println(respuesta.getRespuesta());
      //se inserta un operando
      AddOperandoResponse response = new AddOperandoResponse();
      AddOperandoRequest requestop = new AddOperandoRequest();
    
      String token = respuesta.getRespuesta().substring(6);
      System.out.println(" el token es: "+token);
      requestop.setToken(token);
      requestop.setOperando(2);
      if(ValidaAddOperandoRequest.valida(requestop, response)) {
    	  AddOperandoService serviceop = new AddOperandoService();
    	  OperandoEntity operando = new OperandoEntity();
    	  operando.setToken(token);
    	  operando.setAplicado("N");
    	  operando.setOperando(requestop.getOperando());
    	  operando.setOrden(serviceop.countOperandosBySession(token)+1);
    	  serviceop.insertOperando(operando);
      }
      
	}

}
