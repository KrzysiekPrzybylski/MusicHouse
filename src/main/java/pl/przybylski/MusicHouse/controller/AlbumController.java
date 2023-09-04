package pl.przybylski.MusicHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.przybylski.MusicHouse.model.*;
import pl.przybylski.MusicHouse.repo.*;
import java.util.*;

@Controller
@RequestMapping("/start")
public class AlbumController {

    @Autowired
    private AlbumRepo albumRepo;

    @Autowired
    private ArtistRepo artistRepo;

    @Autowired
    private SongRepo songRepo;

    @Autowired
    private AlbumSongRepo albumSongRepo;

    @Autowired
    private AlbumArtistRepo albumArtistRepo;

    @Autowired
    private SongArtistRepo songArtistRepo;

    @GetMapping("/add-album")
    public String showAddAlbumForm(Model model) {
        model.addAttribute("latestID", getLatestID() + 1);
        model.addAttribute("allArtist", artistRepo.findAll());
        model.addAttribute("allSongs", songRepo.findAll());
        return "addAlbum";
    }

    @PostMapping("/add-song")
    public String updateAlbum(@RequestParam Long id, Model model, @RequestParam(required = false) String name,
                              @RequestParam(required = false) String price, @RequestParam(required = false) Song songName,
                              @RequestParam(required = false) List<Artist> selectedValues) {
        if (selectedValues == null) {
            selectedValues = List.of();
        }
        if (albumRepo.findById(id).isEmpty()) {
            Album album = new Album(name, price, List.of(songName), selectedValues);
            addArtistToSong(songName, selectedValues);
            albumRepo.save(album);
        } else {
            addAlbumToSong(albumRepo.findById(id).get(), songName);
            addArtistsToAlbum(albumRepo.findById(id).get(), selectedValues);
            addArtistToSong(songName, selectedValues);
        }
        model.addAttribute("allSongs", songRepo.findAll());
        model.addAttribute("album", albumRepo.findById(id));
        model.addAttribute("latestID", getLatestID());
        model.addAttribute("allArtist", artistRepo.findAll());
        
        return "addAlbumId";
    }
    public void addArtistToSong(Song song, List<Artist> artists) {
        for (Artist artist : artists) {
            SongArtist songArtist = new SongArtist();
            songArtist.setArtist(artist);
            songArtist.setSong(song);
            songArtistRepo.save(songArtist);
        }
    }
    public void addAlbumToSong(Album album, Song song) {
        AlbumSong albumSong = new AlbumSong();
        albumSong.setAlbum(album);
        albumSong.setSong(song);
        albumSongRepo.save(albumSong);
    }
    public Long getLatestID() {
        List<Long> ids = new ArrayList<>();
        for (Album album : albumRepo.findAll()) {
            ids.add(album.getId());
        }
        return Collections.max(ids);
    }
    public void addArtistsToAlbum(Album album, List<Artist> artists) {
        for (Artist artist : artists) {
            AlbumArtist albumArtist = new AlbumArtist();
            albumArtist.setAlbum(album);
            albumArtist.setArtist(artist);
            albumArtistRepo.save(albumArtist);
        }
    }

}