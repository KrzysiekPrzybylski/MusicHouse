package com.example.MusicCompany.repository;

import com.example.MusicCompany.model.SongArtist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongArtistRepository extends JpaRepository<SongArtist, Long> {
}
