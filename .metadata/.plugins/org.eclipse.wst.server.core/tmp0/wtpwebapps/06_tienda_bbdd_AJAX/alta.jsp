<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
		
		<form action="Alta" method="POST">
			Producto:<input type="text" name="nombre"><br>
			Sección:<input type="text" name="seccion"><br>
			Precio:<input type="text" name="precio"><br>
			Stock:<input type="text" name="stock"><br>
			<input type="submit" value="Guardar">
		</form>
		<br>
		<a href="inicio.jsp">Inicio</a>
	</center>
</body>
</html>