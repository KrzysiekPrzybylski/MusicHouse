package pl.przybylski.MusicHouse.repository;

import pl.przybylski.MusicHouse.model.SongArtist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongArtistRepository extends JpaRepository<SongArtist, Long> {
}
