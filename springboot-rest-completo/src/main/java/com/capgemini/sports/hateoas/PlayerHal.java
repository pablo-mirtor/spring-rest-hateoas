package com.capgemini.sports.hateoas;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import com.capgemini.sports.model.dto.PlayerDto;
import com.capgemini.sports.services.PlayerRest;


public class PlayerHal {
	public static void linkSelf(PlayerDto dto) {
		Link link = WebMvcLinkBuilder.linkTo(PlayerRest.class).slash(dto.getIdPlayer()).withSelfRel();
		dto.add(link);
	}
}
