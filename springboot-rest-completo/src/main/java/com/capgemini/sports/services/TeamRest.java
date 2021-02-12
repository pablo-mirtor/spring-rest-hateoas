package com.capgemini.sports.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.sports.hateoas.TeamHal;
import com.capgemini.sports.model.dto.TeamDto;
import com.capgemini.sports.model.entity.Team;
import com.capgemini.sports.model.repositories.TeamRepository;
import com.capgemini.sports.util.EntityConverters;

@RestController
@RequestMapping("/team")

public class TeamRest {
	@Autowired
	private TeamRepository repository;
	
	@GetMapping(path = "")
	public List<TeamDto> findAll(@RequestParam(name="name", required = false) Optional<String> name,
			@RequestParam(name="estadio", required = false) Optional<String> stadium){
		List<TeamDto> teamData = new ArrayList<TeamDto>();
		if(name.isPresent()) {
			Team t = repository.findByName(name.get());
			TeamDto dto = EntityConverters.transformTeamToDto(t);
			TeamHal.linkSelf(dto);
			TeamHal.linkTeams(dto);
			TeamHal.linkPlayers(dto);
			TeamHal.linkPlayersTeam(dto, dto.getIdTeam());
			teamData.add(dto);
		}
		else if(stadium.isPresent()) {
			Team t = repository.findByStadium(stadium.get());
			TeamDto dto = EntityConverters.transformTeamToDto(t);
			TeamHal.linkSelf(dto);
			TeamHal.linkTeams(dto);
			TeamHal.linkPlayers(dto);
			TeamHal.linkPlayersTeam(dto, dto.getIdTeam());
			teamData.add(dto);
		}
		else {
			repository.findAll().forEach((entity) ->{
				TeamDto dto = EntityConverters.transformTeamToDto(entity);
				TeamHal.linkSelf(dto);
				TeamHal.linkPlayersTeam(dto, dto.getIdTeam());
				teamData.add(dto);
			});
		}
		return teamData;
	}
	
	@GetMapping(path = "/{id}")
	public TeamDto findById(@PathVariable int id) {

		Team t = repository.findByIdTeam(id);
		TeamDto dto = EntityConverters.transformTeamToDto(t);
		TeamHal.linkSelf(dto);
		TeamHal.linkTeams(dto);
		TeamHal.linkPlayers(dto);
		TeamHal.linkPlayersTeam(dto, dto.getIdTeam());
		return dto;
	}
}
