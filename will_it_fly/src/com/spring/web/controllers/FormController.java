package com.spring.web.controllers;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.web.dao.FormValidationGroup;
import com.spring.web.dao.Idea;
import com.spring.web.dao.User;
import com.spring.web.service.IdeasService;

@Controller
public class FormController {
	
	private static Logger logger = Logger.getLogger(FormController.class);
	private IdeasService ideasService = new IdeasService();
	
//	@Autowired
//	@Qualifier("ideasDao")
//	public void setIdeasService(IdeasService ideasService) {
//		this.ideasService = ideasService;
//	}

	@RequestMapping("/")
	public String showForm(Model model, Principal principal) {
		
//		Idea idea = null;
//		String username = "guest";		
//
//		if (principal != null) {
//			username = principal.getName();
//		}
//		
//		idea = ideasService.getIdea(username);
//
//		if (idea == null) {
//			idea = new Idea();
//		}

		model.addAttribute("idea", new Idea());
		
		return "home";
	}
	
	@RequestMapping(value="/saveidea", method=RequestMethod.POST)
	public String saveIdea(@Validated(FormValidationGroup.class) Idea idea, BindingResult result, Principal principal) {
		
		if(result.hasErrors()) {
			return "home";
		}
		
		if(principal != null) {
			idea.setUsername(principal.getName());	
		} else 
			idea.setUsername("guest");
		
		System.out.println(idea);
		
		ideasService.saveOrUpdate(idea);
		
		return "myideas";
	}
	
	@RequestMapping(value="/editidea", method=RequestMethod.POST)
	public String editIdea(@Validated(FormValidationGroup.class) Idea idea, BindingResult result, Principal principal, Model model) {
		
		if(result.hasErrors()) {
			return "cantgothere";
		}
		
		String username = "guest";
		
		if(principal != null) 
			username = principal.getName();
			
		int id = idea.getId();
		idea = ideasService.getIdea(id);
		System.err.println(idea);
		
		if(idea == null || !idea.getUsername().equals(username))
			return "cantgothere";
		
		model.addAttribute("idea", idea);
		System.err.println("idea added to attributes");
		ideasService.delete(id);
		
		return "home";
	}
	
	@RequestMapping(value="/viewidea", method=RequestMethod.POST)
	public String viewIdea(@Validated(FormValidationGroup.class) Idea idea, BindingResult result, Principal principal, Model model) {
		
		if(result.hasErrors()) {
			return "cantgothere";
		}
		
		String username = "guest";
		
		if(principal != null) 
			username = principal.getName();
			
		int id = idea.getId();
		idea = ideasService.getIdea(id);
		System.err.println(idea);
		
		if(idea == null || !idea.getUsername().equals(username))
			return "cantgothere";
		
		model.addAttribute("idea", idea);
		System.err.println("idea added to attributes");
		
		return "idea";
	}
	
	@RequestMapping(value="/deleteidea", method=RequestMethod.POST)
	public String deleteIdea(@Validated(FormValidationGroup.class) Idea idea, BindingResult result, Principal principal, Model model) {
		
		if(result.hasErrors()) {
			return "allideas";
		}
		
		String username = "guest";
		
		if(principal != null) 
			username = principal.getName();
			
		int id = idea.getId();
		idea = ideasService.getIdea(id);
		System.err.println(idea);
		
		if(idea == null || !idea.getUsername().equals(username))
			return "cantgothere";
		
		ideasService.delete(id);
		
		return "home";
	}
	
	@RequestMapping("/userpage")
	public String showUserPage() {
		
		return "userpage";
	}
	
	@RequestMapping("/allideas")
	public String showAllIdeas(Model model) {
		
		List<Idea> ideas = ideasService.getIdeas();
		
		model.addAttribute("ideas", ideas);
		model.addAttribute("idea", new Idea());
		
		return "allideas";
	}
	
	@RequestMapping("/myideas")
	public String showMyIdeas(Model model, Principal principal) {
		
		String username = "guest";
		if(principal != null)
			username = principal.getName();
		
		List<Idea> ideas = ideasService.getIdeas(username);
		
		model.addAttribute("ideas", ideas);
		model.addAttribute("idea", new Idea());
		
		return "myideas";
	}
}
