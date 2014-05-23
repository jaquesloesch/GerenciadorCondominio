<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/trabfinal" user="root" password=""
	scope="session" />

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="cadastrarUsuario.jsp">

		<c:if test="${param.login != null}">
			<c:catch var="erro">
				<sql:transaction dataSource="${ds}">
					<sql:update>
		        	insert into Usuario (login,senha,tipo_usuario) values (?, ?, ?);
			        <sql:param value="${param.login}" />
						<sql:param value="${param.senha}" />
						<sql:param value="${param.tipoUsuario}" />
					</sql:update>
				</sql:transaction>
			</c:catch>


		</c:if>
		<table>
			<tr>
				<td><label>Tipo Usuario:</label></td>
				<td><select id="tipoUsuario" name="tipoUsuario">
						<option value="admin">Admin</option>
						<option value="garcom">Garcom</option>
				</select></td>
			<tr>
			<tr>
				<td><label>Login:</label></td>
				<td><input id="login" name="login" type="text" /></td>
			<tr>
			<tr>
				<td><label>Senha:</label></td>
				<td><input id="senha" name="senha" type="password"></input></td>
			<tr>
			<tr>
				<td><input id="enviarForm" type="submit"
					value="Cadastrar Usuario"></td>
			</tr>
		</table>
	</form>
</body>
</html>