package com.dev.gameslist.controllers;

import com.dev.gameslist.dto.GameListDTO;
import com.dev.gameslist.dto.GameMinDTO;
import com.dev.gameslist.dto.UpdateDTO;
import com.dev.gameslist.services.GameListService;
import com.dev.gameslist.services.GameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{listId}/games")
    public ResponseEntity<List<GameMinDTO>> findByList(@PathVariable Long listId) {
        List<GameMinDTO> result = gameService.findByList(listId);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{listId}/update")
    public ResponseEntity move(@PathVariable Long listId, @RequestBody @Valid UpdateDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
        return ResponseEntity.ok().build();
    }
}
