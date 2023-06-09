package com.dev.gameslist.services;

import com.dev.gameslist.dto.GameDTO;
import com.dev.gameslist.dto.GameMinDTO;
import com.dev.gameslist.entities.Game;
import com.dev.gameslist.projections.GameMinProjection;
import com.dev.gameslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // ou @Component
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long gameId) {
        Game result = gameRepository.findById(gameId).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> resultado = gameRepository.findAll();
        List<GameMinDTO> resultadoDto = resultado.stream().map(x -> new GameMinDTO(x)).toList();
        return resultadoDto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> resultado = gameRepository.searchByList(listId);
        List<GameMinDTO> resultadoDto = resultado.stream().map(x -> new GameMinDTO(x)).toList();
        return resultadoDto;
    }
}
