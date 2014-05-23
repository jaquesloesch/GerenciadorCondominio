<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.vo.Usuario"%>
<%@page import="java.util.*"%>
<%@page import="com.dao.ProdutoDAO"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado</title>
</head>
<body>
	<form id="a">
		<table>
			<tr>
				<td><jsp:useBean id="agora" class="java.util.Date" /> <br>

					<fmt:formatDate value="${agora}" type="both"
						pattern="dd/MM/YYYY HH:mm:ss" /></td>
			<tr>
			<tr>

				<td>Jaques Loesch e Vitor M.M. Vieira - INF 27</td>
			<tr>
			</tr>
		</table>


		<sql:query var="qryImagens" dataSource="${ds}">
	select ID,IMAGEM_BITS,NOME_IMAGEM,CHAVE,CONTEUDO,OBSERVACAO from imagens order by id desc limit 1;
</sql:query>

		<table border="1">
			<tr>
				<!-- 				<td>Nome Imagem</td> -->
				<td>Chave</td>
				<td>Conteudo</td>
				<td>Imagem</td>
			</tr>
			<c:forEach var="ImagemVo" items="${qryImagens.rows}">
				<tr>
					<%-- 					<td>${ImagemVo.nome_imagem}</td> --%>
					<td>${ImagemVo.chave}</td>

					<td>${ImagemVo.conteudo}</td>
					<td><img src="mostraImagem?id=${ImagemVo.id}" /></td>

				</tr>
			</c:forEach>
		</table>



	</form>

</body>
</html>
