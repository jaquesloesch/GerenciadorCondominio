package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
@WebServlet("/upload")
public class ServletUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletUpload() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {

//			ConfigureTables.createTables();

		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("Erro ao criar tabela");
		}
		Usuario img = new Usuario();
		try {

			if (ServletFileUpload.isMultipartContent(request)) {
				ServletFileUpload servletFileUpload = new ServletFileUpload(
						new DiskFileItemFactory());

				List<?> listFileItemsList = servletFileUpload
						.parseRequest(request);

				FileItem fileItem = null;
				Iterator<?> it = listFileItemsList.iterator();

				while (it.hasNext()) {
					FileItem fileItemTemp = (FileItem) it.next();

					if (!fileItemTemp.isFormField()) {
						fileItemTemp.getFieldName().equals("file1");
						fileItem = fileItemTemp;
					
//						img = new ProdutoDAO().procuraPeloId(new ProdutoDAO().getProximoId() -1);
//						
//						img.setFileItem(fileItem);
//					
//
//						new ProdutoDAO().atualiza(img);
					}

				}

			}

			
		} catch (Exception exc) {
			exc.printStackTrace();
			System.out.println(exc.getMessage());
		}

		RequestDispatcher rd = request.getRequestDispatcher("resposta.jsp");
		rd.forward(request, response);

	}
	// @Override
	// protected void doPost(HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException {
	// PrintWriter out = response.getWriter();
	// try {
	//
	// ConfigureTables.createTables();
	// } catch (Exception e1) {
	// e1.printStackTrace();
	// System.out.println("Erro ao criar tabela");
	// }
	// ImagemVo img = new ImagemVo();
	// try {
	//
	// if (ServletFileUpload.isMultipartContent(request)) {
	// ServletFileUpload servletFileUpload = new ServletFileUpload(
	// new DiskFileItemFactory());
	//
	// List<?> listFileItemsList = servletFileUpload
	// .parseRequest(request);
	//
	// FileItem fileItem = null;
	// Iterator<?> it = listFileItemsList.iterator();
	//
	// while (it.hasNext()) {
	// FileItem fileItemTemp = (FileItem) it.next();
	//
	// if (!fileItemTemp.isFormField()) {
	// fileItemTemp.getFieldName().equals("file1");
	//
	// fileItem = fileItemTemp;
	// //System.out.println(fileItem.getName());
	// img.setNomeImagem(fileItem.getName());
	// img.setFileItem(fileItem);
	// img.setChave(((FileItem) listFileItemsList.get(1))
	// .getString());
	// img.setConteudo(((FileItem) listFileItemsList.get(2))
	// .getString());
	// img.setObservacao(((FileItem) listFileItemsList.get(3))
	// .getString());
	//
	// }
	//
	// }
	//
	// }
	//
	// new ImagemDao().insere(img);
	//
	// // try {
	// // List<ImagemVo> lista = new ImagemDao().getTodos();
	// // response.setContentType("image/jpg");
	// //
	// // for (ImagemVo imagemVo : lista) {
	// //
	// // response.setContentType("image/jpg");
	// // response.setContentLength(imagemVo.getImgArray().length);
	// // response.getOutputStream().write(imagemVo.getImgArray());
	// //
	// // response.getOutputStream().flush();
	// // response.getOutputStream().close();
	// //
	// // // break;
	// // }
	// // } catch (Exception e) {
	// // e.printStackTrace();
	// // System.out.println("Erro ao carregar listar as imagens");
	// // }
	// out.println("<html><form method=\"get\" enctype=\"multipart/form-data>\"");
	// try {
	// List<ImagemVo> lista = new ImagemDao().getTodos();
	// // response.setContentType("image/jpg");
	//
	// for (ImagemVo imagemVo : lista) {
	// String href = "";
	// href += "<a href=\"mostraImagem?id=" + imagemVo.getId()
	// + "\" > " + imagemVo.getNomeImagem() + "</a>";
	// out.println(href + "</br>");
	//
	// }
	// out.println("</form></html>");
	// } catch (Exception e) {
	// e.printStackTrace();
	// System.out.println("Erro ao carregar listar as imagens");
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// System.out.println("Erro ao carregar a servlet");
	// }
	// }
}