package com.games.PlayerServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.games.entity.LeaderboardEntry;
import com.games.entity.PlayerEntity;
import com.games.entity.PlayerProgressionEntity;
import com.games.repository.LeaderboardRepository;
import com.games.repository.PlayerProgressionRepository;
import com.games.repository.PlayerRepository;
import com.games.service.PlayerService;

import jakarta.persistence.Cacheable;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	PlayerProgressionRepository playerProgressionRepository;
	
	@Autowired
    private LeaderboardRepository repository;

	
	@Override
	public void registerUser(PlayerEntity player) {

		if (playerRepository.findByUsername(player.getUsername())>0) {
			throw new RuntimeException("Username already exists!");
		}

		
		player.setPassword(passwordEncoder.encode(player.getPassword()) );
		playerRepository.save(player);
	}

	@Override
	public void saveProgress(PlayerProgressionEntity entity) {		
		
		 playerProgressionRepository.save(entity);
	}

	@Override
	public void submitScores(LeaderboardEntry entry) {
		 repository.save(entry);
		
	}
	
    public List<LeaderboardEntry> getTopPlayersGlobal(int limit) {
    	List<LeaderboardEntry> players = repository.findTopPlayersGlobal( limit);
        return players.subList(0, Math.min(limit, players.size()));
    }
   
    
    public List<LeaderboardEntry> getTopPlayersByGame(Long gameId, int limit) {
        return repository.findTopPlayersByGame(gameId, limit);
    }

    public List<LeaderboardEntry> getTopPlayersByCountry(Long gameId, String country, int limit) {
        return repository.findTopPlayersByCountry(gameId, country, limit);
    }

}
