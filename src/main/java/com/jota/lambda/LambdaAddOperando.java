package com.jota.lambda;

import java.util.Arrays;
import java.util.logging.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.jota.entities.OperandoEntity;
import com.jota.request.AddOperandoRequest;
import com.jota.response.AddOperandoResponse;
import com.jota.services.AddOperandoService;
import com.jota.valida.ValidaAddOperandoRequest;

public class LambdaAddOperando implements RequestHandler<AddOperandoRequest, AddOperandoResponse> {

	private Logger log = Logger.getLogger(LambdaAddOperando.class.getName());


	@Override
	public AddOperandoResponse handleRequest(AddOperandoRequest request, Context context) {
		AddOperandoResponse response = new AddOperandoResponse();
		log.info("Peticion Entrante::addOperando::" + request.toString());
		try {
			if (ValidaAddOperandoRequest.valida(request, response)) {
				AddOperandoService serviceop = new AddOperandoService();
		    	  OperandoEntity operando = new OperandoEntity();
		    	  operando.setToken(request.getToken());
		    	  operando.setAplicado("N");
		    	  operando.setOperando(request.getOperando());
		    	  operando.setOrden(serviceop.countOperandosBySession((request.getToken())+1));
		    	  serviceop.insertOperando(operando);	    	  
		    	
				   response.setMessages(Arrays.asList("Operacion Realizada Existosamente"));
				   response.setValue("OK");
               
			}
		} catch (Exception e) {
           e.printStackTrace();
		}
		log.info("Respuesta Saliente::addOperando:" + response.toString());
		return response;
	}
}
