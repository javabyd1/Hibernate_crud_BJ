package com.mojafirma.implement;

import com.mojafirma.interfaces.UserDAO;
import com.mojafirma.model.User;
import com.mojafirma.utility.HibernateUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;

public class UserDAOImpl implements UserDAO {

	@Override
	public User insertUser(User u) {

		Session session = HibernateUtility.getHibernateSession();
		try{
			session.getSessionFactory().openSession();
			System.out.println(u.getName()+" "+u.getSurname());
			session.beginTransaction();
			session.save(u);
			session.getTransaction().commit();
		}
	    catch (HibernateException e) {
	    	if (session.getTransaction()!= null){
	    		session.getTransaction().rollback();
			}
	    	e.printStackTrace();
		  }
		  session.close();
		return u;
	}

	@Override
	public List<User> getAllUsers() {

		Session session = HibernateUtility.getHibernateSession();
		List<User> users = null;

		try{
			session.getSessionFactory().openSession();
	    	  session.beginTransaction();
	          users = session.createQuery("FROM User").list();
	          for (Iterator<User> iterator =
				   users.iterator(); iterator.hasNext();){
	        	  User user = (User) iterator.next();
	             System.out.print(" " + user.getName()+"\t");
	             System.out.print("  " + user.getSurname()+"\n");
	          }
	       }
	      catch (HibernateException e) {
	    	  if (session.getTransaction()!=null) session.getTransaction().rollback();
	    	  e.printStackTrace();
		  }
	   return users;
	}

	@Override
	public void updateUser(int id, String name,String surname){

		Session session = HibernateUtility.getHibernateSession();
		try{
			session.getSessionFactory().openSession();
	         session.beginTransaction();
	         User user = session.get(User.class, id);
	         System.out.println(" "+user.getName());
	         user.setName(name);
	         user.setSurname(surname);
			 session.update(user);
			 session.getTransaction().commit();
	    }
		catch (HibernateException e) {
	         if (session.getTransaction()!=null) session.getTransaction().rollback();
	         e.printStackTrace();
	    }
	    session.close();
	}
	@Override
	public void removeUser(int id) {

		Session session = HibernateUtility.getHibernateSession();
		try{
			session.getSessionFactory().openSession();
			session.beginTransaction();

	         User user = session.get(User.class, id);
	         System.out.println("  "+user.getName()+"  "+user.getSurname());
	         session.delete(user);

	         session.getTransaction().commit();
	    }
		catch (HibernateException e) {
	         if (session.getTransaction()!= null) session.getTransaction().rollback();
	         e.printStackTrace();
	      }
	      session.close();
	}

	@Override
	public User findUser(int id) {
		Session session = HibernateUtility.getHibernateSession();

		User user = session.get(User.class, id);
		System.out.println(" "+user.getName()+"  "+user.getSurname());
		return user;
	}

}
