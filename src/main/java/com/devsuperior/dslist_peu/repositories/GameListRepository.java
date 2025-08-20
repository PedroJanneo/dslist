package com.devsuperior.dslist_peu.repositories;

import com.devsuperior.dslist_peu.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList,Long> {

}
