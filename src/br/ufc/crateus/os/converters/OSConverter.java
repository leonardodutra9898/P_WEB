package br.ufc.crateus.os.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ufc.crateus.os.beans.OSBean;
import br.ufc.crateus.os.model.Cliente;
import br.ufc.crateus.os.model.OS;

@FacesConverter(forClass = OS.class)
public class OSConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		
		OSBean osBean = new OSBean();

		if(value != null && value.trim().length()>0) {
			OS osReturno = osBean.searchById(Integer.parseInt(value));
			return osReturno;
		}else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		return String.valueOf(((OS) value).getId());
	}
	
}
