<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <link rel="stylesheet" href="resources/style.css" type="text/css">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>
    </head>
    <body>
    	<div align="center" id="wrapper">
	        <h1>Modal CRUD: Lista de clientes</h1>
	        <h2><a href="newCliente"><span class="icon-house"></span> Nuevo Cliente</a></h2>
	        <table border="1" id="keywords">
	        <thead>
	        	<th>ID</th>
	        	<th>Nombre</th>
	        	<th>Modelo del coche</th>
	        	<th>Placas</th>
	        	<th>Consideraciones</th>
	        	<th>Telefono</th>
	        	<th>Acciones</th>
	        </thead>

				<c:forEach var="cliente" items="${listCliente}" varStatus="status">
	        	<tr>
	        		<td>${cliente.id}</td>
					<td>${cliente.nombre}</td>
					<td>${cliente.modCoche}</td>
					<td>${cliente.placa}</td>
					<td>${cliente.consideraciones}</td>
					<td>${cliente.telefono}</td>
					<td>
						<a href="editCliente?id=${cliente.id}">Editar</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteCliente?id=${cliente.id}">Borrar</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="Servicios?id=${cliente.id}&name=${cliente.nombre}">Servicios</a>
					</td>
							
	        	</tr>
				</c:forEach>
			</table>
    	</div>
    </body>
</html>
