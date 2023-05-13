package com.dev.dslist.services;

import com.dev.dslist.dto.GameListDTO;
import com.dev.dslist.entities.GameList;
import com.dev.dslist.repositories.GameListRepository;
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
