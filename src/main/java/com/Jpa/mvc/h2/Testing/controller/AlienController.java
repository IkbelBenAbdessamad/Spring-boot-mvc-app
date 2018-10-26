package com.Jpa.mvc.h2.Testing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jpa.mvc.h2.Testing.dao.AlienRepo;
import com.Jpa.mvc.h2.Testing.model.Alien;

@RestController
public class AlienController {

	@Autowired
	AlienRepo repo;

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}

	@DeleteMapping("alien/{aid}")
	public String deletAlien(@PathVariable int aid) {
		Alien a = repo.findOne(aid);
		repo.delete(a);
		return "Deleted";

	}

	@RequestMapping(path = "Aliens") // ,produces= {"application/xml"})
	public List<Alien> getAliens() {
		return (List<Alien>) repo.findAll();
	}

	// Consume the data in the server side
	@PostMapping(path = "alien", consumes = { "application/json" }) // ,produces="application/xml")
	public Alien alien(@RequestBody Alien alien) {
		return repo.save(alien);
	}

	@RequestMapping(path = "Alien/{aid}") // ,produces="application/xml")
	public Alien getAlien(@PathVariable("aid") int aid) {
		return repo.findOne(aid);
	}
	@PutMapping(path="/alien",consumes= {"application/json"})
	public Alien SaveOrUpdateAlien(@RequestBody Alien alien) {
	repo.save(alien);
		return alien;

	}

	
	//
	// @RequestMapping("/getAlien")
	// public ModelAndView getAlien(@RequestParam int aid) {
	// // the view of our object is showAlien.jsp
	// ModelAndView mv = new ModelAndView("showAlien.jsp");
	// Alien alien = repo.findOne(aid);
	//// System.out.println(repo.findByTech("python"));
	//// System.out.println(repo.findByAidGreaterThan(70));
	//// System.out.println(repo.findByTechSorted("java"));
	// mv.addObject(alien); // to adding an object as an alien
	// return mv;
	// }

	// Let's working on web services in this case we don't need jsp we only need
	// data !
	// in spring mvc when we return string the method expect that we return a view
	// name
}
