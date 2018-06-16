package br.ufc.crateus.os.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.ufc.crateus.os.beans.ClienteBean;
import br.ufc.crateus.os.model.Cliente;

@FacesConverter(forClass = Cliente.class, value="cliConverter")
public class ClienteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		ClienteBean cliBean = new ClienteBean();

			if(value != null && value.trim().length()>0) {
				Cliente cliReturno = cliBean.searchById();
				return cliReturno;
			}else {
				return null;
			}

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
			return String.valueOf(((Cliente) value).getId());
	}

}
