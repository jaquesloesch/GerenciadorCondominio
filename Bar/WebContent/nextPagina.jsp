<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.vo.Usuario"%>
<%@page import="com.dao.ProdutoDAO"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enviar Imagem</title>
</head>
<body>
	<form method="post" action="upload" enctype="multipart/form-data">

		<c:catch var="erro">
			<sql:transaction dataSource="${ds}">
				<sql:update>
			insert into Imagens (chave,conteudo,observacao) values (?, ?, ?);
			<sql:param value="${param.chave}" />
					<sql:param value="${param.conteudo}" />
					<sql:param value="${param.obs}" />
				</sql:update>
			</sql:transaction>
		</c:catch>




		<table>

			<tr>
				<td colspan="2"><h2>Selecione a imagem</h2></td>
			</tr>
			<tr>
				<td colspan="2"><input type="file" id="imagem" name="imagem"
					size="50" /></td>
			</tr>
			<tr>
				<td><input id="enviarImagem" type="submit"
					value="Enviar Imagem"></td>
			</tr>
		</table>
	</form>

</body>
</html>
