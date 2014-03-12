package com.conexao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

import com.enums.EErros;
import com.exceptions.ExcecaoInterna;

/**
 * Classe referente a conexão com o banco de dados
 * 
 * @author Jaques Loesch
 * @author Vitor Vieira
 * 
 */
public class Conexao {
	private static String url = "";
	private static String user = "";
	private static String senha = "";
	private static Connection conn;

	public static Connection getConexao() throws ExcecaoInterna {
		try {

			if (conn == null) {
				configurar();
				conn = DriverManager.getConnection(url, user, senha);
			}
			return conn;
		} catch (Exception e) {
			throw new ExcecaoInterna(e, EErros.FALHA_BANCO);
		}

	}

	public static void closeConexao() throws ExcecaoInterna {
		try {
			if (conn instanceof Connection) {
				conn.close();
				conn = null;
			}
		} catch (Exception e) {
			throw new ExcecaoInterna(e, EErros.FALHA_BANCO);
		}
	}

	private static void configurar() {

		String arquivoConfiguracao = "banco_dados.txt";

		try {

			FileReader reader = new FileReader(new File(arquivoConfiguracao));
			@SuppressWarnings("resource")
			BufferedReader leitor = new BufferedReader(reader);

			int linhaCnt = 0;
			String linha = null;
			while ((linha =  leitor.readLine()) != null) {
				switch (linhaCnt) {
				case 0:
					url = linha;
					break;
				case 1:
					user = linha;
					break;
				case 2:
					senha = linha;
					break;

				default:
					break;
				}
				linhaCnt++;

			}

		} catch (Exception e) {
			//TODO LOG4J
//			UtilLog.logarErro(e.getMessage());
//			UtilLog.logarErro("ARQUIVO DE BANCO DE DADOS NAO ENCONTRADO");

		}

	}
}
