package br.com.facear.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {

	private static String user = "root";
	private static String pass = "";
	private static String url = "jdbc:mysql://localhost:3306/meuempregado";
	private static String driver = "com.mysql.jdbc.Driver";
	
	
	private Conexao() {
	}
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, pass);
		return con;
	}
}
