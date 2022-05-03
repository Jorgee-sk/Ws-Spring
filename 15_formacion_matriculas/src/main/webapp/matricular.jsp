<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Matricular</title>
</head>
<body>
<fieldset style="border: 5px solid gray">
    <legend style="color: rgb(255, 155, 118)">Matriculación</legend>
    <form action="matricular" method="POST">
        Usuario:
        <br>
        <input type="text" name="usuario" placeholder="Usuario" required><br>
		<br>
        Curso:
        <br>
        <input type="text" name="idCurso" placeholder="Curso" required><br>
		<br>

        <input type="submit" value="Matricular">
	</form>
	<br>
    <a href="menu.jsp">Volver</a>
</fieldset>
</body>
</html>