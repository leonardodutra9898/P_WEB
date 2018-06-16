package br.ufc.crateus.os.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.ufc.crateus.os.beans.ClienteBean;
import br.ufc.crateus.os.beans.OSBean;
import br.ufc.crateus.os.model.Cliente;

@FacesConverter(forClass=Cliente.class)
public class ClienteConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String s) {
		
		if(s != null && s.trim().length() > 0) {
			Integer cod = Integer.valueOf(s);
			try {
				OSBean oB = new OSBean();
				return oB.getClienteViewOS();
				
			}catch(Exception e) {
				throw new ConverterException("Impossível encontrar a categoria de código " + s + e.getMessage());
			}
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		
		if(arg2 != null) {
			Cliente cli = (Cliente) arg2;
			return cli.getId().toString();
		}
		
		return null;
	}

}
