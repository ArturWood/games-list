package com.dev.gameslist.services;

import com.dev.gameslist.dto.GameListDTO;
import com.dev.gameslist.entities.GameList;
import com.dev.gameslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // ou @Component
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> resultado = gameListRepository.findAll();
        List<GameListDTO> resultadoDto = resultado.stream().map(x -> new GameListDTO(x)).toList();
        return resultadoDto;
    }
}
