package com.games.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.games.entity.PlayerEntity;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {

	@Query(value = "Select count(*) from games.player where username =: username", nativeQuery = true)
	Integer findByUsername(@Param("username")String username);

}
