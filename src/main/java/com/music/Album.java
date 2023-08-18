package com.music;

import jakarta.persistence.*;
import org.hibernate.mapping.List;

import java.util.ArrayList;
@Entity
@Table(name = "albums")

public class Album {
    @Id
    @GeneratedValue
    private Long id;
    private String songName;
    private double suggestedPrice;
    @OneToMany(mappedBy = "album")
    private List<Song> songs = new ArrayList<>();
}
