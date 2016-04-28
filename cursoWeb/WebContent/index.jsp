<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Pagina Inicial</title>
</head>
<body>
	Ola Java EE!<br />
	Hoje e <%= new Date() %><br />
	<a href="usuariosServlet">Listar Usuarios</a><br />
	<a href="requestServlet">Request Servlet</a><br />
	<a href="sessionServlet">Session Servlet</a><br />
</body>
</html>