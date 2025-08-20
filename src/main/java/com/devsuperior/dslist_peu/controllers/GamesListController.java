package com.devsuperior.dslist_peu.controllers;


import com.devsuperior.dslist_peu.dto.GameListDTO;
import com.devsuperior.dslist_peu.dto.GameMinDTO;
import com.devsuperior.dslist_peu.services.GameListService;
import com.devsuperior.dslist_peu.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists") //Define o caminho base da API (endpoint)
public class GamesListController {


    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;



    @GetMapping // Especifica que o metodo responde a requisições HTTP GET.
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games") // {listId}-> ID da list; /games -> endpoint
    public List<GameMinDTO> findByList(@PathVariable long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }
}
