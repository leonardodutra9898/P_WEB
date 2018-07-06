package br.ufc.crateus.os.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ufc.crateus.os.model.OS;

@FacesConverter(forClass=OS.class)
public class OSConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String s) {
		
		if(s != null && s.trim().length() > 0) {
			return Integer.parseInt(s);
		}else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		
		if(arg2 != null) {
			return String.valueOf(((OS)arg2).getId());
		}else {
			return null;
		}
	}
}
