<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset style="border: 5px solid gray">
    <legend style="color: rgb(255, 155, 118)">Alta de alumno</legend>
    <form action="altaAlumno" method="POST">
        Usuario:
        <br>
        <input type="text" name="usuario" placeholder="Usuario" required><br>
		<br>
        Contraseña:
        <br>
        <input type="password" name="password" placeholder="Contraseña" required><br>
		<br>
        Nombre:
        <br>
        <input type="text" name="nombre" placeholder="Nombre" required><br>
		<br>
        Email:
        <br>
        <input type="text" name="email" placeholder="email" required><br>
		<br>
        Edad:
        <br>
        <input type="number" name="edad" placeholder="Edad" required><br>
        <br>

        <input type="submit" value="Guardar">
	</form>
	<br>
    <a href="menu.jsp">Volver</a>
</fieldset>
</body>
</html>