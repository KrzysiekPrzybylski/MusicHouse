package pl.przybylski.MusicHouse.repository;

import pl.przybylski.MusicHouse.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
}
