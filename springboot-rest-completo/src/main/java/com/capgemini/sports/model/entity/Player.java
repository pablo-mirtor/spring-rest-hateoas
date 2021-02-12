package com.capgemini.sports.model.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="player")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_player")
	private Integer idPlayer;
	
	@Basic(optional = false)
	private String firstName;
	
	@Basic(optional = false)
	private String lastName;
	
	@Basic(optional = false)
	private double salary;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "id_team")
	private Team team;

	
	
	public Player() {
		super();
	}

	public Player(Integer idPlayer, String firstName, String lastName, double salary, Team team) {
		super();
		this.idPlayer = idPlayer;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Player [idPlayer=" + idPlayer + ", firstName=" + firstName + ", lastName=" + lastName + ", salary="
				+ salary + ", team=" + team + "]";
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
		Player other = (Player) obj;
		if (idPlayer == null) {
			if (other.idPlayer != null)
				return false;
		} else if (!idPlayer.equals(other.idPlayer))
			return false;
		return true;
	}
	
	

}
