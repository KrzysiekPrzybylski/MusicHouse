package pl.przybylski.MusicHouse.repo;

import pl.przybylski.MusicHouse.model.AlbumArtist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumArtistRepo extends JpaRepository<AlbumArtist, Long> {
}
