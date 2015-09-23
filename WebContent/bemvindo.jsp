<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>title</title>
</head>
<body>

	<%-- Comentario em JSP --%> 

	<% String mensagem = "Bem vindo!!!"; 
	
		out.println(mensagem);
	%>

	<br/>
	<br/>
	
	<% out.println("Outro modo de imprimir: "); %>
	<%= mensagem %> 
	
	


</body>
</html>