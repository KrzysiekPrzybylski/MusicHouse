package pl.przybylski.MusicHouse.repo;

import pl.przybylski.MusicHouse.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepo extends JpaRepository<Artist, Long> {
}
