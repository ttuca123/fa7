package br.com.cursoweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Request
 */
@WebServlet("/requestServlet")
public class Request extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome");

		if (nome != null && !nome.isEmpty()) {

			request.setAttribute("NOME", nome);
			request.getSession().setAttribute("NOME", nome);
			request.getSession().getServletContext().setAttribute("NOME", nome);

		}

		String error = request.getParameter("error");

		if (error != null && !error.isEmpty()) {

			response.sendError(Integer.valueOf(error));
		}

		String redirect = request.getParameter("redirect");

		if (redirect != null && !redirect.isEmpty()) {

			response.sendRedirect(redirect);
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Usuarios</title>");
		out.println("<body>");

		out.println("getRequestURL(): " + request.getRequestURL() + "<br/>");
		out.println("getContextPath(): " + request.getContextPath() + "<br/>");
		out.println("getQueryString(): " + request.getQueryString() + "<br/>");
		out.println("getMethod(): " + request.getMethod() + "<br/>");
		out.println("getProtocol(): " + request.getProtocol() + "<br/>");

		out.println("<br/>");

		out.println("NOME Request: " + request.getAttribute("NOME") + "<br/>");
		out.println("NOME Session: "
				+ request.getSession().getAttribute("NOME") + "<br/>");
		out.println("Sistema Home: "
				+ request.getSession().getServletContext().getMajorVersion()
				+ "<br/>");
		
		out.println("<hr/><a href=\"/cursoWeb/\">Voltar</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
