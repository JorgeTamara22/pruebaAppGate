package com.jota.prueba;


import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import com.jota.lambda.LambdaAddOperando;
import com.jota.lambda.LambdaRealizaOperacion;
import com.jota.request.AddOperandoRequest;
import com.jota.request.OperacionRequest;
import com.jota.request.RequestLogin;
import com.jota.response.AddOperandoResponse;
import com.jota.response.OperacionResponse;
import com.jota.response.ResponseLogin;
import com.jota.services.UsuarioService;

public class Prueba {

	private static Logger log = Logger.getLogger(Prueba.class.getName());

	public static void main(String[] args) {
		BasicConfigurator.configure();
		// TODO Auto-generated method stub
      UsuarioService service = new UsuarioService();
      RequestLogin request = new RequestLogin();
      request.setUserName("PRUEBA");
      request.setPassword("PRUEBA");
      ResponseLogin respuesta = service.buscarUsuario(request);
      log.info(respuesta.getRespuesta());
      String token = respuesta.getRespuesta().substring(6);
      log.info(" el token es: "+token);
      //se inserta un operando prueba la funcion lambdaAddOperando
      
      AddOperandoResponse responseAdd = new AddOperandoResponse();
      AddOperandoRequest requestop = new AddOperandoRequest();
    
      requestop.setToken(token);
      requestop.setOperando(2);
      LambdaAddOperando addOperando = new LambdaAddOperando();
      responseAdd = addOperando.addOperando(requestop);
      
      requestop.setToken(token);
      requestop.setOperando(7);
      responseAdd = addOperando.addOperando(requestop);
      // se inserta una Operacion Prueba de la funcion LambdaRealizaOperacion
      
      OperacionRequest oprequest = new OperacionRequest();
      OperacionResponse responseop = new OperacionResponse();
      oprequest.setToken(token);
      oprequest.setOperacion("+");
      LambdaRealizaOperacion operacion = new LambdaRealizaOperacion();
      responseop = operacion.realizaOperacion(oprequest);
      
	}

}
