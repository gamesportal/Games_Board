package com.games.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.games.dto.PlayerDto;
import com.games.dto.PlayerProgressionDto;
import com.games.dto.ScoresDto;
import com.games.entity.LeaderboardEntry;
import com.games.entity.PlayerEntity;
import com.games.entity.PlayerProgressionEntity;

public interface PlayerService {

	public void registerUser(PlayerEntity player);
	public void saveProgress(PlayerProgressionEntity dto);
	public void submitScores(LeaderboardEntry scores);
	
	@Cacheable(value = "leaderboard", key = "#limit")
	public List<LeaderboardEntry> getTopPlayersGlobal(int limit);
	
	@Cacheable(value = "leaderboard", key = "#gameId + '-' + #limit")
	public List<LeaderboardEntry> getTopPlayersByGame(Long gameId, int limit);
	
	@Cacheable(value = "leaderboard", key = "#gameId + '-' + #country + '-' + #limit")
	public List<LeaderboardEntry> getTopPlayersByCountry(Long gameId, String country, int limit);
	
}
