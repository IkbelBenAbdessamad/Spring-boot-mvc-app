package com.Jpa.mvc.h2.Testing.dao;

import org.springframework.data.repository.CrudRepository;

import com.Jpa.mvc.h2.Testing.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer> {

}
