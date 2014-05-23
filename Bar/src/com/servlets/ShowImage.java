package com.servlets;

import java.awt.image.RenderedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.ProdutoDAO;
import com.init.ConfigureTables;
import com.vo.Usuario;

/**
 * Servlet implementation class ServletUpload
 */
@WebServlet("/mostraImagem")
public class ShowImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowImage() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
//			List<Usuario> lista = new ProdutoDAO().getTodos();
//
//			Usuario imagemVo = new ProdutoDAO().procuraPeloId(Integer
//					.parseInt(request.getParameter("id")));

//			response.setContentType("image/jpg");
//			response.setContentLength(imagemVo.getImgArray().length);
//			response.getOutputStream().write(imagemVo.getImgArray());
//			response.setContentType("text/html");

			response.getOutputStream().close();

			// break;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao carregar listar as imagens");
		}

	}
}