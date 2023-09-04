package pl.przybylski.MusicHouse.repo;

import pl.przybylski.MusicHouse.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepo extends JpaRepository<Song, Long> {
}
