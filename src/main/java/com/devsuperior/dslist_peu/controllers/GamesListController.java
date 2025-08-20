package com.devsuperior.dslist_peu.controllers;


import com.devsuperior.dslist_peu.dto.GameListDTO;
import com.devsuperior.dslist_peu.dto.GameMinDTO;
import com.devsuperior.dslist_peu.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists") //Define o caminho base da API
public class GamesListController {


    @Autowired
    private GameListService gameListService;



    @GetMapping // Especifica que o metodo responde a requisições HTTP GET.
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }
}
