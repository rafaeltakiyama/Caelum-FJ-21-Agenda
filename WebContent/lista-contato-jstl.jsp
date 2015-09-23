<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1px">
		<tr bgcolor="7ae445">
			<td><b>Nome</b></td>
			<td><b>Email</b></td>
			<td><b>Endereco</b></td>
			<td><b>Data Nasc</b></td>
		</tr>
		<c:forEach var="contato" items="${dao.lista}" varStatus="id">
			 <tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }" >
				<td>${contato.nome}</td>
				<c:if test="${not empty contato.email}">
					<td><a href="mailto:${contato.email}">${contato.email}</a></td>
				</c:if>
				<td>${contato.endereco}</td>
				<td>${contato.dataNascimento.time}</td> 
			</tr>
		</c:forEach>
	</table>

</body>
</html>