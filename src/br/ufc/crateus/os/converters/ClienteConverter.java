package br.ufc.crateus.os.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ufc.crateus.os.beans.ClienteBean;
import br.ufc.crateus.os.model.Cliente;
import br.ufc.crateus.os.utils.cdi.CDIServiceLocator;

@FacesConverter(value="clienteConverter", forClass = Cliente.class, managed = true)
public class ClienteConverter implements Converter {

//	@Inject
	private ClienteBean cliBean;
	
//	@Inject
//	private Cliente cli;
	
//	@Inject
//	private Cliente cli;
	
	public ClienteConverter() {
//		System.out.println("Teste 3");
		cliBean = CDIServiceLocator.getBean(ClienteBean.class);
//		System.out.println("Teste 4");
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("Teste 1");
//		cli = new ClienteService();
		
		cliBean = new ClienteBean();
		
		Cliente cliReturno = null;
		
			if(value != null) {
				Integer id = new Integer(value);
				cliReturno = cliBean.searchById(id);
			}
//		System.out.println("retorno cliente converter => " + cliReturno.toString());
//		System.out.println("retorno cliente converter => " + cliBean.getCliente());
		
		return cliReturno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		System.out.println("Teste 2");
		System.out.println("Objeto passado é instância de Cliente? => " + value.getClass());
//		System.out.println((Cliente)value);
		
		if(value != null) {
			return ((Cliente) value).getId().toString();
//			return String.valueOf(((Cliente) value).getId());
		}
			return null;
	}

}
