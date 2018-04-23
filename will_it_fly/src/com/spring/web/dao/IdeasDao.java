package com.spring.web.dao;

import java.util.List;

public interface IdeasDao {

	List<Idea> getIdeas();

	void saveOrUpdate(Idea idea);

	List<Idea> getIdeas(String name);

	void delete(int id);

	Idea getIdea(int id);

}
