package br.com.cursoweb.logs;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 
 * @author Artur
 *
 */
@WebListener
public class LogServer implements HttpSessionListener {

	/**
	 * Default constructor.
	 */
	public LogServer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	@Override
	public void sessionCreated(HttpSessionEvent serssionEvent) {

		HttpSession session = serssionEvent.getSession();
		System.out.println("Sessão criada. Id = " + session.getId());

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {

		HttpSession session = sessionEvent.getSession();
		System.out.println("Sessão destruida. Id = " + session.getId());

	}

}
