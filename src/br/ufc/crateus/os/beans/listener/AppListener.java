package br.ufc.crateus.os.beans.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.ufc.crateus.os.beans.repository.EntityManagerPersistence;

@WebListener
public class AppListener implements ServletContextListener{

	public AppListener() {
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		EntityManagerPersistence.close();		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		EntityManagerPersistence.init();
	}

}
