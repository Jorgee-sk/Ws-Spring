<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"  href="css/transferencia.css">
<title>Ingresar Dinero</title>
</head>
<body>
	<div>
		<h1>Ingreso</h1>
		<form action="Ingreso" method="post">
			<div>
			<button type="button" disabled>Cantidad</button><input type="number" name="cantidad" placeholder="Cantidad" required />
			</div>
			<br>
			<br>
			<input type="submit" value="Ingresar" class="submitButton"/>
		</form>
		<br>
		<br>
		<br>
		<br>
		<a href="menu.jsp">Volver</a>
	</div>
</body>
</html>