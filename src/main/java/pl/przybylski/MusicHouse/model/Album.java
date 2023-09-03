package pl.przybylski.MusicHouse.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price;
    @ManyToMany
    private List<Song> songs = new ArrayList<>();
    @ManyToMany
    private List<Artist> artists = new ArrayList<>();

    public Album() {
    }

    public Album(String name, String price, List<Song> songs, List<Artist> artists) {
        this.name = name;
        this.price = price;
        this.songs = songs;
        this.artists = artists;
    }
    public void addSong(Song song) {
        songs.add(song);
    }

    public void addArtists(Artist artist) {
        artists.add(artist);
    }

    //gettery i settery

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
