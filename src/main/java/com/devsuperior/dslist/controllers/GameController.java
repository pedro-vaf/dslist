package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController /* Torna a classe um controlador */
@RequestMapping(value = "/games") /* Caminho de reposta da API */
public class GameController {

    @Autowired
    private GameService gameService; /* Injeta a classe service */

    @GetMapping(value = "/{id}")/* Mapea com método HTTP */
    public GameDTO findById(@PathVariable /*Configura o ID na requisição*/ Long id){
        GameDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping /* Mapea com método HTTP */
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }
}
