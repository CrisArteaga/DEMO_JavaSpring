<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
	<link rel="stylesheet" href="resources/style.css" type="text/css">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Servicios</title>
</head>
<body>
	<div align="center" id="wrapper">
		<h1>New/Edit Servicio</h1>
		<form:form action="saveServicio" method="get" modelAttribute="servicio" enctype="multipart/form-data" id="keywords">
		<table>
			<form:hidden path="id"/>
			<tr>
				<td>ID:</td>
				<td><form:input path="id_cliente" value="${param.id}" readonly="true" /></td>
			</tr>
			<tr>
				<td>Cliente:</td>
				<td><form:input path="name" value="${param.name}" readonly="true" /></td>
			</tr>
			<tr>
				<td>Servicio proporcionado:</td>
				<td><form:input path="Servicio" /></td>
			</tr>
			<tr>
				<td>Fecha:</td>
				<td><form:input path="Fecha" /></td>
			</tr>
			<tr>
				<td>Mecanico:</td>
				<td><form:input path="Mecanico" /></td>
			</tr>
			<tr>
				<td>Importe:</td>
				<td><form:input path="Importe" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save" ></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>