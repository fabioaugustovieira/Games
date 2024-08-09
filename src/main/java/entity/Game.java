package com.example.gameapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Game {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Getters e Setters
}
