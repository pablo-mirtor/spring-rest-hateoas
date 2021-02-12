package com.capgemini.sports.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.sports.hateoas.PlayerHal;
import com.capgemini.sports.model.dto.PlayerDto;
import com.capgemini.sports.model.entity.Player;
import com.capgemini.sports.model.repositories.PlayerRepository;
import com.capgemini.sports.util.EntityConverters;

@RestController
@RequestMapping("/player")
public class PlayerRest {
	@Autowired
	private PlayerRepository repository;
	
	@GetMapping("")
	public List<PlayerDto> findAll(){
		List<PlayerDto> playersData = new ArrayList<PlayerDto>();
		repository.findAll().forEach((entity) ->{
			PlayerDto dto = EntityConverters.transformPlayerToDto(entity);
			PlayerHal.linkSelf(dto);
			playersData.add(dto);
		});
		
		return playersData;
	}
	
	@GetMapping("/{id}")
	public PlayerDto findById(@PathVariable int id){
		Player player = repository.findByIdPlayer(id);
		PlayerDto pdto = EntityConverters.transformPlayerToDto(player);
		PlayerHal.linkSelf(pdto);
		return pdto;
	}
}
