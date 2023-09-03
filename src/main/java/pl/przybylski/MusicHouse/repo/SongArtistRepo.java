package pl.przybylski.MusicHouse.repo;

import pl.przybylski.MusicHouse.model.SongArtist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongArtistRepo extends JpaRepository<SongArtist, Long> {
}
