<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.caelum.jdbc.modelo.Contato"%>
<%@page import="java.util.List"%>
<%@page import="br.com.caelum.jdbc.dao.ContatoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1px">
	<tr>
		<td><b>Nome</b></td>
		<td><b>Email</b></td>
		<td><b>Endereco</b></td>
		<td><b>Data Nasc</b></td>
	</tr>
	<% ContatoDao dao = new ContatoDao();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
		List<Contato> contatos = dao.getLista();
	
		for(Contato c : contatos){
	%>
		<tr>
			<td><%=c.getNome()%></td>
			<td><%=c.getEmail()%></td>
			<td><%=c.getEndereco()%></td>
			<td><%=sdf.format(c.getDataNascimento().getTime())%></td> 
		</tr> 
	<%
		}
	%>
</table>

</body>
</html>