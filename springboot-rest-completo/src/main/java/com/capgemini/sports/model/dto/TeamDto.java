package com.capgemini.sports.model.dto;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class TeamDto extends RepresentationModel<TeamDto> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idTeam;
	private String name;
	private String stadium;
	
	public TeamDto() {
		super();
	}
	
	public TeamDto(Integer idTeam, String name, String stadium) {
		super();
		this.idTeam = idTeam;
		this.name = name;
		this.stadium = stadium;
	}
	
	public Integer getIdTeam() {
		return idTeam;
	}
	public void setIdTeam(Integer idTeam) {
		this.idTeam = idTeam;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStadium() {
		return stadium;
	}
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	@Override
	public String toString() {
		return "TeamDto [idTeam=" + idTeam + ", name=" + name + ", stadium=" + stadium + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTeam == null) ? 0 : idTeam.hashCode());
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
		TeamDto other = (TeamDto) obj;
		if (idTeam == null) {
			if (other.idTeam != null)
				return false;
		} else if (!idTeam.equals(other.idTeam))
			return false;
		return true;
	}
	
	
	
}
