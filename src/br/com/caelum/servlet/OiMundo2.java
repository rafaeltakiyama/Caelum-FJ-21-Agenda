package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * Utilizando a anotacao 
 * @WebServlet, nao ha a necessidade
 * de configurar a Servlet no web.xml
 */

@WebServlet("/oi2")
public class OiMundo2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("Segundo Servlet!!!");
		out.println("</body>");
		out.println("</html>");
	}

}
