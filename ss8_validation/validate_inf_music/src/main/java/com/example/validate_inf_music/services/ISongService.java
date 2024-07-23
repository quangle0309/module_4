package com.example.validate_inf_music.services;
import com.example.validate_inf_music.models.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    void save(Song song);

    List<Song> findAll();

    Song findById(long id);
}
