package com.games.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.games.entity.PlayerProgressionEntity;

@Repository
public interface PlayerProgressionRepository extends JpaRepository<PlayerProgressionEntity, Integer>{
	
	
}
