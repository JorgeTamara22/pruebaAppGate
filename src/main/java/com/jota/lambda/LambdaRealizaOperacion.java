package com.jota.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

import org.apache.log4j.BasicConfigurator;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.jota.entities.OperandoEntity;
import com.jota.request.OperacionRequest;
import com.jota.response.OperacionResponse;
import com.jota.services.AddOperandoService;
import com.jota.util.MyMath;
import com.jota.valida.ValidaOperacionRequest;

public class LambdaRealizaOperacion implements RequestHandler<OperacionRequest, OperacionResponse> {
	private Logger log = Logger.getLogger(LambdaRealizaOperacion.class.getName());

	@Override
	public OperacionResponse handleRequest(OperacionRequest request, Context context) {
		
		OperacionResponse response = realizaOperacion(request);
		return response;
		
	}
	
	public OperacionResponse realizaOperacion(OperacionRequest request) {
		BasicConfigurator.configure();
		log.info("Peticion Entrante::addOperando::" + request.toString());
		OperacionResponse response = new OperacionResponse();
		try {
			if (ValidaOperacionRequest.valida(request, response)) {
                  AddOperandoService service = new AddOperandoService();
                  ArrayList<Number> listaOperandos = service.obtieneOperandos(request.getToken());
                  if(listaOperandos!=null && !listaOperandos.isEmpty() && listaOperandos.size()>=2) {
                	  Number total=MyMath.calculate(request.getOperacion(),listaOperandos);
                	  if(service.updateOperando(request.getToken())) {
                		  OperandoEntity operandoEnt = new OperandoEntity();
                		  operandoEnt.setToken(request.getToken());
                		  operandoEnt.setOperando(total);
                		  operandoEnt.setAplicado("N");
                		  operandoEnt.setOrden(1);
                		  service.insertOperando(operandoEnt);
                		  response.setMessages(Arrays.asList("Operacion Realizada Exitosamente"));
						  response.setValue(total);
                	  }
                  }else {
                	  response.setMessages(Arrays.asList("Debe Ingresar mas operandos para realizar la operacion"));
                  }
                 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("Respuesta Saliente::addOperando:" + response.toString());
		return response;
	}
}
