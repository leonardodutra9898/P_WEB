package br.ufc.crateus.os.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.ufc.crateus.os.enums.MessagesTypes;
import br.ufc.crateus.os.utils.messages.MessagesUtils;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator{

	MessagesUtils msg;
	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object obj) throws ValidatorException {
		
		String email = (String) obj;
		
		if(!(email.contains("@") && email.contains("."))){
		
//			msg = new MessagesUtils("E-mail invalido Formato de email inválido", "Redigite o e-mail", 
//					MessagesTypes.ERROR);	
			
			FacesMessage msg =
					new FacesMessage("E-mail invalido.",
					"Formato de email inválido.");
			
			throw new ValidatorException(msg);
		}
		
		
	}

}
