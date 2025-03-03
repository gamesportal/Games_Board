package com.games.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sql12765461.PlayerProgression")
@Getter
@Setter
@NoArgsConstructor
public class PlayerProgressionEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getRewardsCollected() {
		return rewardsCollected;
	}
	public void setRewardsCollected(Integer rewardsCollected) {
		this.rewardsCollected = rewardsCollected;
	}
	public LocalDateTime getLastActiveTime() {
		return lastActiveTime;
	}
	public void setLastActiveTime(LocalDateTime lastActiveTime) {
		this.lastActiveTime = lastActiveTime;
	}
	@Column(unique = true, nullable = false)
	private String username;
	
	private Integer level;
	private Integer rank;
	private String currency;
	private String country;
	private Integer rewardsCollected;
	private LocalDateTime lastActiveTime;
	private Integer playerId;
	
}
