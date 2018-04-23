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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("ideasDaoImpl")
@Transactional
@Component("ideasDaoImpl")
public class IdeasDaoImpl implements IdeasDao {

	private SessionFactory sessionFactory = new Configuration().configure("/resources/Hibernate.cfg.xml").buildSessionFactory();
	private Transaction tx;
	
	
	public Session session() {
		return sessionFactory.openSession();
	}

	public List<Idea> getIdeas() {
		tx = null;
		try (Session session = session()) {
			tx = session.beginTransaction();
			CriteriaBuilder builder = session().getCriteriaBuilder();
			CriteriaQuery<Idea> crit = builder.createQuery(Idea.class);
			Root<Idea> root = crit.from(Idea.class);
			crit.select(root);
			Query<Idea> q = session().createQuery(crit);
		
			tx.commit();
		    
		    return q.getResultList();
	    } catch (Exception e) {
	         e.printStackTrace();
	         if (tx != null) {
	            tx.rollback();
	         }
	         return null;
	      } 
	}

	public List<Idea> getIdeas(String username) {
		tx = null;
		try (Session session = session()) {
			tx = session.beginTransaction();
		CriteriaBuilder builder = session().getCriteriaBuilder();
		CriteriaQuery<Idea> crit = builder.createQuery(Idea.class);
		Root<Idea> root = crit.from(Idea.class);
		crit.select(root).where(builder.equal(root.get("username"), username));
		Query<Idea> q = session().createQuery(crit);
		
		tx.commit();
		
		return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx != null)
				tx.rollback();
		}
		return null;
	}

	public void saveOrUpdate(Idea Idea) {
		tx = null;
		try (Session session = session()) {
			tx = session.beginTransaction();
			System.out.println(Idea);
			session.saveOrUpdate(Idea);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx != null)
				tx.rollback();
		}
	}
	
	@Transactional
	public void delete(int id) {
		tx = null;
		try (Session session = session()) {
			Idea idea = getIdea(id);
			System.err.println(idea);
			
			session.delete(idea);
			tx = session.beginTransaction();
			session.flush();
			System.err.println("Idea:" + getIdea(id));
			//tx.commit();
	
		} catch (Exception e) {
			e.printStackTrace();
			if(tx != null)
				tx.rollback();
		}
	}

	public Idea getIdea(int id) {
		tx = null;
		try (Session session = session()) {
			tx = session.beginTransaction();
			CriteriaBuilder builder = session().getCriteriaBuilder();
			CriteriaQuery<Idea> crit = builder.createQuery(Idea.class);
			Root<Idea> root = crit.from(Idea.class);
			crit.select(root).where(builder.equal(root.get("id"), id));
			Query<Idea> q = session().createQuery(crit);
			
			tx.commit();

			return (Idea)q.getSingleResult();
		 } catch (Exception e) {
	         e.printStackTrace();
	         if (tx != null) {
	            tx.rollback();
	         }
	         return null;
	      }
	}

}
