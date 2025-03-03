package com.games.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PlayerProgressionDto {
	
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
	public Integer getRewardsCollected() {
		return rewardsCollected;
	}
	public void setRewardsCollected(Integer rewardsCollected) {
		this.rewardsCollected = rewardsCollected;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public LocalDateTime getLastActiveTime() {
		return lastActiveTime;
	}
	public void setLastActiveTime(LocalDateTime lastActiveTime) {
		this.lastActiveTime = lastActiveTime;
	}
	String username;
	Integer level;
	Integer rank;
	String currency;
	Integer rewardsCollected;
	String country;
	LocalDateTime lastActiveTime;
	Integer scores;
	Integer gameId;
	public Integer getScores() {
		return scores;
	}
	public void setScores(Integer scores) {
		this.scores = scores;
	}
	public Integer getGameId() {
		return gameId;
	}
	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}
	
}
