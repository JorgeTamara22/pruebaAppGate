package com.jota.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.jota.connection.ConexionMariaDB;
import com.jota.entities.OperandoEntity;

public class AddOperandoService {

	static final Logger logger = Logger.getLogger(AddOperandoService.class);

	public boolean insertOperando(OperandoEntity operando) {
		BasicConfigurator.configure();
		boolean res = false;
		Connection conn = null;
		try {

			conn = ConexionMariaDB.connectDatabase();
			PreparedStatement stmt;

			String sql = "INSERT INTO appgateDB.operando\r\n" + "(token, operando, orden, aplicado)\r\n"
					+ "VALUES(?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, operando.getToken().trim());
			stmt.setDouble(2, Double.valueOf(operando.getOperando().toString()));
			stmt.setInt(3, operando.getOrden());
			stmt.setString(4, operando.getAplicado());

			stmt.executeUpdate();

			res = true;

			conn.close();

		} catch (SQLException e) {
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			logger.error("Error al Insertar el operando: " + e.getMessage());
		}
		return res;
	}

	public int countOperandosBySession(String token) {
		int resultado = 0;
		Connection conn = null;
		try {
			conn = ConexionMariaDB.connectDatabase();
			PreparedStatement stmt;
			String sql = "select count(1) from operando o where o.aplicado = 'N' and o.token = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, token.trim());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
			resultado = Integer.parseInt(rs.getString(1));
			}
			conn.close();
		} catch (SQLException e) {
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			logger.error("Error al obtener el conteo de operandos: " + e.getMessage());
		}
		return resultado;
	}

	public ArrayList<Number> obtieneOperandos(String token) {
		ArrayList<Number> listOperandos = new ArrayList<Number>();
		Connection conn = null;
		try {
			conn = ConexionMariaDB.connectDatabase();
			PreparedStatement stmt;
			String sql = "select o.operando from operando o where o.aplicado = 'N' and o.token = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, token.trim());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				listOperandos.add(rs.getInt(1));
			}
			conn.close();
		} catch (SQLException e) {
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			logger.error("Error al obtener la lista de operandos: " + e.getMessage());
		}
		return listOperandos;
	}

	public boolean updateOperando(String token) {
		boolean res = false;
		Connection conn = null;
		try {

			conn = ConexionMariaDB.connectDatabase();
			PreparedStatement stmt;

			String sql = "update operando o set o.aplicado = 'S' where o.aplicado = 'N' and o.token = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, token.trim());

			stmt.executeUpdate();

			res = true;

			conn.close();

		} catch (SQLException e) {
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			logger.error("Error al actualizar los operandos: " + e.getMessage());
		}
		return res;
	}

}
