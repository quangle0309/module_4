package com.example.validate_inf_music.services.impl;


import com.example.validate_inf_music.models.Song;
import com.example.validate_inf_music.repositories.ISongRepo;
import com.example.validate_inf_music.services.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepo songRepo;

    @Override
    public void save(Song song) {
        songRepo.save(song);
    }

    @Override
    public List<Song> findAll() {
        return songRepo.findAll();
    }

    @Override
    public Song findById(long id) {
        return songRepo.findById(id).orElse(null);
    }
}
