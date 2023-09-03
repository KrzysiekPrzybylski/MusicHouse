package pl.przybylski.MusicHouse.repository;

import pl.przybylski.MusicHouse.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
