package br.ufc.crateus.os.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.ufc.crateus.os.beans.ClienteBean;
import br.ufc.crateus.os.model.Cliente;

@FacesConverter(value="clienteConverter", forClass = Cliente.class, managed = true)
public class ClienteConverter implements Converter {

//	@Inject

//	@Inject
	
	
//	@Inject
//	private Cliente cli;
	
//	@Inject
//	private Cliente cli;
	
	public ClienteConverter() {
//		System.out.println("Teste 3");
//		cliBean = CDIServiceLocator.getBean(ClienteBean.class);
//		System.out.println("Teste 4");
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("Teste 1");
//		cli = new ClienteService();
		
		ClienteBean cliBean = new ClienteBean();
		
		
			if(value != null && value.trim().length()>0) {
//				Integer id = Integer.valueOf(value);
				
				
				System.out.println("retorno cliente converter => " + cliBean.searchById(Integer.parseInt(value)));
					
				Cliente cliReturno = cliBean.searchById(Integer.parseInt(value));
				
				return cliReturno;
			}else {
				return null;
			}
//		System.out.println("retorno cliente converter => " + cliReturno.toString());
//		System.out.println("retorno cliente converter => " + cliBean.getCliente());
		
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		System.out.println("Teste 2");
		System.out.println("Objeto passado é instância de Cliente? => " + value.getClass());
//		System.out.println((Cliente)value);
		
		
//			Cliente cliente = (Cliente) value;
//			return cliente.getId().toString();
			
//			return ((Cliente) value).getId().toString();
		
			
			return String.valueOf(((Cliente) value).getId());
		
	}

}
