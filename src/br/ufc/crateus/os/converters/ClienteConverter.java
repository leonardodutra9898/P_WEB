package br.ufc.crateus.os.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import br.ufc.crateus.os.beans.OSBean;
import br.ufc.crateus.os.model.Cliente;
import br.ufc.crateus.os.repository.ClienteRepository;
import br.ufc.crateus.os.utils.dao.EntityManagerPersistence;

@FacesConverter(forClass=Cliente.class)
public class ClienteConverter implements Converter{

//	Clientes clientes = new ClienteRepository();
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String s) {
		
		if(s != null && s.trim().length() > 0) {
			System.out.println("getAsObject: " + s);
//			Integer cod = Integer.valueOf(s);
			
//			try {
//				OSBean oB = new OSBean();
//				return oB.searchById(cod);
				
//				Cliente c = ClienteRepository.getClienteById(Integer.parseInt(s));
				
				//////// testes
//				EntityManager manager = EntityManagerPersistence.getEntityManager();
//				Cliente ca = null;
//				try {
//					manager.getTransaction().begin();
//			
//					ClienteRepository cRepo = new ClienteRepository(manager);
//					ca =  cRepo.clienteById(Integer.parseInt(s));
//				}catch(Exception e) {
//					System.out.println("Erro de conversão... ====> " + e.toString());
//				}finally{
//					manager.close();
////					return null;
//				}
////				.getClienteById(Integer.parseInt(s));
//				return ca;
				//////
//				return c.getId();
				
//			}catch(Exception e) {
//				throw new ConverterException("Impossível encontrar a categoria de código " + s + e.getMessage());
//			}
			return Integer.parseInt(s);
		}else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		
		if(arg2 != null) {
//			System.out.println("Teste 1 ==> " + ((Cliente)arg2));
			System.out.println("getAsString: " + arg2);
			return String.valueOf(((Cliente)arg2).getId());
//			return arg2.toString();
		}else {
			return null;
		}
	}

}
