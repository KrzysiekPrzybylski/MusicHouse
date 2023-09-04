package pl.przybylski.MusicHouse.repo;

import pl.przybylski.MusicHouse.model.AlbumSong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumSongRepo extends JpaRepository<AlbumSong, Long> {
}
