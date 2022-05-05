<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta curso</title>
</head>
<body>
<fieldset style="border: 5px solid gray">
    <legend style="color: rgb(255, 155, 118)">Alta de curso</legend>
    <form action="altaCurso" method="POST">
        Nombre:
        <br>
        <input type="text" name="nombre" placeholder="Nombre" required><br>
		<br>
        Duracion:
        <br>
        <input type="text" name="duracion" placeholder="Duracion" required><br>
		<br>
        Fecha:
        <br>
        <input type="date" name="fecha" placeholder="Fecha de inicio" required><br>
        <br>

        <input type="submit" value="Guardar">
	</form>
	<br>
    <a href="menu.jsp">Volver</a>
</fieldset>
</body>
</html>