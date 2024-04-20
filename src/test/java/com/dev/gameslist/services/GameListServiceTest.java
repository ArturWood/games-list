package com.dev.gameslist.services;

import com.dev.gameslist.dto.GameListDTO;
import com.dev.gameslist.entities.GameList;
import com.dev.gameslist.projections.GameMinProjection;
import com.dev.gameslist.repositories.GameListRepository;
import com.dev.gameslist.repositories.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class GameListServiceTest {

    @InjectMocks
    private GameListService gameListService;

    @Mock
    private GameListRepository gameListRepository;

    @Mock
    private GameRepository gameRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Deveria devolver uma lista de games")
    public void scenario01() {
        // Arrange
        List<GameList> gameLists = new ArrayList<>();
        gameLists.add(new GameList());
        gameLists.add(new GameList());

        when(gameListRepository.findAll()).thenReturn(gameLists);

        // Act
        List<GameListDTO> result = gameListService.findAll();

        // Assert
        assertEquals(gameLists.size(), result.size());
    }

    @Test
    @DisplayName("Deveria alterar a posição do game na lista do BD")
    public void scenario02() {
        // Arrange
        Long listId = 1L;
        int sourceIndex = 0;
        int destinationIndex = 1;

        List<GameMinProjection> list = new ArrayList<>();
        GameMinProjection game1 = mock(GameMinProjection.class);
        GameMinProjection game2 = mock(GameMinProjection.class);
        list.add(game1);
        list.add(game2);

        when(gameRepository.searchByList(listId)).thenReturn(list);

        // Act
        gameListService.move(listId, sourceIndex, destinationIndex);

        // Assert
        verify(gameListRepository, times(2)).updateBelongingPosition(anyLong(), anyLong(), anyInt());
    }
}
