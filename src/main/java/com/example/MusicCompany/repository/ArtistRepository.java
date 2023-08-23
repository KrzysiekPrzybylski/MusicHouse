package com.example.MusicCompany.repository;

import com.example.MusicCompany.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
