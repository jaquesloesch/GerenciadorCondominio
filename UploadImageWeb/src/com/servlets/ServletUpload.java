package com.servlets;

import java.io.File;
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

//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doPost(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//
//		PrintWriter out = response.getWriter();
//
//		String[] o = (String[])request.getParameterValues("imagem");
//		StringBuilder caminhoImagem = new StringBuilder();
//		
//		for (int i = 0; i < o.length; i++) {
//			caminhoImagem.append(o[i]);	
//		}
//		try {
////			out.print("Imagen encaminhada com sucesso!");
//			out.print(caminhoImagem.toString());
//			// if (new Upload().anexos(request, response)) {
//			// out.print("Arquivo enviado!");
//			// } else {
//			// out.print("Arquivo não enviado!");
//			// }
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	 @Override  
	    protected void doPost( HttpServletRequest request, HttpServletResponse response )  
	            throws ServletException, IOException  
	    {  
	        String      strFileName = null;  
	        boolean     bOk         = true;  
	        PrintWriter out         = response.getWriter( );  
	          
	        String strOptionalFileName = "";  
	        String strOptionalFile     = "";  
	          
	        try  
	        {  
	        	
	            if( ServletFileUpload.isMultipartContent( request ) )  
	            {  
	                ServletFileUpload servletFileUpload = new ServletFileUpload( new DiskFileItemFactory( ) );  
	                  
	                List listFileItemsList = servletFileUpload.parseRequest( request );  
	                  
	                FileItem fileItem = null;  
	                Iterator it       = listFileItemsList.iterator( );  
	                
	                while( it.hasNext( ) )  
	                {  
	                    FileItem fileItemTemp = ( FileItem )it.next( );  
	                      
	                    if( !fileItemTemp.isFormField( ) )  
	                    {         
	                        fileItemTemp.getFieldName( ).equals( "file1" );     
	                        strOptionalFile     = fileItemTemp.getString( );    
	                        strOptionalFileName = fileItemTemp.getName( );    
	                        fileItem            = fileItemTemp;  
	                          
	                        if( fileItem != null )  
	                        {  
	                        	
	                        	out.print("Content type: "+fileItem);
//	                            strFileName = fileItem.getName( );  
//	                            if( fileItem.getSize( ) > 0 )  
//	                            {  
//	                                if( strOptionalFile.trim().equals( "" ) )  
//	                                    strFileName = FilenameUtils.getName( strFileName );  
//	                                else  
//	                                    strFileName = strOptionalFileName;  
	                                  
//	                                String dirName = "C:\\Users\\Nina\\workspace\\Daisy\\WebContent\\fotos\\pontocruz.png";  
	                                  
//	                                File saveTo = new File( dirName );  
	                                  
//	                                try  
//	                                {  
//	                                    fileItem.write( saveTo );  
//	                                }  
//	                                catch( Exception e )  
//	                                {  
//	                                    bOk = false;  
//	                                }  
//	                                  
//	                                if( bOk )  
//	                                {  
//	                                    RequestDispatcher rd = request.getRequestDispatcher( "/fotos/Resposta.html" );  
//	                                    rd.forward( request, response );  
//	                                    //out.println( "/fotos/corDominante.htm" );  
//	                                }  
//	                            }  
	                        }  
	                    }  
	                }  
	            }  
	        }  
	        catch( Exception e )  
	        {  
	            e.printStackTrace();  
	        }  
	    }
}