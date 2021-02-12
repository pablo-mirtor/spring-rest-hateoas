package com.capgemini.sports.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.sports.model.entity.Player;

public interface PlayerRepository extends JpaRepository<Player,Integer>{
	Player findByIdPlayer(Integer id);
}
