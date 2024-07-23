package com.example.validate_inf_music.repositories;

import com.example.validate_inf_music.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepo extends JpaRepository<Song, Long> {
}
