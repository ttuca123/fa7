package br.com.cursoweb.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements  HttpSessionListener
{
	
	
    /**
     * Default constructor. 
     */
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent event)  { 
    	
    	HttpSession session = event.getSession();
    	
    	System.out.println("Sessão criada. Id="+session.getId());
    	
    	
    }

	
	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent event)  { 
        
    	HttpSession session = event.getSession();
    	
    	System.out.println("Sessão destruida. Id="+session.getId());
    	
    		
    	
    }

		
}
