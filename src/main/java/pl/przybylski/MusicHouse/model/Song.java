package pl.przybylski.MusicHouse.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "song_album",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "album_id")
    )
    private List<Album> album;

    @ManyToMany
    @JoinTable(
            name = "song_artist",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private List<Artist> artists;

    public void addArtist(Artist artist) {
        artists.add(artist);
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public List<Album> getAlbum_id() {
        return album;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
}