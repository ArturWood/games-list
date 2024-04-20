package com.dev.gameslist.services;

import com.dev.gameslist.dto.GameDTO;
import com.dev.gameslist.dto.GameMinDTO;
import com.dev.gameslist.entities.Game;
import com.dev.gameslist.infra.exception.GameNotFoundException;
import com.dev.gameslist.repositories.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameServiceTest {

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private GameService gameService;

    @BeforeEach
    void setUp() {
        reset(gameRepository);
    }

    @Test
    @DisplayName("Deveria retornar GameDTO da função findById")
    void scenario01() {
        // Arrange
        Long gameId = 1L;
        Game game = new Game(
                1L,
                "title",
                2010,
                "genre",
                "platforms",
                8.9,
                "www.image.com",
                "description",
                "long description"
        );
        when(gameRepository.findById(gameId)).thenReturn(Optional.of(game));

        // Act
        GameDTO result = gameService.findById(gameId);

        // Assert
        assertNotNull(result);
    }

    @Test
    @DisplayName("Throws Exception GameNotFoundException passando um ID não existente na função findById")
    void scenario02() {
        // Arrange
        Long gameId = 1L;
        when(gameRepository.findById(gameId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(GameNotFoundException.class, () -> gameService.findById(gameId));
    }

    @Test
    @DisplayName("Deveria retornar uma lista de GameDTO da função findAll")
    void scenario03() {
        // Arrange
        Game game1 = new Game(
                1L,
                "title",
                2010,
                "genre",
                "platforms",
                8.9,
                "www.image.com",
                "description",
                "long description"
        );
        Game game2 = new Game(
                2L,
                "title",
                2010,
                "genre",
                "platforms",
                8.9,
                "www.image.com",
                "description",
                "long description"
        );
        List<Game> games = Arrays.asList(game1, game2);
        when(gameRepository.findAll()).thenReturn(games);

        // Act
        List<GameMinDTO> result = gameService.findAll();

        // Assert
        assertNotNull(result);
        assertEquals(games.size(), result.size());
    }
}
