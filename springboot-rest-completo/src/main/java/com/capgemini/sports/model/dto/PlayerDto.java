package com.capgemini.sports.model.dto;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class PlayerDto extends RepresentationModel<PlayerDto> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idPlayer;
	private String firstName;
	private String lastName;
	private TeamDto team;
	
	public PlayerDto() {
		super();
	}
	
	public PlayerDto(Integer idPlayer, String firstName, String lastName, TeamDto team) {
		super();
		this.idPlayer = idPlayer;
		this.firstName = firstName;
		this.lastName = lastName;
		this.team = team;
	}

	public Integer getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(Integer idPlayer) {
		this.idPlayer = idPlayer;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public TeamDto getTeam() {
		return team;
	}

	public void setTeam(TeamDto team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "PlayerDto [idPlayer=" + idPlayer + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPlayer == null) ? 0 : idPlayer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerDto other = (PlayerDto) obj;
		if (idPlayer == null) {
			if (other.idPlayer != null)
				return false;
		} else if (!idPlayer.equals(other.idPlayer))
			return false;
		return true;
	}
	
	
	
}
