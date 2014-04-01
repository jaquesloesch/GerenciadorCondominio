<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="upload" enctype="multipart/form-data">
<table>
<tr>
<td><label>Informe qualquer valor</label></td><td><input id="campo" name="campo" type="text"/></td>
<tr>
<tr><td colspan="2"><input type="file" id="imagem" name="imagem" size="50" /></td></tr>

<tr><td><input type="submit" value="Enviar"> </td></tr>
</table>
</form>

</body>
</html>