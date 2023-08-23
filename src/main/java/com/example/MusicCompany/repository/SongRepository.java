package com.example.MusicCompany.repository;

import com.example.MusicCompany.model.Album;
import com.example.MusicCompany.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
}
