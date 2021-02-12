package com.capgemini.sports.util;

import com.capgemini.sports.model.dto.PlayerDto;
import com.capgemini.sports.model.dto.TeamDto;
import com.capgemini.sports.model.entity.Player;
import com.capgemini.sports.model.entity.Team;

public class EntityConverters {
	public static TeamDto transformTeamToDto(Team team) {
		TeamDto t = new TeamDto(team.getIdTeam(), team.getName(), team.getStadium());
		return t;
	}
	
	public static Team transformDtoToTeam(TeamDto dto) {
		Team t = new Team();
		t.setIdTeam(dto.getIdTeam());
		t.setName(dto.getName());
		t.setStadium(dto.getStadium());
		return t;
	}
	
	public static PlayerDto transformPlayerToDto(Player player) {
		
		TeamDto t = transformTeamToDto(player.getTeam());
		PlayerDto p = new PlayerDto(player.getIdPlayer(), player.getFirstName(), player.getLastName(), t);
		return p;
	}
	
	public static Player transformDtoToPlayer(PlayerDto dto) {
		Team t = transformDtoToTeam(dto.getTeam());
		Player p = new Player();
		p.setIdPlayer(dto.getIdPlayer());
		p.setFirstName(dto.getFirstName());
		p.setLastName(dto.getLastName());
		p.setTeam(t);
		
		return p;
		
	}
}
