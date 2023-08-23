package com.example.MusicCompany.controller;

import com.example.MusicCompany.model.Artist;
import com.example.MusicCompany.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/app")
public class ArtistController {

    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/add-artist")
    public String artistForm(Model model) {
        model.addAttribute("artist", new Artist());
        return "addArtist";
    }

    @PostMapping("/add-artist")
    public String addArtist(@ModelAttribute Artist artist) {
        artistRepository.save(artist);
        return "redirect:/app";
    }

}

