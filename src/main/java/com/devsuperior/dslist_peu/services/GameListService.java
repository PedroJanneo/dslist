package com.devsuperior.dslist_peu.services;



import com.devsuperior.dslist_peu.dto.GameListDTO;
import com.devsuperior.dslist_peu.entities.GameList;
import com.devsuperior.dslist_peu.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }
}