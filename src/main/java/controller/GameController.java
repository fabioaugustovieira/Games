package com.example.gameapi.controller;

import com.example.gameapi.model.Game;
import com.example.gameapi.repository.GameRepository;
import com.example.gameapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    public ResponseEntity<Game> createGame(@Valid @RequestBody Game game) {
        // Verifique se a categoria existe
        if (!categoryRepository.existsById(game.getCategory().getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Game savedGame = gameRepository.save(game);
        return new ResponseEntity<>(savedGame, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Game>> getAllGames() {
        return new ResponseEntity<>(gameRepository.findAll(), HttpStatus.OK);
    }
}
