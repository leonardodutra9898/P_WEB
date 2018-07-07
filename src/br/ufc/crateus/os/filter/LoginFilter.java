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

import br.ufc.crateus.os.beans.LoginBean;
import br.ufc.crateus.os.enums.MessagesTypes;
import br.ufc.crateus.os.utils.messages.MessagesUtils;

@WebFilter("/*")
public class LoginFilter implements Filter {

	MessagesUtils msgUtils;
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filter)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) req).getSession();
		
		System.out.println("Testando sessão ==========");
		System.out.println("ID sessão = " + session.getId());
		
		LoginBean loginBean = (LoginBean) session.getAttribute("uBean");

		if (loginBean != null && loginBean.getUsuario() != null) {
			System.out.println("Autorizado para: " + loginBean.getUsuario().getNome());			
			filter.doFilter(req, res);

		} else {
			req.getRequestDispatcher("/login.xhtml").forward(req, res);
		}
	}
	
	@Override
	public void destroy() {

	}
}
