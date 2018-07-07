package br.ufc.crateus.os.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.ufc.crateus.os.beans.UsuarioBean;

@WebFilter("/sisos/*")
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filter)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) req).getSession();
		UsuarioBean loginBean = (UsuarioBean) session.getAttribute("usuarioBean");
		
		if (loginBean != null && loginBean.getUsuario() != null) {
//			System.out.println("Autorizado para: " + loginBean.getUsuario());			
			filter.doFilter(req, res);			
		} else {
			System.out.println("Não autorizado");
			req.getRequestDispatcher("/sisos/").forward(req, res);
		}
	}
	
	@Override
	public void destroy() {

	}
}
