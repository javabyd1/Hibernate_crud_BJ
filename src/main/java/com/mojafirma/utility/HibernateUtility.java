package com.mojafirma.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

	private final static SessionFactory sf = new Configuration().configure().buildSessionFactory();

	/*
	Jezeli plik hibernate.cfg.xml jest w katalogu resources to SessionFactory powinno wygladac:
	private final static SessionFactory sf = new Configuration()
	        .configure()
			.buildSessionFactory();
	 */

    private static Session session = sf.openSession();

	private HibernateUtility() {
	}

	public static Session getHibernateSession() {
	      if(session == null) {
	    	  session = (Session) new HibernateUtility();
	       }
	       return session;
	}
}
