package pl.przybylski.MusicHouse.controller;

import pl.przybylski.MusicHouse.repo.AlbumRepo;
import pl.przybylski.MusicHouse.repo.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/start")
public class OfferController {

    @Autowired
    private AlbumRepo albumRepo;
    @Autowired
    private SongRepo songRepo;

    @GetMapping("/offer")
    public String showAllAlbums(Model model) {
        model.addAttribute("albums", albumRepo.findAll());
        return "offer";
    }

    @GetMapping("/details")
    public String showAlbum(@RequestParam Long id, Model model) {
        model.addAttribute("album", albumRepo.findById(id));
        return "oneAlbum";
    }


}