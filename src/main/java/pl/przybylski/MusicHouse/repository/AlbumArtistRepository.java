package pl.przybylski.MusicHouse.repository;

import pl.przybylski.MusicHouse.model.AlbumArtist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumArtistRepository extends JpaRepository<AlbumArtist, Long> {
}
