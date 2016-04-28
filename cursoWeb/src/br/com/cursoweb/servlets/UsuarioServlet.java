package br.com.cursoweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cursoweb.modelo.Usuario;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/usuariosServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> usuarios = new ArrayList<Usuario>();

		usuarios.add(new Usuario("Joao", "joao@gmail.com"));
		usuarios.add(new Usuario("Maria", "maria@gmail.com"));
		usuarios.add(new Usuario("Beth", "beth@gmail.com"));
		usuarios.add(new Usuario("Magda", "magda@gmail.com"));

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Usuarios</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<ul>");

		for (Usuario usuario : usuarios) {

			out.println("<li>");
			out.println("<a href=\"requestServlet?nome="+usuario.getNome()+"\"" + usuario.getNome() + "\">");
			out.println(usuario.getNome());
			out.println("</a>");
			out.println("</li>");

		}
		out.println("</ul>");
		out.println("<hr/><a href=\"/cursoweb/\">Voltar</a>");
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
		// TODO Auto-generated method stub
	}

}
