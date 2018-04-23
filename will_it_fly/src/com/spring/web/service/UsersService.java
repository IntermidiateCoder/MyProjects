package com.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.web.dao.Idea;
import com.spring.web.dao.IdeasDao;
import com.spring.web.dao.IdeasDaoImpl;
import com.spring.web.dao.User;
import com.spring.web.dao.UsersDao;

@Service("usersService")
public class UsersService {
	
	@Autowired
	private UsersDao usersDao = new UsersDao();
	
	@Autowired
	@Qualifier("ideasDaoImpl")
	private IdeasDao IdeasDao = new IdeasDaoImpl();
	
	@Transactional
	public void create(User user) {
		usersDao.create(user);
	}


	public boolean exists(String username) {
		return usersDao.exists(username);
	}

	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {
		return usersDao.getAllUsers();
	}
	
	public void sendIdea(Idea Idea) {
		IdeasDao.saveOrUpdate(Idea);
	}
	
	public User getUser(String username) {
		return usersDao.getUser(username);
	}


	public List<Idea> getIdeas(String username) {
		return IdeasDao.getIdeas(username);
	}

}
