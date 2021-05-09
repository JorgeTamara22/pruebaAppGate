package com.jota.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionMariaDB {
	
	 public static Connection connectDatabase() {
		 Connection connection = null;
	        try {
	           
	        	Class.forName("org.mariadb.jdbc.Driver");
	        	
	          // Conectamos con la base de datos
	        	connection = DriverManager.getConnection(
	        			"jdbc:mariadb://dbappgate.ctriyuvixcph.us-east-1.rds.amazonaws.com:3306/appgateDB?user=jota&password=3928Jota");
	          
	        } catch (java.sql.SQLException sqle) {
	            System.out.println("Error: " + sqle);
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return connection;
	    }  

}
