package com.jota.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.jota.connection.ConexionMariaDB;
import com.jota.request.RequestLogin;
import com.jota.response.ResponseLogin;

public class UsuarioService {
	
	 static final Logger logger = Logger.getLogger(UsuarioService.class);
	
	public ResponseLogin buscarUsuario(RequestLogin request) {	
		
		 Connection conn = null;
		try {   
		  conn = ConexionMariaDB.connectDatabase();
		 Statement stmt;		 
		 stmt = conn.createStatement();	
		 String sql = "SELECT count(1) existe FROM usuario u "
		 		+ "where u.nombre = '"+request.getUserName()+"' "
		 				+ "and u.password = '"+request.getPassword()+"'";
	     ResultSet rs = stmt.executeQuery(sql);
	     while ( rs.next() ) {
             int  resultado = Integer.parseInt(rs.getString("existe"));
             if(resultado>0) {
               String token=insertaToken(request); 
               return new ResponseLogin("token: "+token);
             }else {
            	 return new ResponseLogin("mensaje: Usuario no Encontrado"); 
             }
         }
         conn.close();	
		} catch (SQLException e) {
			 try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			logger.error("Error al buscar el Usuario: "+e.getMessage());
		}
		return new ResponseLogin("");
	}
	
	public String insertaToken(RequestLogin request) {
		
		String token = "";
		Connection conn = null;
		try {   
			
			token = org.apache.commons.codec.digest.DigestUtils.sha1Hex( request.getPassword()+Math.random());
			conn = ConexionMariaDB.connectDatabase();
			 Statement stmt;		 
			 stmt = conn.createStatement();	
			 String sql = "UPDATE usuario u set u.token = '"+token.trim()
			 		+ "' where u.nombre = '"+request.getUserName()+"' "
			 				+ "and u.password = '"+request.getPassword()+"'";
		   stmt.executeUpdate(sql);		     
		   
		     conn.close();
	         	
			} catch (SQLException e) {	
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				logger.error("Error al generar el token: "+e.getMessage());
			}
		return token;
	}
	
	public boolean buscarToken(String token) {
		boolean existe = false;
		Connection conn = null;
		try {
			conn = ConexionMariaDB.connectDatabase();
			PreparedStatement stmt;
			String sql = "select count(1) FROM usuario u where u.token = ?";
			 stmt = conn.prepareStatement(sql);	
			 stmt.setString(1, token.trim());
		     ResultSet rs = stmt.executeQuery();
		     while ( rs.next() ) {
		    	 System.out.println("resul"+rs.getString(1));
	             int  resultado = Integer.parseInt(rs.getString(1));
	             if(resultado>0) {	                
	               existe = true;
	             }
	         }
	         conn.close();	
			} catch (SQLException e) {
				 try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				logger.error("Error al buscar el Token: "+e.getMessage());
			}
		return existe;
	}
 
}
