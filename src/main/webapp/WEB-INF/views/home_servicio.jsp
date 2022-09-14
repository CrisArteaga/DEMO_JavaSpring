<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="resources/style.css" type="text/css">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Servicios</title>
    </head>
    <body>
    	<div align="center" id="wrapper">
	        <h1>Modal CRUD: Lista de servicios</h1>
	        <h1>${param.name}</h1>
	        <h2><a href="clientes"> Regresar</a> <a style="margin: 20px"></a>
	        <a href="newServicio?id=${param.id}&name=${param.name}">       Nuevo Servicio</a></h2>
	        <table border="1" id="keywords">
	        <thead>
	        	<th>No</th>
	        	<th>Servicio</th>
	        	<th>Fecha</th>
	        	<th>Mecanico</th>
	        	<th>Importe</th>
	        	<th>Acciones</th>
	        </thead>

				<c:forEach var="servicio" items="${listServicio}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${servicio.servicio}</td>
					<td>${servicio.fecha}</td>
					<td>${servicio.mecanico}</td>
					<td>${servicio.importe}</td>
					<td>
						<a href="editServicio?id1=${servicio.id}&id=${param.id}&name=${param.name}">Editar</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteServicio?id1=${servicio.id}&id=${param.id}&name=${param.name}">Borrar</a>
					</td>

	        	</tr>
				</c:forEach>
			</table>
    	</div>
    </body>
</html>