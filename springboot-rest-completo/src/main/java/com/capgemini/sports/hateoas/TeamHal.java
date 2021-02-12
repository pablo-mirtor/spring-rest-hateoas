package com.capgemini.sports.hateoas;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import com.capgemini.sports.model.dto.TeamDto;
import com.capgemini.sports.services.PlayerRest;
import com.capgemini.sports.services.TeamRest;

public class TeamHal {
	public static void linkSelf(TeamDto dto) {
		Link link = WebMvcLinkBuilder.linkTo(TeamRest.class).slash(dto.getIdTeam()).withSelfRel();
		dto.add(link);
	}
	
	public static void linkTeams(TeamDto dto) {
		Link link = WebMvcLinkBuilder.linkTo(TeamRest.class).withRel("teams");
		dto.add(link);
	}
	
	public static void linkPlayers(TeamDto dto) {
		Link link = WebMvcLinkBuilder.linkTo(PlayerRest.class).withRel("players");
		dto.add(link);
	}
	
	public static void linkPlayersTeam(TeamDto dto, int idTeam) {
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PlayerRest.class).findById(idTeam)).withRel("players");
		dto.add(link);
	}
}
