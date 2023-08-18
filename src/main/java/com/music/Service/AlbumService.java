package com.music.Service;

import com.music.Album;
import com.music.Repository.AlbumRepository;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }
    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }
}
