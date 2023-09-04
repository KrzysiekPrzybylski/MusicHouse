package pl.przybylski.MusicHouse.repo;

import pl.przybylski.MusicHouse.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepo extends JpaRepository<Album, Long> {
}
