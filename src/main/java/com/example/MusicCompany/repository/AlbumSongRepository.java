package com.example.MusicCompany.repository;

import com.example.MusicCompany.model.AlbumSong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumSongRepository extends JpaRepository<AlbumSong, Long> {
}
