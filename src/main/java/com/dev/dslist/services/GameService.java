package com.dev.dslist.services;

import com.dev.dslist.dto.GameDTO;
import com.dev.dslist.dto.GameMinDTO;
import com.dev.dslist.entities.Game;
import com.dev.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // ou @Component
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long gameId){
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
}
