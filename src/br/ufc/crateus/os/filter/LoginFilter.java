package br.ufc.crateus.os.filter;

import java.io.IOException;
import java.util.Enumeration;

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

@WebFilter("/*")
public class LoginFilter implements Filter {

	int tent = 0;
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filter)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) req).getSession();
		
		System.out.println("Testando sessão ==========");
		System.out.println("ID sessão = " + session.getId());
		
		UsuarioBean loginBean = (UsuarioBean) session.getAttribute("uBean");
		
		System.out.println("Testando credenciais ======= ");
//		System.out.println("LoginBean = " + loginBean.getLogin());
		
		if (loginBean != null && loginBean.getUsuario() != null) {
			System.out.println("Autorizado para: " + loginBean.getUsuario().getLogin());			
			filter.doFilter(req, res);
//			req.getRequestDispatcher("/index.html").forward(req, res);
		} else {
			System.out.println(++tent + " => Não autorizado");
			req.getRequestDispatcher("/login.xhtml").forward(req, res);
		}
	}
	
	@Override
	public void destroy() {

	}
}
