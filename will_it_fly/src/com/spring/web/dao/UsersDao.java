package com.spring.web.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("usersDao")
@Transactional
@Component("usersDao")
public class UsersDao {

	@Autowired
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	private SessionFactory sessionFactory = new Configuration().configure("/resources/Hibernate.cfg.xml").buildSessionFactory();
	private Transaction tx;
	
	public Session session() {
		return sessionFactory.openSession();
	}

	@Transactional
	public void create(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		tx = null;
		try (Session session = session()) {
			tx = session.beginTransaction();
			System.out.println(user);
			session.save(user);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx != null)
				tx.rollback();
		}
	}
	
	public boolean exists(String username) {
		User user = getUser(username);
		return user != null;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return session().createQuery("from User").list();
	}

	public User getUser(String username) {
		tx = null;
		try (Session session = session()) {
			tx = session.beginTransaction();
			CriteriaBuilder builder = session().getCriteriaBuilder();
		    CriteriaQuery<User> crit = builder.createQuery(User.class);
		    Root<User> root = crit.from(User.class);
		    crit.select(root).where(builder.equal(root.get("username"), username));
		    Query<User> q = session().createQuery(crit);
		         
		    tx.commit();
		    
		    return q.getSingleResult();
	    } catch (Exception e) {
	         e.printStackTrace();
	         if (tx != null) {
	            tx.rollback();
	         }
	         return null;
	      }     
		
		
	}

}
