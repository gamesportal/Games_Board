package com.games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.games.entity.LeaderboardEntry;

@Repository
public interface LeaderboardRepository extends JpaRepository<LeaderboardEntry, Long>{
	@Query("SELECT l FROM LeaderboardEntry l ORDER BY l.score DESC LIMIT ?1")
    List<LeaderboardEntry> findTopPlayersGlobal(int limit);
    
    @Query("SELECT l FROM LeaderboardEntry l WHERE l.gameId = ?1 ORDER BY l.score DESC LIMIT ?2")
    List<LeaderboardEntry> findTopPlayersByGame(Long gameId, int limit);
    
    @Query("SELECT l FROM LeaderboardEntry l WHERE l.gameId = ?1 AND l.country = ?2 ORDER BY l.score DESC LIMIT ?3")
    List<LeaderboardEntry> findTopPlayersByCountry(Long gameId, String country, int limit);
}
