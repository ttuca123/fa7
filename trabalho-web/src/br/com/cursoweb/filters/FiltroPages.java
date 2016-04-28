package br.com.cursoweb.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.web.vo.Usuario;

/**
 * 
 * @author Artur
 *
 */

@WebFilter("/FiltroPages")
public class FiltroPages implements Filter {

	/**
	 * Default constructor.
	 */
	public FiltroPages() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		String page1 = "page1";
		String page2 = "page2";

		HttpSession session = ((HttpServletRequest) request).getSession();

		HttpServletRequest requestHtml = (HttpServletRequest) request;

		RequestDispatcher requestDispatcher;

		if (session.getAttribute("usuarioVO") != null
				&& Integer.parseInt(session.getAttribute("usuarioVO")
						.toString()) == 1) {

			if (requestHtml.getServletPath().equals("/pagina1.xhtml")) {

				requestDispatcher = request
						.getRequestDispatcher("/pagina1.xhtml");

				requestDispatcher.forward(request, response);

				Integer param = Integer.parseInt(request.getServletContext()
						.getAttribute(page1).toString()) + 1;

				request.getServletContext().setAttribute(page1, param);

			} else if (requestHtml.getServletPath().equals("/pagina2.xhtml")) {

				requestDispatcher = request
						.getRequestDispatcher("/pagina2.xhtml");

				requestDispatcher.forward(request, response);

				Integer param = Integer.parseInt(request.getServletContext()
						.getAttribute(page2).toString()) + 1;

				request.getServletContext().setAttribute(page2, param);
			} else {
				chain.doFilter(request, response);
			}

		} else {

			requestDispatcher = requestHtml.getRequestDispatcher("/Login");

			requestDispatcher.forward(request, response);

		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
