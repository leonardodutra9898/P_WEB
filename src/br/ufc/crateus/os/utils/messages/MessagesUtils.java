package br.ufc.crateus.os.utils.messages;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.ufc.crateus.os.enums.MessagesTypes;

public class MessagesUtils {

    public void newMessage(String message, String details, MessagesTypes msgType) {
        FacesContext context = FacesContext.getCurrentInstance();
        
        switch(msgType) {
        	case INFO:
        		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,  message, details) );
        		break;
        	case ERROR:
        		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,  message, details) );
        		break;
        	case SUCCESS:
        		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,  message, details) );
        		break;
        	case WARNING:
        		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,  message, details) );
        		break;
        }   
    }
	
    public MessagesUtils(String message, String details, MessagesTypes msgType) {
    	newMessage(message, details, msgType);
    }
    
}
