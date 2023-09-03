package pl.przybylski.MusicHouse.repository;

import pl.przybylski.MusicHouse.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
