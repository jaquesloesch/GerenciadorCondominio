package com.init;

import com.dao.ImagemDao;

public class ConfigureTables {

	public static void main(String[] args) {
		try {
			createTables();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void createTables() throws Exception {

		ImagemDao imgDao = new ImagemDao();
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			imgDao.executarComando("CREATE DATABASE IMAGEM_UPLOAD;");
//			imgDao.deletarTabela();

			

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
//		try {
//
////			imgDao.criarTabela();
//
//		} catch (ClassNotFoundException e1) {
//			e1.printStackTrace();
//		}

	}

}
