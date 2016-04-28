package br.com.cursoweb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author Artur
 *
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		logar(request, response);
	}

	private void logar(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession session = ((HttpServletRequest) request).getSession();

		RequestDispatcher requestDispatcher;

		String userName = "teste";

		String password = "123";

		if (userName.equals(request.getParameter("user"))
				&& password.equals(request.getParameter("pass"))) {

			session.setAttribute("usuarioVO", "1");
			session.setAttribute("login_name", userName);

			response.sendRedirect("index.xhtml");

		} else {

			requestDispatcher = request.getRequestDispatcher("/login.jsp");

			requestDispatcher.forward(request, response);

		}

	}

}
