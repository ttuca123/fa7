package br.com.cursojsf.listeners;

import java.util.logging.Logger;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class MyPhaseListener implements PhaseListener {
	
    private static final long serialVersionUID = 7700487457990644826L;
    
    private static final Logger logger = Logger.getLogger(MyPhaseListener.class.getName());

    /** Metodo executado antes da fase. */
    public void beforePhase(PhaseEvent event) {
    	logger.info("Antes da fase:  " + event.getPhaseId());
    }

    /** Metodo executado depois da fase. */
    public void afterPhase(PhaseEvent event) {
    	logger.info("Depois da fase: " + event.getPhaseId());
    }

    /** Metodo que indica qual fase sera "escutada". */
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
}