package com.devsuperior.dslist_peu.services;

import com.devsuperior.dslist_peu.dto.GameDTO;
import com.devsuperior.dslist_peu.dto.GameMinDTO;
import com.devsuperior.dslist_peu.entities.Game;
import com.devsuperior.dslist_peu.projections.GameMinProjection;
import com.devsuperior.dslist_peu.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findByID(Long id){
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;

    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
       List<Game> result = gameRepository.findAll();
       List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(long listId){
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return  result.stream().map(x-> new GameMinDTO(x)).toList();
    }



}
