<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>Página principal</title>
</head>
<body>
	Bem Vindo
	<%=session.getAttribute("login_name")%>

	<f:view>


		<table border="1">
			<tr>
				<th>Paginas</th>
				<th>Views</th>
			</tr>
			<tr>
				<td><a href="pagina1.xhtml"><%="Página 1:"%></a></td>

				<td>
					<%
						if (application.getAttribute("page1") == null) {

								application.setAttribute("page1", 0);

							}
					%> <%=application.getAttribute("page1")%> views
				</td>
			</tr>

			<tr>
				<td><a href="pagina2.xhtml">Página 2: </a></td>
				<td>
					<%
						if (application.getAttribute("page2") == null) {

								application.setAttribute("page2", 0);
							}
					%> <%=application.getAttribute("page2")%> views
				</td>
			</tr>

		</table>

		<a href="index.xhtml">Voltar</a>

	</f:view>
</body>
</html>