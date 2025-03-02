package com.games.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.games.dto.PlayerDto;
import com.games.dto.PlayerProgressionDto;
import com.games.entity.LeaderboardEntry;
import com.games.entity.PlayerEntity;
import com.games.entity.PlayerProgressionEntity;
import com.games.repository.PlayerRepository;
import com.games.service.PlayerService;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private PlayerDto player;

	
	@PostMapping("/register")
	public ResponseEntity<String> newRegisteration(@RequestBody(required = true) PlayerEntity player) {
		
		playerService.registerUser(player);
		return ResponseEntity.status(201).body("Player registered successfully");
	}
	
	@PostMapping("/playerProgress")
	public ResponseEntity<String> saveProgression(@RequestBody(required = true) PlayerProgressionEntity player) {

		playerService.saveProgress(player);
		return ResponseEntity.status(201).body("Player progression saved successfully");
	}
	
	@PostMapping("/submitScore")
	public ResponseEntity<String> saveScore(@RequestBody(required = true) LeaderboardEntry entry) {
		
		playerService.submitScores(entry);
		        return ResponseEntity.status(201).body("Score submitted successfully");
		    }
	
	@GetMapping("/top-players/global")
    public ResponseEntity<List<LeaderboardEntry>> getTopPlayersGlobal(@RequestParam (required = true) int limit) {
		
		
        return ResponseEntity.ok(playerService.getTopPlayersGlobal(limit));
    }

    @GetMapping("/top-players/game")
    public ResponseEntity<List<LeaderboardEntry>> getTopPlayersByGame(@RequestParam(required = true) Long gameId, @RequestParam(required = true) int limit) {
        return ResponseEntity.ok(playerService.getTopPlayersByGame(gameId, limit));
    }

    @GetMapping("/top-players/country")
    public ResponseEntity<List<LeaderboardEntry>> getTopPlayersByCountry(@RequestParam(required = true) Long gameId, @RequestParam(required = true)
    String country, @RequestParam(required = true) int limit) {
        return ResponseEntity.ok(playerService.getTopPlayersByCountry(gameId, country, limit));
    }
}
