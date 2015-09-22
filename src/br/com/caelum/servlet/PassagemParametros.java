package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;

@WebServlet(name = "TesteParamsProgram", urlPatterns = { "/oi3" }, initParams = {
		@WebInitParam(name = "param1", value = "value1"),
		@WebInitParam(name = "param2", value = "value2") })
public class PassagemParametros extends HttpServlet {

	// para recuperar temos tres possibilidades:

	// 1
	private String parametro1;
	private String parametro2;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.parametro1 = config.getInitParameter("param1");
		this.parametro2 = config.getInitParameter("param2");
		
		System.out.println(parametro1);
		System.out.println(parametro2);
	}

	// 2
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<h2>Exemplo com InitParam Servlet</h2>");

		ServletConfig config = getServletConfig();

		String parametro1 = config.getInitParameter("param1");
		out.println("Valor do parâmetro 1: " + parametro1);

		String parametro2 = config.getInitParameter("param2");
		out.println("<br>Valor do parâmetro 1: " + parametro2);

		out.close();
	}
	
	// 3
//	public void service(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//
//		out.println("<h2>Exemplo com InitParam Servlet</h2>");
//
//		out.println("Valor do parâmetro 1: "
//				  + getServletConfig().getInitParameter("param1"));
//
//		out.close();
//	}

}
