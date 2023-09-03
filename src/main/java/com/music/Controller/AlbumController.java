package com.music.Controller;

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
            addArtistToSong(songName, selectedValues);
            albumRepository.save(album);
        } else {
            addAlbumToSong(albumRepository.findById(id).get(), songName);
            addArtistsToAlbum(albumRepository.findById(id).get(), selectedValues);
            addArtistToSong(songName, selectedValues);
        }
        model.addAttribute("latestID", getLatestID());
        model.addAttribute("album", albumRepository.findById(id));
        model.addAttribute("allArtist", artistRepository.findAll());
        model.addAttribute("allSongs", songRepository.findAll());
        return "addAlbumWithID";
    }

    public void addAlbumToSong(Album album, Song song) {
        AlbumSong albumSong = new AlbumSong();
        albumSong.setAlbum(album);
        albumSong.setSong(song);
        albumSongRepository.save(albumSong);
    }


    public void addArtistsToAlbum(Album album, List<Artist> artists) {
        for (Artist artist : artists) {
            AlbumArtist albumArtist = new AlbumArtist();
            albumArtist.setAlbum(album);
            albumArtist.setArtist(artist);
            albumArtistRepository.save(albumArtist);
        }
    }


    public void addArtistToSong(Song song, List<Artist> artists) {
        for (Artist artist : artists) {
            SongArtist songArtist = new SongArtist();
            songArtist.setArtist(artist);
            songArtist.setSong(song);
            songArtistRepository.save(songArtist);
        }
    }

    public Long getLatestID() {
        List<Long> ids = new ArrayList<>();
        for (Album album : albumRepository.findAll()) {
            ids.add(album.getId());
        }
        return Collections.max(ids);
    }

}