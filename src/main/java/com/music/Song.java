package com.music;
import jakarta.persistence.*;
import org.hibernate.mapping.List;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name='songs')
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String songName;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToMany(mappedBy = "songs")
    private List<Artist> artists = new ArrayList<>();
}
