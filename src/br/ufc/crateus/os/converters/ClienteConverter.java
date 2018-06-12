package br.ufc.crateus.os.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ufc.crateus.os.model.Cliente;

@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if(value != null && value.trim().length() > 0) {
			System.out.println("getAsObject: " + value);
			//Cliente v = Cliente.this.getId(Integer.parseInt(value));
			return (Object) value;
		}else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			return ((Cliente) value).getId().toString();
		}else {
			return null;
		}
	}

}
