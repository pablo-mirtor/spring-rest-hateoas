package com.capgemini.sports.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.sports.model.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Integer>{
	Team findByName(String name);
	Team findByStadium(String stadium);
	Team findByIdTeam(Integer id);
	
}
