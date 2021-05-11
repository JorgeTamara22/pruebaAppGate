package com.jota.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.jota.request.RequestLogin;
import com.jota.response.ResponseLogin;
import com.jota.services.UsuarioService;

import static com.jota.constants.Constants.ERROR_AUTENTICACION;

import java.util.logging.Logger;

import org.apache.log4j.BasicConfigurator;

public class LambdaLogin implements RequestHandler<RequestLogin, ResponseLogin> {
	private Logger log = Logger.getLogger(LambdaLogin.class.getName());

	@Override
	public ResponseLogin handleRequest(RequestLogin request, Context context) {
		BasicConfigurator.configure();
		try {
			UsuarioService login = new UsuarioService();

			return login.buscarUsuario(request);

		} catch (Exception e) {
            log.info(e.getMessage());
			return new ResponseLogin(ERROR_AUTENTICACION);
		}
	}
}
