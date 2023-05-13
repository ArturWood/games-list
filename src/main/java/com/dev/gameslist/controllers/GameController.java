package com.dev.gameslist.controllers;

import com.dev.gameslist.dto.GameDTO;
import com.dev.gameslist.dto.GameMinDTO;
import com.dev.gameslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{gameId}")
    public GameDTO findById(@PathVariable Long gameId){
        GameDTO result = gameService.findById(gameId);
        return result;
    }

    @GetMapping
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }
}
