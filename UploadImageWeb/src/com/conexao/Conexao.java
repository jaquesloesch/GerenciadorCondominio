package com.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe referente a conexão com o banco de dados
 * 
 * @author Jaques Loesch
 * @author Vitor Vieira
 * 
 */
public class Conexao {

	private static String url = "jdbc:mysql://localhost:3306/teste";
	private static String user = "root";
	private static String senha = "";
	private static Connection conn;

	public static Connection getConexao() throws Exception {
		try {

			if (conn == null) {
				conn = DriverManager.getConnection(url, user, senha);
			}
			return conn;
		} catch (Exception e) {
			throw e;
		}

	}

	public static void closeConexao() throws Exception {
		try {
			if (conn instanceof Connection) {
				conn.close();
				conn = null;
			}
		} catch (Exception e) {
			throw e;
		}
	}

}
