package com.devsuperior.dslist_peu.repositories;

import com.devsuperior.dslist_peu.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {

}
