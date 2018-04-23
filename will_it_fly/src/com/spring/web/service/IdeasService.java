package com.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.spring.web.dao.Idea;
import com.spring.web.dao.IdeasDao;
import com.spring.web.dao.IdeasDaoImpl;

@Service("ideasService")
public class IdeasService {
	
	@Autowired
	@Qualifier("ideasDaoImpl")
	private IdeasDao ideasDao = new IdeasDaoImpl();
	
	
	public void setideasDao(IdeasDao ideasDao) {
		this.ideasDao = ideasDao;
	}

	public List<Idea> getIdeas() {
		return ideasDao.getIdeas();
	}

	// @Secured({ "ROLE_USER", "ROLE_ADMIN" })
	public void create(Idea idea) {
		ideasDao.saveOrUpdate(idea);
	}

	public boolean hasIdea(String name) {

		if (name == null) {
			return false;
		}

		List<Idea> ideas = ideasDao.getIdeas(name);

		if (ideas.size() == 0) {
			return false;
		}

		return true;
	}

	public Idea getIdea(String username) {

		if (username == null) {
			return null;
		}

		List<Idea> ideas = ideasDao.getIdeas(username);

		if (ideas.size() == 0) {
			return null;
		}

		return ideas.get(0);
	}

	public void saveOrUpdate(Idea idea) {
		ideasDao.saveOrUpdate(idea);
	}

	public void delete(int id) {
		ideasDao.delete(id);
	}

	public Idea getIdea(int id) {
		return ideasDao.getIdea(id);
	
	}

	public List<Idea> getIdeas(String username) {
		return ideasDao.getIdeas(username);
	}

}
