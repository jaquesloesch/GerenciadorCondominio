<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/imagem_upload" user="root" password=""
	scope="session" />

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="nextPagina.jsp">
		<jsp:useBean id="agora" class="java.util.Date" />

		<br>

		<fmt:formatDate value="${agora}" type="both"
			pattern="dd/MM/YYYY HH:mm:ss" />
		<table>
			<tr>
				<td></td>
			<tr>
			<tr>
				<td><label>Nome:</label></td>
				<td>Jaques Loesch e Vitor M.M. Vieira - INF 27</td>
			<tr>
			<tr>
				<td><label>Chave:</label></td>
				<td><input id="chave" name="chave" type="text" /></td>
			<tr>
			<tr>
				<td><label>Conteudo:</label></td>
				<td><textarea id="conteudo" name="conteudo"></textarea></td>
			<tr>
			<tr>
				<td><label>Obs:</label></td>
				<td><textarea id="obs" name="obs"></textarea></td>
			<tr>
			<tr>
				<td><input id="enviarForm" type="submit" value="Proximo passo"></td>
			</tr>

			<tr>
				<td><a href="WorksPace"> Workspace.zip </a></td>
			</tr>
		</table>

	</form>

</body>
</html>