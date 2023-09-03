package pl.przybylski.MusicHouse.repository;

import pl.przybylski.MusicHouse.model.AlbumSong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumSongRepository extends JpaRepository<AlbumSong, Long> {
}
