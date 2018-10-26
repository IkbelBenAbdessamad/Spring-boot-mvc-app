package com.Jpa.mvc.h2.Testing.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Jpa.mvc.h2.Testing.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer> {

	List<Alien> findByTech(String tech);

	// return alien with alien id > aid
	List<Alien> findByAidGreaterThan(int aid);

	@Query("from Alien where tech=?1 order by aname")
	List<Alien> findByTechSorted(String tech);

}
