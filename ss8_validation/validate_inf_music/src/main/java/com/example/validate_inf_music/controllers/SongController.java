package com.example.validate_inf_music.controllers;

import com.example.validate_inf_music.dto.SongDTO;
import com.example.validate_inf_music.models.Song;
import com.example.validate_inf_music.services.ISongService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping("list")
    public String showList(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "songList";
    }


    @GetMapping("songs")
    public String showSongForm(Model model) {
        model.addAttribute("songDTO", new SongDTO());
        return "songForm";
    }

    @PostMapping("songs")
    public String submitSongForm(@Valid @ModelAttribute("songDTO") SongDTO songDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "songForm";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDTO, song);
        songService.save(song);
        model.addAttribute("songs", songService.findAll());
        return "songList";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Song song = songService.findById(id);
        SongDTO songDTO = new SongDTO();
        BeanUtils.copyProperties(song, songDTO);
        model.addAttribute("id", song.getId());
        model.addAttribute("songDTO", songDTO);
        return "editSong";
    }

    @PostMapping("update/{id}")
    public String updateSong(@PathVariable("id") long id, @Valid SongDTO songDTO, BindingResult result, Model model) {
        Song song = new Song();
        if (result.hasErrors()) {
            return "editSong";
        }
        song.setId(id);
        BeanUtils.copyProperties(songDTO, song);
        songService.save(song);
        model.addAttribute("songs", songService.findAll());
        return "songList";
    }
}
