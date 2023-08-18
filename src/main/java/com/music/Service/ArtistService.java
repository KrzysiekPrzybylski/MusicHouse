package com.music.Service;

import com.music.Artist;
import com.music.Repository.ArtistRepository;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }
    public void saveArtist(Artist artist) {
        artistRepository.save(artist);
    }
}
