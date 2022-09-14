<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">

        <link rel="stylesheet" href="resources/style.css" type="text/css">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Clientes</title>
</head>
<body>
	<div align="center" id="wrapper">
		<h1>New/Edit Cliente</h1>
		<form:form action="saveCliente" method="post" modelAttribute="cliente" id="keywords">
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>Nombre:</td>
				<td><form:input path="Nombre" /></td>
			</tr>
			<tr>
				<td>Modelo del coche:</td>
				<td><form:input path="ModCoche" /></td>
			</tr>
			<tr>
				<td>Placas:</td>
				<td><form:input path="Placa" /></td>
			</tr>
			<tr>
				<td>Consideraciones:</td>
				<td><form:input path="Consideraciones" /></td>
			</tr>
			<tr>
				<td>Telefono:</td>
				<td><form:input path="Telefono" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>