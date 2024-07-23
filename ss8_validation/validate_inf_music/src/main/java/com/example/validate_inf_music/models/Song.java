package com.example.validate_inf_music.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "songs")
@Data
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String name;
    @Column(columnDefinition = "TEXT")
    private String singer;
    @Column(columnDefinition = "TEXT")
    private String genre;
}
