package com.init;

import com.dao.CardapioDAO;
import com.dao.CardapioProdutoDAO;
import com.dao.MesaDAO;
import com.dao.PedidoCardapioDAO;
import com.dao.PedidoDAO;
import com.dao.ProdutoDAO;
import com.dao.UsuarioDAO;

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

		UsuarioDAO userDao = new UsuarioDAO();
		ProdutoDAO produtoDao = new ProdutoDAO();
		PedidoDAO pedidoDao = new PedidoDAO();
		PedidoCardapioDAO pedidoCardapioDao = new PedidoCardapioDAO();
		MesaDAO mesaDao = new MesaDAO();
		CardapioProdutoDAO cardapioProdutoDao = new CardapioProdutoDAO();
		CardapioDAO cardapioDao = new CardapioDAO();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// imgDao.executarComando("CREATE DATABASE IMAGEM_UPLOAD;");
			// imgDao.deletarTabela();

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {

			userDao.criarTabela();

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {

			produtoDao.criarTabela();

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {

			pedidoDao.criarTabela();

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {

			pedidoCardapioDao.criarTabela();

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {

			mesaDao.criarTabela();

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {

			cardapioProdutoDao.criarTabela();

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {

			cardapioDao.criarTabela();

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

	}

}
