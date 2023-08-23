package com.example.MusicCompany.controller;

import com.example.MusicCompany.model.*;
import com.example.MusicCompany.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/app")
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private AlbumSongRepository albumSongRepository;

    @Autowired
    private AlbumArtistRepository albumArtistRepository;

    @Autowired
    private SongArtistRepository songArtistRepository;

    @GetMapping("/add-album")
    public String showAddAlbumForm(Model model) {
        model.addAttribute("latestID", getLatestID() + 1);
        model.addAttribute("allArtist", artistRepository.findAll());
        model.addAttribute("allSongs", songRepository.findAll());
        return "addAlbum";
    }

    @PostMapping("/add-song")
    public String updateAlbum(@RequestParam Long id, Model model, @RequestParam(required = false) String name,
                              @RequestParam(required = false) String price, @RequestParam(required = false) Song songName,
                              @RequestParam(required = false) List<Artist> selectedValues) {
        if (selectedValues == null) {
            selectedValues = List.of();

        }
        if (albumRepository.findById(id).isEmpty()) {
            Album album = new Album(name, price, List.of(songName), selectedValues);
            albumRepository.save(album);
        } else {
            System.out.println(id);
            AlbumSong albumSong = new AlbumSong();
            albumSong.setAlbum(albumRepository.findById(id).get());
            albumSong.setSong(songName);
            albumSongRepository.save(albumSong);

            for (Artist artist : selectedValues) {
                AlbumArtist albumArtist = new AlbumArtist();
                albumArtist.setAlbum(albumRepository.findById(id).get());
                albumArtist.setArtist(artist);
                albumArtistRepository.save(albumArtist);
            }

            for (Artist artist : selectedValues) {
                SongArtist songArtist = new SongArtist();
                songArtist.setArtist(artist);
                songArtist.setSong(songName);
                songArtistRepository.save(songArtist);
            }
        }
        model.addAttribute("latestID", getLatestID());
        model.addAttribute("album", albumRepository.findById(id));
        model.addAttribute("allArtist", artistRepository.findAll());
        model.addAttribute("allSongs", songRepository.findAll());
        return "addAlbumWithID";
    }

    public Long getLatestID() {
        List<Long> ids = new ArrayList<>();
        for (Album album : albumRepository.findAll()) {
            ids.add(album.getId());
        }
        return Collections.max(ids);
    }

}