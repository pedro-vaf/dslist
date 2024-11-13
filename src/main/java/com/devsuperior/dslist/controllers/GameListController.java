package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController /* Torna a classe um controlador */
@RequestMapping(value = "/lists") /* Caminho de reposta da API */
public class GameListController {

    @Autowired
    private GameListService gameListService; /* Injeta a classe service */

    @Autowired
    private GameService gameService;

    @GetMapping /* Mapea com método HTTP */
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")/* Mapea com método HTTP */
    public List<GameMinDTO> findByList(@PathVariable /*Configura o ID na requisição*/ Long listId){
        List<GameMinDTO> result = gameService.findBylist(listId);
        return result;
    }
}
